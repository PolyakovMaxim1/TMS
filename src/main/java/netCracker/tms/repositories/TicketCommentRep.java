package netCracker.tms.repositories;

import netCracker.tms.models.Ticket;
import netCracker.tms.models.TicketAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketCommentRep extends JpaRepository<TicketAnswer, Long> {
    List<TicketAnswer> findTicketAnswersByTicket(Ticket ticket);
}
