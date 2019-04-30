package models;

import javax.persistence.*;

@Entity
@Table (name = "ticket_priority")
public class TicketPriority {
    @Id
    @Column (name = "id_ticket_priority")
    private long id;

    @Column (name = "name_ticket_name")
    private String name;

    public TicketPriority(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TicketPriority{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
