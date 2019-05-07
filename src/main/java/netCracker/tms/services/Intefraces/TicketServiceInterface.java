package netCracker.tms.services.Intefraces;

import netCracker.tms.models.Ticket;

import java.util.List;

public interface TicketServiceInterface {

    public Ticket findTicketById(long id);

    public void insertTicket(Ticket ticket);

    public void deleteTicket(Ticket ticket);

    public void updateTicket(Ticket ticket);

    public List<Ticket> findAllTickets();
}
