package pt.iscte.smartercity.supportcenter.service.dto;

import java.io.Serializable;
import java.util.Objects;
import org.akip.service.dto.ProcessInstanceDTO;

/**
 * A DTO for the {@link pt.iscte.smartercity.supportcenter.domain.MessageProcess} entity.
 */
public class MessageProcessDTO implements Serializable {

    private Long id;

    private ProcessInstanceDTO processInstance;

    private MessageDTO message;

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

    public MessageDTO getMessage() {
        return message;
    }

    public void setMessage(MessageDTO message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MessageProcessDTO)) {
            return false;
        }

        MessageProcessDTO messageProcessDTO = (MessageProcessDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, messageProcessDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MessageProcessDTO{" +
            "id=" + getId() +
            ", processInstance=" + getProcessInstance() +
            ", message=" + getMessage() +
            "}";
    }
}
