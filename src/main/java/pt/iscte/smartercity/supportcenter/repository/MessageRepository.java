package pt.iscte.smartercity.supportcenter.repository;

import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import pt.iscte.smartercity.supportcenter.domain.Message;

/**
 * Spring Data SQL repository for the Message entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllBySupportId(Integer supportId);
}
