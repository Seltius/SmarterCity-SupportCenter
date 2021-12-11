package pt.iscte.smartercity.supportcenter.domain;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Refund.
 */
@Entity
@Table(name = "refund")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Refund implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "refund_id")
    private Integer refundId;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "method")
    private String method;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Refund id(Long id) {
        this.id = id;
        return this;
    }

    public Integer getRefundId() {
        return this.refundId;
    }

    public Refund refundId(Integer refundId) {
        this.refundId = refundId;
        return this;
    }

    public void setRefundId(Integer refundId) {
        this.refundId = refundId;
    }

    public Float getAmount() {
        return this.amount;
    }

    public Refund amount(Float amount) {
        this.amount = amount;
        return this;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getMethod() {
        return this.method;
    }

    public Refund method(String method) {
        this.method = method;
        return this;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Refund)) {
            return false;
        }
        return id != null && id.equals(((Refund) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Refund{" +
            "id=" + getId() +
            ", refundId=" + getRefundId() +
            ", amount=" + getAmount() +
            ", method='" + getMethod() + "'" +
            "}";
    }
}
