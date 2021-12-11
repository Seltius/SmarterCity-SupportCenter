package pt.iscte.smartercity.supportcenter.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import pt.iscte.smartercity.supportcenter.domain.Refund;

/**
 * Spring Data SQL repository for the Refund entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RefundRepository extends JpaRepository<Refund, Long> {}
