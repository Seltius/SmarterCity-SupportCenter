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

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "issue")
    private String issue;

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

    @Column(name = "user_reply")
    private String userReply;

    @Column(name = "support_reply")
    private String supportReply;

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

    public LocalDate getCreateDate() {
        return this.createDate;
    }

    public Support createDate(LocalDate createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
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

    public String getName() {
        return this.name;
    }

    public Support name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getIssue() {
        return this.issue;
    }

    public Support issue(String issue) {
        this.issue = issue;
        return this;
    }

    public void setIssue(String issue) {
        this.issue = issue;
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

    public String getUserReply() {
        return this.userReply;
    }

    public Support userReply(String userReply) {
        this.userReply = userReply;
        return this;
    }

    public void setUserReply(String userReply) {
        this.userReply = userReply;
    }

    public String getSupportReply() {
        return this.supportReply;
    }

    public Support supportReply(String supportReply) {
        this.supportReply = supportReply;
        return this;
    }

    public void setSupportReply(String supportReply) {
        this.supportReply = supportReply;
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
            ", createDate='" + getCreateDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", issue='" + getIssue() + "'" +
            ", isRefund='" + getIsRefund() + "'" +
            ", isValid='" + getIsValid() + "'" +
            ", refundId=" + getRefundId() +
            ", isResolved='" + getIsResolved() + "'" +
            ", status='" + getStatus() + "'" +
            ", userReply='" + getUserReply() + "'" +
            ", supportReply='" + getSupportReply() + "'" +
            "}";
    }
}
