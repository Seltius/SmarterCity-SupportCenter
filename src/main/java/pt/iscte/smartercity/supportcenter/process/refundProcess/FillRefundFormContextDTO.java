package pt.iscte.smartercity.supportcenter.process.refundProcess;

import org.akip.service.dto.TaskInstanceDTO;
import pt.iscte.smartercity.supportcenter.service.dto.RefundProcessDTO;

public class FillRefundFormContextDTO {

    private RefundProcessDTO refundProcess;
    private TaskInstanceDTO taskInstance;

    public RefundProcessDTO getRefundProcess() {
        return refundProcess;
    }

    public void setRefundProcess(RefundProcessDTO refundProcess) {
        this.refundProcess = refundProcess;
    }

    public TaskInstanceDTO getTaskInstance() {
        return taskInstance;
    }

    public void setTaskInstance(TaskInstanceDTO taskInstance) {
        this.taskInstance = taskInstance;
    }
}
