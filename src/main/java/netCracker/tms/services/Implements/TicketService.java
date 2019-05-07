package netCracker.tms.services.Implements;

import netCracker.tms.models.Ticket;
import netCracker.tms.repositories.TicketRep;
import netCracker.tms.services.Intefraces.TicketServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TicketService implements TicketServiceInterface {
    @Autowired
    TicketRep ticketRep;

    @Override
    public Ticket findTicketById(long id) {
        return ticketRep.findById(id).get();
    }

    @Override
    public void insertTicket(Ticket ticket) {
        ticketRep.save(ticket);
    }

    @Override
    public void deleteTicket(Ticket ticket) {
        ticketRep.delete(ticket);
    }

    @Override
    public void updateTicket(Ticket ticket) {

    }

    @Override
    public List<Ticket> findAllTickets() {
        return ticketRep.findAll();
    }
}
