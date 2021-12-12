package pt.iscte.smartercity.supportcenter.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import pt.iscte.smartercity.supportcenter.domain.MessageProcess;

/**
 * Spring Data SQL repository for the MessageProcess entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MessageProcessRepository extends JpaRepository<MessageProcess, Long> {
    Optional<MessageProcess> findByProcessInstanceId(Long processInstanceId);
}
