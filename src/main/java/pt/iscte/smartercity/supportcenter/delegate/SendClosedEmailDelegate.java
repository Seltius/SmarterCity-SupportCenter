package pt.iscte.smartercity.supportcenter.delegate;

import java.util.Locale;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import pt.iscte.smartercity.supportcenter.service.MailService;
import pt.iscte.smartercity.supportcenter.service.SupportService;
import pt.iscte.smartercity.supportcenter.service.dto.SupportProcessDTO;

@Component
public class SendClosedEmailDelegate implements JavaDelegate {

    private static final Logger log = LoggerFactory.getLogger(SendClosedEmailDelegate.class);

    @Autowired
    SupportService supportService;

    @Autowired
    MailService mailService;

    @Autowired
    SpringTemplateEngine templateEngine;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("RUNNING DELEGATE TASK: SendClosedEmailDelegate");
        Context context = new Context(Locale.getDefault());

        //GET PROCESS INSTANCE
        SupportProcessDTO supportProcess = (SupportProcessDTO) delegateExecution.getVariable("processInstance");

        //PREPARE EMAIL
        String to = supportProcess.getSupport().getEmail();
        String subject = "[SmarterCity] Support Request Nr." + supportProcess.getSupport().getSupportId();
        context.setVariable("support", supportProcess.getSupport());
        String content = templateEngine.process("mail/fixedSupportRequest", context);

        //SEND E-MAIL
        mailService.sendEmail(to, subject, content, false, true);
    }
}
