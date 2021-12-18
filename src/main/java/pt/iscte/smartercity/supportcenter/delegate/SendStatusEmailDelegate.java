package pt.iscte.smartercity.supportcenter.delegate;

import java.util.Locale;
import liquibase.pro.packaged.A;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import pt.iscte.smartercity.supportcenter.service.MailService;
import pt.iscte.smartercity.supportcenter.service.SupportProcessService;
import pt.iscte.smartercity.supportcenter.service.SupportService;
import pt.iscte.smartercity.supportcenter.service.dto.RefundProcessDTO;
import pt.iscte.smartercity.supportcenter.service.dto.SupportProcessDTO;

@Component
public class SendStatusEmailDelegate implements JavaDelegate {

    @Autowired
    SupportService supportService;

    @Autowired
    MailService mailService;

    @Autowired
    SpringTemplateEngine templateEngine;

    @Autowired
    SupportProcessService supportProcessService;

    private static final Logger log = LoggerFactory.getLogger(SendStatusEmailDelegate.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("RUNNING DELEGATE TASK: SendStatusEmailDelegate");
        Context context = new Context(Locale.getDefault());
        SupportProcessDTO supportProcess;

        //THIS DELEGATE IS USED TO SEND AN EMAIL IN CASE OF A SUB-PROCESS REFUND HAPPENS OR
        // IF A CERTAIN SUPPORT REQUEST IS A REFUND BUT IT WAS DECLINED
        //WE NEED TO USE INSTANCEOF TO SUPPORT BOTH BEHAVIORS
        Object process = delegateExecution.getVariable("processInstance");
        if (process instanceof RefundProcessDTO) {
            RefundProcessDTO refundProcess = (RefundProcessDTO) process;
            supportProcess = supportProcessService.findByProcessInstanceId(refundProcess.getProcessInstance().getId()).get();
        } else supportProcess = (SupportProcessDTO) process;

        //PREPARE EMAIL
        String to = supportProcess.getSupport().getEmail();
        String subject = "[SmarterCity] Support Request Nr." + supportProcess.getSupport().getSupportId();
        context.setVariable("support", supportProcess.getSupport());
        String content = templateEngine.process("mail/statusRefundRequest", context);

        //SEND E-MAIL
        mailService.sendEmail(to, subject, content, false, true);
    }
}
