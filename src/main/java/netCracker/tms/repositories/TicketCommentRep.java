package netCracker.tms.repositories;

import netCracker.tms.models.TicketAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketCommentRep extends JpaRepository<TicketAnswer, Long> {

}
