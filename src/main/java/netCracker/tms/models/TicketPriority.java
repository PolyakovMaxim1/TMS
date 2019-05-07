package netCracker.tms.models;

import javax.persistence.*;

public enum TicketPriority {
    LOW("Low"),
    NORMAL("Normal"),
    MEDIUM("Medium"),
    HIGH("High"),
    CRITICAL("Critical"),
    IN_PROGRESS("In progress");

    String name;
    TicketPriority(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
