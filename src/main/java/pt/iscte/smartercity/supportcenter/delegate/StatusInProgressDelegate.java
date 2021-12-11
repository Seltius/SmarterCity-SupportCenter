package pt.iscte.smartercity.supportcenter.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pt.iscte.smartercity.supportcenter.service.dto.SupportProcessDTO;

@Component
public class StatusInProgressDelegate implements JavaDelegate {

    private static final Logger log = LoggerFactory.getLogger(StatusInProgressDelegate.class);

    private static final String IN_PROGRESS = "In Progress";

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.debug("RUNNING DELEGATE TASK: StatusInProgressDelegate");

        //GET PROCESS INSTANCE
        SupportProcessDTO supportProcess = (SupportProcessDTO) delegateExecution.getVariable("processInstance");

        // SET STATUS TO IN_PROGRESS
        supportProcess.getSupport().setStatus(IN_PROGRESS);
    }
}
