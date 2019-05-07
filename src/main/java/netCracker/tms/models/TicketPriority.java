package netCracker.tms.models;

import javax.persistence.*;

public enum TicketPriority {
    LOW("low"),
    NORMAL("normal"),
    MEDIUM("medium"),
    HIGH("high"),
    CRITICAL("critical"),
    IN_PROGRESS("in progress");

    String name;
    TicketPriority(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name();
    }
}
