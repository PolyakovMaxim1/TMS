package netCracker.tms.services.Intefraces;

import netCracker.tms.models.Ticket;
import netCracker.tms.models.User;

import java.util.List;

public interface TicketServiceInterface {

    public Ticket findTicketById(long id);

    public void insertTicket(Ticket ticket);

    public void deleteTicket(Ticket ticket);

    public void updateTicket(Ticket ticket);

    public List<Ticket> findAllTickets();

    List<Ticket> findAllByRaisedBy(User user);

    List<Ticket> findAllByAssignedTo(User user);

    List<Ticket> filter(Ticket ticket,
                        String raisedByFirstName,
                        String raisedBySecondName,
                        String assignedToFirstName,
                        String assignedToSecondName);
}
