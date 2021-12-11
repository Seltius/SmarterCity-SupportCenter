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
public class AnalyseSupportRequestService {

    private final TaskInstanceService taskInstanceService;

    private final SupportService supportService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final SupportProcessRepository supportProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final AnalyseSupportRequestMapper analyseSupportRequestMapper;

    private final SupportProcessMapper supportProcessMapper;

    public AnalyseSupportRequestService(
        TaskInstanceService taskInstanceService,
        SupportService supportService,
        TaskInstanceRepository taskInstanceRepository,
        SupportProcessRepository supportProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        AnalyseSupportRequestMapper analyseSupportRequestMapper,
        SupportProcessMapper supportProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.supportService = supportService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.supportProcessRepository = supportProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.analyseSupportRequestMapper = analyseSupportRequestMapper;
        this.supportProcessMapper = supportProcessMapper;
    }

    public AnalyseSupportRequestContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        SupportProcessDTO supportProcess = supportProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(analyseSupportRequestMapper::toSupportProcessDTO)
            .orElseThrow();

        AnalyseSupportRequestContextDTO analyseSupportRequestContext = new AnalyseSupportRequestContextDTO();
        analyseSupportRequestContext.setTaskInstance(taskInstanceDTO);
        analyseSupportRequestContext.setSupportProcess(supportProcess);

        return analyseSupportRequestContext;
    }

    public AnalyseSupportRequestContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(AnalyseSupportRequestContextDTO analyseSupportRequestContext) {
        SupportDTO supportDTO = supportService.findOne(analyseSupportRequestContext.getSupportProcess().getSupport().getId()).orElseThrow();
        supportDTO.setSupportId(analyseSupportRequestContext.getSupportProcess().getSupport().getSupportId());
        supportDTO.setStartDate(analyseSupportRequestContext.getSupportProcess().getSupport().getStartDate());
        supportDTO.setUserName(analyseSupportRequestContext.getSupportProcess().getSupport().getUserName());
        supportDTO.setEmail(analyseSupportRequestContext.getSupportProcess().getSupport().getEmail());
        supportDTO.setMessage(analyseSupportRequestContext.getSupportProcess().getSupport().getMessage());
        supportDTO.setIsRefund(analyseSupportRequestContext.getSupportProcess().getSupport().getIsRefund());
        supportService.save(supportDTO);
    }

    public void complete(AnalyseSupportRequestContextDTO analyseSupportRequestContext) {
        save(analyseSupportRequestContext);
        SupportProcessDTO supportProcess = supportProcessRepository
            .findByProcessInstanceId(analyseSupportRequestContext.getSupportProcess().getProcessInstance().getId())
            .map(supportProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(analyseSupportRequestContext.getTaskInstance(), supportProcess);
    }
}
