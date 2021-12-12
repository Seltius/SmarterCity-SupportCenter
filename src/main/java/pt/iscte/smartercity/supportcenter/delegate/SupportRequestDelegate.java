package pt.iscte.smartercity.supportcenter.delegate;

import java.time.LocalDate;
import java.util.Date;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.iscte.smartercity.supportcenter.service.SupportService;
import pt.iscte.smartercity.supportcenter.service.dto.SupportProcessDTO;

@Component
public class SupportRequestDelegate implements JavaDelegate {

    private static final Logger log = LoggerFactory.getLogger(SupportRequestDelegate.class);

    @Autowired
    SupportService supportService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("RUNNING DELEGATE TASK: SupportRequestDelegate");

        //GET PROCESS INSTANCE
        SupportProcessDTO supportProcess = (SupportProcessDTO) delegateExecution.getVariable("processInstance");

        //GENERATE TICKET ID BASED ON TIMESTAMP
        supportProcess.getSupport().setSupportId(generateUniqueId());

        //GENERATE START DATE AND PERSIST
        supportProcess.getSupport().setCreateDate(LocalDate.now());
        supportService.save(supportProcess.getSupport());
    }

    private Integer generateUniqueId() {
        return (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);
    }
}
