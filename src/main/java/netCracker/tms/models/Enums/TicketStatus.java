package netCracker.tms.models.Enums;

import javax.persistence.*;

public enum TicketStatus {
    NEW("New"),
    OPEN("Open"),
    ON_HOLD("On hold"),
    SOLVED("Solved"),
    CLOSED("Closed");

    String name;
    TicketStatus(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
