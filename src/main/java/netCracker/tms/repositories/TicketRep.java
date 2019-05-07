package netCracker.tms.repositories;

import netCracker.tms.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRep extends JpaRepository<Ticket, Long> {

}
