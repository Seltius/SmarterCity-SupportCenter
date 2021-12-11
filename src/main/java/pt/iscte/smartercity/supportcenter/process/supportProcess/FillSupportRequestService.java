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
public class FillSupportRequestService {

    private final TaskInstanceService taskInstanceService;

    private final SupportService supportService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final SupportProcessRepository supportProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final FillSupportRequestMapper fillSupportRequestMapper;

    private final SupportProcessMapper supportProcessMapper;

    public FillSupportRequestService(
        TaskInstanceService taskInstanceService,
        SupportService supportService,
        TaskInstanceRepository taskInstanceRepository,
        SupportProcessRepository supportProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        FillSupportRequestMapper fillSupportRequestMapper,
        SupportProcessMapper supportProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.supportService = supportService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.supportProcessRepository = supportProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.fillSupportRequestMapper = fillSupportRequestMapper;
        this.supportProcessMapper = supportProcessMapper;
    }

    public FillSupportRequestContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        SupportProcessDTO supportProcess = supportProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(fillSupportRequestMapper::toSupportProcessDTO)
            .orElseThrow();

        FillSupportRequestContextDTO fillSupportRequestContext = new FillSupportRequestContextDTO();
        fillSupportRequestContext.setTaskInstance(taskInstanceDTO);
        fillSupportRequestContext.setSupportProcess(supportProcess);

        return fillSupportRequestContext;
    }

    public FillSupportRequestContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(FillSupportRequestContextDTO fillSupportRequestContext) {
        SupportDTO supportDTO = supportService.findOne(fillSupportRequestContext.getSupportProcess().getSupport().getId()).orElseThrow();
        supportDTO.setUserName(fillSupportRequestContext.getSupportProcess().getSupport().getUserName());
        supportDTO.setEmail(fillSupportRequestContext.getSupportProcess().getSupport().getEmail());
        supportDTO.setMessage(fillSupportRequestContext.getSupportProcess().getSupport().getMessage());
        supportService.save(supportDTO);
    }

    public void complete(FillSupportRequestContextDTO fillSupportRequestContext) {
        save(fillSupportRequestContext);
        SupportProcessDTO supportProcess = supportProcessRepository
            .findByProcessInstanceId(fillSupportRequestContext.getSupportProcess().getProcessInstance().getId())
            .map(supportProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(fillSupportRequestContext.getTaskInstance(), supportProcess);
    }
}
