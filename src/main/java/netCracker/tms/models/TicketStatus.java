package netCracker.tms.models;

import javax.persistence.*;

@Entity
@Table (name = "ticket_status")
public class TicketStatus {
    @Id
    @Column (name = "id_status_name")
    private long id;

    @Column (name = "ticket_status_name")
    private String name;

    public TicketStatus(){

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
        return "TicketStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
