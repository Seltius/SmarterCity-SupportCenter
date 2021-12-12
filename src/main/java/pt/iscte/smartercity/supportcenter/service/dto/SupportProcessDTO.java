package pt.iscte.smartercity.supportcenter.service.dto;

import java.io.Serializable;
import java.util.Objects;
import org.akip.service.dto.ProcessInstanceDTO;

/**
 * A DTO for the {@link pt.iscte.smartercity.supportcenter.domain.SupportProcess} entity.
 */
public class SupportProcessDTO implements Serializable {

    private Long id;

    private ProcessInstanceDTO processInstance;

    private SupportDTO support;

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

    public SupportDTO getSupport() {
        return support;
    }

    public void setSupport(SupportDTO support) {
        this.support = support;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SupportProcessDTO)) {
            return false;
        }

        SupportProcessDTO supportProcessDTO = (SupportProcessDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, supportProcessDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SupportProcessDTO{" +
            "id=" + getId() +
            ", processInstance=" + getProcessInstance() +
            ", support=" + getSupport() +
            "}";
    }
}
