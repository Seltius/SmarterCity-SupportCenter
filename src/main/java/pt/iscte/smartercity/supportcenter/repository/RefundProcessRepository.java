package pt.iscte.smartercity.supportcenter.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import pt.iscte.smartercity.supportcenter.domain.RefundProcess;

/**
 * Spring Data SQL repository for the RefundProcess entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RefundProcessRepository extends JpaRepository<RefundProcess, Long> {
    Optional<RefundProcess> findByProcessInstanceId(Long processInstanceId);
}
