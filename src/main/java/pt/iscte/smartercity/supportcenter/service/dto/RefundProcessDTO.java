package pt.iscte.smartercity.supportcenter.service.dto;

import java.io.Serializable;
import java.util.Objects;
import org.akip.service.dto.ProcessInstanceDTO;

/**
 * A DTO for the {@link pt.iscte.smartercity.supportcenter.domain.RefundProcess} entity.
 */
public class RefundProcessDTO implements Serializable {

    private Long id;

    private ProcessInstanceDTO processInstance;

    private RefundDTO refund;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProcessInstanceDTO getProcessInstance() {
        return processInstance;
    }

    public void setProcessInstance(ProcessInstanceDTO processInstance) {
        this.processInstance = processInstance;
    }

    public RefundDTO getRefund() {
        return refund;
    }

    public void setRefund(RefundDTO refund) {
        this.refund = refund;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RefundProcessDTO)) {
            return false;
        }

        RefundProcessDTO refundProcessDTO = (RefundProcessDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, refundProcessDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RefundProcessDTO{" +
            "id=" + getId() +
            ", processInstance=" + getProcessInstance() +
            ", refund=" + getRefund() +
            "}";
    }
}
