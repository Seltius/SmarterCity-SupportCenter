package pt.iscte.smartercity.supportcenter.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link pt.iscte.smartercity.supportcenter.domain.Refund} entity.
 */
public class RefundDTO implements Serializable {

    private Long id;

    private Integer refundId;

    private Float amount;

    private String method;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRefundId() {
        return refundId;
    }

    public void setRefundId(Integer refundId) {
        this.refundId = refundId;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RefundDTO)) {
            return false;
        }

        RefundDTO refundDTO = (RefundDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, refundDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RefundDTO{" +
            "id=" + getId() +
            ", refundId=" + getRefundId() +
            ", amount=" + getAmount() +
            ", method='" + getMethod() + "'" +
            "}";
    }
}
