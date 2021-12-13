package pt.iscte.smartercity.supportcenter.process.refundProcess;

import org.akip.repository.TaskInstanceRepository;
import org.akip.service.TaskInstanceService;
import org.akip.service.dto.TaskInstanceDTO;
import org.akip.service.mapper.TaskInstanceMapper;
import org.springframework.stereotype.Component;
import pt.iscte.smartercity.supportcenter.repository.RefundProcessRepository;
import pt.iscte.smartercity.supportcenter.service.RefundService;
import pt.iscte.smartercity.supportcenter.service.dto.RefundDTO;
import pt.iscte.smartercity.supportcenter.service.dto.RefundProcessDTO;
import pt.iscte.smartercity.supportcenter.service.mapper.RefundProcessMapper;

@Component
public class FillRefundFormService {

    private final TaskInstanceService taskInstanceService;

    private final RefundService refundService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final RefundProcessRepository refundProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final FillRefundFormMapper fillRefundFormMapper;

    private final RefundProcessMapper refundProcessMapper;

    public FillRefundFormService(
        TaskInstanceService taskInstanceService,
        RefundService refundService,
        TaskInstanceRepository taskInstanceRepository,
        RefundProcessRepository refundProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        FillRefundFormMapper fillRefundFormMapper,
        RefundProcessMapper refundProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.refundService = refundService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.refundProcessRepository = refundProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.fillRefundFormMapper = fillRefundFormMapper;
        this.refundProcessMapper = refundProcessMapper;
    }

    public FillRefundFormContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        RefundProcessDTO refundProcess = refundProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(fillRefundFormMapper::toRefundProcessDTO)
            .orElseThrow();

        FillRefundFormContextDTO fillRefundFormContext = new FillRefundFormContextDTO();
        fillRefundFormContext.setTaskInstance(taskInstanceDTO);
        fillRefundFormContext.setRefundProcess(refundProcess);

        return fillRefundFormContext;
    }

    public FillRefundFormContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(FillRefundFormContextDTO fillRefundFormContext) {
        RefundDTO refundDTO = refundService.findOne(fillRefundFormContext.getRefundProcess().getRefund().getId()).orElseThrow();
        refundDTO.setAmount(fillRefundFormContext.getRefundProcess().getRefund().getAmount());
        refundDTO.setMethod(fillRefundFormContext.getRefundProcess().getRefund().getMethod());
        refundService.save(refundDTO);
    }

    public void complete(FillRefundFormContextDTO fillRefundFormContext) {
        save(fillRefundFormContext);
        RefundProcessDTO refundProcess = refundProcessRepository
            .findByProcessInstanceId(fillRefundFormContext.getRefundProcess().getProcessInstance().getId())
            .map(refundProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(fillRefundFormContext.getTaskInstance(), refundProcess);
    }
}
