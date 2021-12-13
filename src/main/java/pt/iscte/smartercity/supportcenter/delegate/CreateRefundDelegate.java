package pt.iscte.smartercity.supportcenter.delegate;

import java.util.Date;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.iscte.smartercity.supportcenter.domain.Refund;
import pt.iscte.smartercity.supportcenter.service.RefundProcessService;
import pt.iscte.smartercity.supportcenter.service.SupportProcessService;
import pt.iscte.smartercity.supportcenter.service.SupportService;
import pt.iscte.smartercity.supportcenter.service.dto.RefundDTO;
import pt.iscte.smartercity.supportcenter.service.dto.RefundProcessDTO;
import pt.iscte.smartercity.supportcenter.service.dto.SupportProcessDTO;

@Component
public class CreateRefundDelegate implements JavaDelegate {

    @Autowired
    RefundProcessService refundProcessService;

    @Autowired
    SupportService supportService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        RefundProcessDTO newRefundProcess = new RefundProcessDTO();
        RefundDTO newRefund = new RefundDTO();
        Integer refundId = generateUniqueId();

        //GET PROCESS INSTANCE
        SupportProcessDTO supportProcess = (SupportProcessDTO) delegateExecution.getVariable("processInstance");

        //GENERATE NEW REFUND
        newRefundProcess.setId(refundId.longValue());
        newRefundProcess.setProcessInstance(supportProcess.getProcessInstance());
        newRefundProcess.setRefund(newRefund);
        refundProcessService.create(newRefundProcess);

        //GENERATE NEW REFUND
        supportProcess.getSupport().setRefundId(refundId);
        supportService.save(supportProcess.getSupport());
    }

    private Integer generateUniqueId() {
        return (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);
    }
}
