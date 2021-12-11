package pt.iscte.smartercity.supportcenter.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import pt.iscte.smartercity.supportcenter.domain.SupportProcess;

/**
 * Spring Data SQL repository for the SupportProcess entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SupportProcessRepository extends JpaRepository<SupportProcess, Long> {
    Optional<SupportProcess> findByProcessInstanceId(Long processInstanceId);
}
