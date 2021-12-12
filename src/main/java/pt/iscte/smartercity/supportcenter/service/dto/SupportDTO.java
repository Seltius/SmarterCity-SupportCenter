package pt.iscte.smartercity.supportcenter.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link pt.iscte.smartercity.supportcenter.domain.Support} entity.
 */
public class SupportDTO implements Serializable {

    private Long id;

    private Integer supportId;

    private LocalDate createDate;

    private LocalDate endDate;

    private String name;

    private String email;

    private String issue;

    private Boolean isRefund;

    private Boolean isValid;

    private Integer refundId;

    private Boolean isResolved;

    private String status;

    private String userReply;

    private List<MessageDTO> messageList;

    private String supportReply;

    public List<MessageDTO> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<MessageDTO> messageList) {
        this.messageList = messageList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSupportId() {
        return supportId;
    }

    public void setSupportId(Integer supportId) {
        this.supportId = supportId;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public Boolean getIsRefund() {
        return isRefund;
    }

    public void setIsRefund(Boolean isRefund) {
        this.isRefund = isRefund;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    public Integer getRefundId() {
        return refundId;
    }

    public void setRefundId(Integer refundId) {
        this.refundId = refundId;
    }

    public Boolean getIsResolved() {
        return isResolved;
    }

    public void setIsResolved(Boolean isResolved) {
        this.isResolved = isResolved;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserReply() {
        return userReply;
    }

    public void setUserReply(String userReply) {
        this.userReply = userReply;
    }

    public String getSupportReply() {
        return supportReply;
    }

    public void setSupportReply(String supportReply) {
        this.supportReply = supportReply;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SupportDTO)) {
            return false;
        }

        SupportDTO supportDTO = (SupportDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, supportDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SupportDTO{" +
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
