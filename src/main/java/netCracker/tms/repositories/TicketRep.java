package netCracker.tms.repositories;

import netCracker.tms.models.Ticket;
import netCracker.tms.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRep extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByRaisedBy(User user);
}
