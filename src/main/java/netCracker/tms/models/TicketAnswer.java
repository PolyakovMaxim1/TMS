package netCracker.tms.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table (name = "ticket_answer")
public class TicketAnswer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_answer")
    long id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "ticket_id")
    private Ticket ticket;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "respond_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column (name = "date_answer")
    private Date dateAnswer;

    @Column (name = "message")
    private String message;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Date getDateAnswer() {
        return dateAnswer;
    }

    public void setDateAnswer(Date dateAnswer) {
        this.dateAnswer = dateAnswer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TicketAnswer{" +
                "id=" + id +
                ", ticket=" + ticket +
                ", dateAnswer=" + dateAnswer +
                ", message='" + message + '\'' +
                '}';
    }
}
