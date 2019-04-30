package models;

import javax.persistence.*;

@Entity
@Table (name = "ticket_category")
public class TicketCategory {
    @Id
    @Column (name = "id_ticket_category")
    private long id;

    @Column (name = "name_ticket_category")
    private String name;

    public TicketCategory(){

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
        return "TicketCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
