package pt.iscte.smartercity.supportcenter.process.supportProcess;

import org.akip.repository.TaskInstanceRepository;
import org.akip.service.TaskInstanceService;
import org.akip.service.dto.TaskInstanceDTO;
import org.akip.service.mapper.TaskInstanceMapper;
import org.springframework.stereotype.Component;
import pt.iscte.smartercity.supportcenter.repository.SupportProcessRepository;
import pt.iscte.smartercity.supportcenter.service.SupportService;
import pt.iscte.smartercity.supportcenter.service.dto.SupportDTO;
import pt.iscte.smartercity.supportcenter.service.dto.SupportProcessDTO;
import pt.iscte.smartercity.supportcenter.service.mapper.SupportProcessMapper;

@Component
public class ProvideSupportResponseService {

    private final TaskInstanceService taskInstanceService;

    private final SupportService supportService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final SupportProcessRepository supportProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final ProvideSupportResponseMapper provideSupportResponseMapper;

    private final SupportProcessMapper supportProcessMapper;

    public ProvideSupportResponseService(
        TaskInstanceService taskInstanceService,
        SupportService supportService,
        TaskInstanceRepository taskInstanceRepository,
        SupportProcessRepository supportProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        ProvideSupportResponseMapper provideSupportResponseMapper,
        SupportProcessMapper supportProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.supportService = supportService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.supportProcessRepository = supportProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.provideSupportResponseMapper = provideSupportResponseMapper;
        this.supportProcessMapper = supportProcessMapper;
    }

    public ProvideSupportResponseContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        SupportProcessDTO supportProcess = supportProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(provideSupportResponseMapper::toSupportProcessDTO)
            .orElseThrow();

        ProvideSupportResponseContextDTO provideSupportResponseContext = new ProvideSupportResponseContextDTO();
        provideSupportResponseContext.setTaskInstance(taskInstanceDTO);
        provideSupportResponseContext.setSupportProcess(supportProcess);

        return provideSupportResponseContext;
    }

    public ProvideSupportResponseContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(ProvideSupportResponseContextDTO provideSupportResponseContext) {
        SupportDTO supportDTO = supportService
            .findOne(provideSupportResponseContext.getSupportProcess().getSupport().getId())
            .orElseThrow();
        supportDTO.setSupportId(provideSupportResponseContext.getSupportProcess().getSupport().getSupportId());
        supportDTO.setStartDate(provideSupportResponseContext.getSupportProcess().getSupport().getStartDate());
        supportDTO.setUserName(provideSupportResponseContext.getSupportProcess().getSupport().getUserName());
        supportDTO.setEmail(provideSupportResponseContext.getSupportProcess().getSupport().getEmail());
        supportDTO.setMessage(provideSupportResponseContext.getSupportProcess().getSupport().getMessage());
        supportDTO.setSupportMessage(provideSupportResponseContext.getSupportProcess().getSupport().getSupportMessage());
        supportService.save(supportDTO);
    }

    public void complete(ProvideSupportResponseContextDTO provideSupportResponseContext) {
        save(provideSupportResponseContext);
        SupportProcessDTO supportProcess = supportProcessRepository
            .findByProcessInstanceId(provideSupportResponseContext.getSupportProcess().getProcessInstance().getId())
            .map(supportProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(provideSupportResponseContext.getTaskInstance(), supportProcess);
    }
}
