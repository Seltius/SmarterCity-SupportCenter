package pt.iscte.smartercity.supportcenter.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Support.
 */
@Entity
@Table(name = "support")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Support implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "support_id")
    private Integer supportId;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "message")
    private String message;

    @Column(name = "is_refund")
    private Boolean isRefund;

    @Column(name = "is_valid")
    private Boolean isValid;

    @Column(name = "refund_id")
    private Integer refundId;

    @Column(name = "is_resolved")
    private Boolean isResolved;

    @Column(name = "status")
    private String status;

    @Column(name = "support_message")
    private String supportMessage;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Support id(Long id) {
        this.id = id;
        return this;
    }

    public Integer getSupportId() {
        return this.supportId;
    }

    public Support supportId(Integer supportId) {
        this.supportId = supportId;
        return this;
    }

    public void setSupportId(Integer supportId) {
        this.supportId = supportId;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public Support startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public Support endDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getUserName() {
        return this.userName;
    }

    public Support userName(String userName) {
        this.userName = userName;
        return this;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return this.email;
    }

    public Support email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return this.message;
    }

    public Support message(String message) {
        this.message = message;
        return this;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getIsRefund() {
        return this.isRefund;
    }

    public Support isRefund(Boolean isRefund) {
        this.isRefund = isRefund;
        return this;
    }

    public void setIsRefund(Boolean isRefund) {
        this.isRefund = isRefund;
    }

    public Boolean getIsValid() {
        return this.isValid;
    }

    public Support isValid(Boolean isValid) {
        this.isValid = isValid;
        return this;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    public Integer getRefundId() {
        return this.refundId;
    }

    public Support refundId(Integer refundId) {
        this.refundId = refundId;
        return this;
    }

    public void setRefundId(Integer refundId) {
        this.refundId = refundId;
    }

    public Boolean getIsResolved() {
        return this.isResolved;
    }

    public Support isResolved(Boolean isResolved) {
        this.isResolved = isResolved;
        return this;
    }

    public void setIsResolved(Boolean isResolved) {
        this.isResolved = isResolved;
    }

    public String getStatus() {
        return this.status;
    }

    public Support status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSupportMessage() {
        return this.supportMessage;
    }

    public Support supportMessage(String supportMessage) {
        this.supportMessage = supportMessage;
        return this;
    }

    public void setSupportMessage(String supportMessage) {
        this.supportMessage = supportMessage;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Support)) {
            return false;
        }
        return id != null && id.equals(((Support) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Support{" +
            "id=" + getId() +
            ", supportId=" + getSupportId() +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", userName='" + getUserName() + "'" +
            ", email='" + getEmail() + "'" +
            ", message='" + getMessage() + "'" +
            ", isRefund='" + getIsRefund() + "'" +
            ", isValid='" + getIsValid() + "'" +
            ", refundId=" + getRefundId() +
            ", isResolved='" + getIsResolved() + "'" +
            ", status='" + getStatus() + "'" +
            ", supportMessage='" + getSupportMessage() + "'" +
            "}";
    }
}
