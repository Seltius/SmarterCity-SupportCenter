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

    private LocalDate startDate;

    private LocalDate endDate;

    private String userName;

    private String email;

    private String message;

    private Boolean isRefund;

    private Boolean isValid;

    private Integer refundId;

    private Boolean isResolved;

    private String status;

    private String supportMessage;

    private List<MessageDTO> messageList;

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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getSupportMessage() {
        return supportMessage;
    }

    public void setSupportMessage(String supportMessage) {
        this.supportMessage = supportMessage;
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
