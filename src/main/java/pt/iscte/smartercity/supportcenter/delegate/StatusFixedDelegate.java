package pt.iscte.smartercity.supportcenter.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pt.iscte.smartercity.supportcenter.service.SupportService;
import pt.iscte.smartercity.supportcenter.service.dto.SupportProcessDTO;

public class StatusFixedDelegate implements JavaDelegate {

    private static final Logger log = LoggerFactory.getLogger(StatusFixedDelegate.class);
    private static final String FIXED = "FIXED";

    @Autowired
    SupportService supportService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("RUNNING DELEGATE TASK: StatusFixedDelegate");

        //GET PROCESS INSTANCE
        SupportProcessDTO supportProcess = (SupportProcessDTO) delegateExecution.getVariable("processInstance");

        // SET STATUS TO IN_PROGRESS AND PERSIST
        supportProcess.getSupport().setStatus(FIXED);
        supportService.save(supportProcess.getSupport());
    }
}
