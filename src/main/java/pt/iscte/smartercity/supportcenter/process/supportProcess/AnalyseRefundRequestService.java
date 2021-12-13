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
public class AnalyseRefundRequestService {

    private final TaskInstanceService taskInstanceService;

    private final SupportService supportService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final SupportProcessRepository supportProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final AnalyseRefundRequestMapper analyseRefundRequestMapper;

    private final SupportProcessMapper supportProcessMapper;

    public AnalyseRefundRequestService(
        TaskInstanceService taskInstanceService,
        SupportService supportService,
        TaskInstanceRepository taskInstanceRepository,
        SupportProcessRepository supportProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        AnalyseRefundRequestMapper analyseRefundRequestMapper,
        SupportProcessMapper supportProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.supportService = supportService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.supportProcessRepository = supportProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.analyseRefundRequestMapper = analyseRefundRequestMapper;
        this.supportProcessMapper = supportProcessMapper;
    }

    public AnalyseRefundRequestContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        SupportProcessDTO supportProcess = supportProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(analyseRefundRequestMapper::toSupportProcessDTO)
            .orElseThrow();

        AnalyseRefundRequestContextDTO analyseRefundRequestContext = new AnalyseRefundRequestContextDTO();
        analyseRefundRequestContext.setTaskInstance(taskInstanceDTO);
        analyseRefundRequestContext.setSupportProcess(supportProcess);

        return analyseRefundRequestContext;
    }

    public AnalyseRefundRequestContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(AnalyseRefundRequestContextDTO analyseRefundRequestContext) {
        SupportDTO supportDTO = supportService.findOne(analyseRefundRequestContext.getSupportProcess().getSupport().getId()).orElseThrow();
        supportDTO.setSupportId(analyseRefundRequestContext.getSupportProcess().getSupport().getSupportId());
        supportDTO.setCreateDate(analyseRefundRequestContext.getSupportProcess().getSupport().getCreateDate());
        supportDTO.setName(analyseRefundRequestContext.getSupportProcess().getSupport().getName());
        supportDTO.setEmail(analyseRefundRequestContext.getSupportProcess().getSupport().getEmail());
        supportDTO.setIssue(analyseRefundRequestContext.getSupportProcess().getSupport().getIssue());
        supportDTO.setIsValid(analyseRefundRequestContext.getSupportProcess().getSupport().getIsValid());
        supportService.save(supportDTO);
    }

    public void complete(AnalyseRefundRequestContextDTO analyseRefundRequestContext) {
        save(analyseRefundRequestContext);
        SupportProcessDTO supportProcess = supportProcessRepository
            .findByProcessInstanceId(analyseRefundRequestContext.getSupportProcess().getProcessInstance().getId())
            .map(supportProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(analyseRefundRequestContext.getTaskInstance(), supportProcess);
    }
}
