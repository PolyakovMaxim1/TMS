package netCracker.tms.models.Enums;

import javax.persistence.*;

public enum TicketPriority {
    LOW("Low"),
    NORMAL("Normal"),
    MEDIUM("Medium"),
    HIGH("High"),
    CRITICAL("Critical");

    String name;
    TicketPriority(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
