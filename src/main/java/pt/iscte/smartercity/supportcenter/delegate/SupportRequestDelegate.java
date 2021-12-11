package pt.iscte.smartercity.supportcenter.delegate;

import java.time.LocalDate;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.iscte.smartercity.supportcenter.service.SupportService;
import pt.iscte.smartercity.supportcenter.service.dto.SupportProcessDTO;

@Component
public class SupportRequestDelegate implements JavaDelegate {

    @Autowired
    SupportService supportService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        SupportProcessDTO supportProcess = (SupportProcessDTO) delegateExecution.getVariable("processInstance");

        //GENERATE ID //TODO RANDOM ID BASED ON TIMESTAMP
        supportProcess.getSupport().setSupportId(1);

        //GENERATE START DATE
        supportProcess.getSupport().setStartDate(LocalDate.now());

        supportService.save(supportProcess.getSupport());
    }
}
