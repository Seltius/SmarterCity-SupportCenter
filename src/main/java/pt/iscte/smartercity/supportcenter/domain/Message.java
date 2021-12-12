package pt.iscte.smartercity.supportcenter.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Message.
 */
@Entity
@Table(name = "message")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "support_id")
    private Integer supportId;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "message_type")
    private String messageType;

    @Column(name = "value")
    private String value;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Message id(Long id) {
        this.id = id;
        return this;
    }

    public Integer getSupportId() {
        return this.supportId;
    }

    public Message supportId(Integer supportId) {
        this.supportId = supportId;
        return this;
    }

    public void setSupportId(Integer supportId) {
        this.supportId = supportId;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public Message date(LocalDate date) {
        this.date = date;
        return this;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMessageType() {
        return this.messageType;
    }

    public Message messageType(String messageType) {
        this.messageType = messageType;
        return this;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getValue() {
        return this.value;
    }

    public Message value(String value) {
        this.value = value;
        return this;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Message)) {
            return false;
        }
        return id != null && id.equals(((Message) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Message{" +
            "id=" + getId() +
            ", supportId=" + getSupportId() +
            ", date='" + getDate() + "'" +
            ", messageType='" + getMessageType() + "'" +
            ", value='" + getValue() + "'" +
            "}";
    }
}
