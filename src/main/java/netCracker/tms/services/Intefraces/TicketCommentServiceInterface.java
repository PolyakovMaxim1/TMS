package netCracker.tms.services.Intefraces;

import netCracker.tms.models.TicketAnswer;
import java.util.*;

public interface TicketCommentServiceInterface {

    public TicketAnswer findTicketAnswerById(long id);

    public void insertTicketAnswer(TicketAnswer ticketAnswer);

    public void deleteTicketAnswer(TicketAnswer ticketAnswer);

    public void updateTicketAnswer(TicketAnswer ticketAnswer);

    public List<TicketAnswer> findAllTicketAnswer();

}
