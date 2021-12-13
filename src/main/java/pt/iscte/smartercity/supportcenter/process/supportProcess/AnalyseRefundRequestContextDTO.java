package pt.iscte.smartercity.supportcenter.process.supportProcess;

import org.akip.service.dto.TaskInstanceDTO;
import pt.iscte.smartercity.supportcenter.service.dto.SupportProcessDTO;

public class AnalyseRefundRequestContextDTO {

    private SupportProcessDTO supportProcess;
    private TaskInstanceDTO taskInstance;

    public SupportProcessDTO getSupportProcess() {
        return supportProcess;
    }

    public void setSupportProcess(SupportProcessDTO supportProcess) {
        this.supportProcess = supportProcess;
    }

    public TaskInstanceDTO getTaskInstance() {
        return taskInstance;
    }

    public void setTaskInstance(TaskInstanceDTO taskInstance) {
        this.taskInstance = taskInstance;
    }
}
