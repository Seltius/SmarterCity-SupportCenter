package pt.iscte.smartercity.supportcenter.delegate;

import java.util.Date;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pt.iscte.smartercity.supportcenter.service.dto.RefundProcessDTO;
import pt.iscte.smartercity.supportcenter.service.dto.SupportProcessDTO;

@Component
public class ProcessRefundDelegate implements JavaDelegate {

    private static final Logger log = LoggerFactory.getLogger(ProcessRefundDelegate.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        //GET PROCESS INSTANCE
        RefundProcessDTO refundProcess = (RefundProcessDTO) delegateExecution.getVariable("processInstance");

        //CALL FINANCIAL PARTNER API TO PROCESS REFUND (DUMMY PRINT)
        log.info("RefundDelegate: ###########################################");
        log.info("RefundDelegate: ###########################################");
        log.info("RefundDelegate: ###########################################");
        log.info("RefundDelegate:        REFUND CONFIRMED (RefundId:" + refundProcess.getRefund().getRefundId() + ")");
        log.info("RefundDelegate: ###########################################");
        log.info("RefundDelegate: ###########################################");
        log.info("RefundDelegate: ###########################################\n\n\n");
    }
}
