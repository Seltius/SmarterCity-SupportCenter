package pt.iscte.smartercity.supportcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iscte.smartercity.supportcenter.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
