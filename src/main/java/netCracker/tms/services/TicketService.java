package netCracker.tms.services;

        import netCracker.tms.models.Ticket;
        import netCracker.tms.repositories.TicketRep;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import java.util.*;

@Service
public class TicketService {
    @Autowired
    TicketRep ticketRep;

    public List<Ticket> findAll(){
        return ticketRep.findAll();
    }
}
