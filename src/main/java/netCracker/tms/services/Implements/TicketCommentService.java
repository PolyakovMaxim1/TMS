package netCracker.tms.services.Implements;

import netCracker.tms.models.TicketAnswer;
import netCracker.tms.repositories.TicketCommentRep;
import netCracker.tms.services.Intefraces.TicketCommentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketCommentService implements TicketCommentServiceInterface {

    @Autowired
    TicketCommentRep ticketCommentRep;

    @Override
    public TicketAnswer findTicketAnswerById(long id) {
        return ticketCommentRep.findById(id).get();
    }

    @Override
    public void insertTicketAnswer(TicketAnswer ticketAnswer) {
        ticketCommentRep.save(ticketAnswer);
    }

    @Override
    public void deleteTicketAnswer(TicketAnswer ticketAnswer) {
        ticketCommentRep.delete(ticketAnswer);
    }

    @Override
    public void updateTicketAnswer(TicketAnswer ticketAnswer) {

    }

    @Override
    public List<TicketAnswer> findAllTicketAnswer() {
        return ticketCommentRep.findAll();
    }
}
