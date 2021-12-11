package pt.iscte.smartercity.supportcenter.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import pt.iscte.smartercity.supportcenter.domain.Support;

/**
 * Spring Data SQL repository for the Support entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SupportRepository extends JpaRepository<Support, Long> {}
