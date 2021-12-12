package pt.iscte.smartercity.supportcenter.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.iscte.smartercity.supportcenter.service.MessageService;
import pt.iscte.smartercity.supportcenter.service.dto.SupportDTO;
import pt.iscte.smartercity.supportcenter.service.dto.SupportProcessDTO;
import pt.iscte.smartercity.supportcenter.util.MessageUtil;

@Component
public class UserMessageDelegate implements JavaDelegate {

    private static final Logger log = LoggerFactory.getLogger(UserMessageDelegate.class);

    @Autowired
    MessageService messageService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("RUNNING DELEGATE TASK: UserMessageDelegate");

        //GET PROCESS INSTANCE
        SupportProcessDTO supportProcess = (SupportProcessDTO) delegateExecution.getVariable("processInstance");
        SupportDTO support = supportProcess.getSupport();

        //CREATE NEW SUPPORT MESSAGE
        messageService.save(MessageUtil.createMessage(support.getSupportId(), support.getMessage(), "REQUESTER"));
    }
}
