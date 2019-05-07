package netCracker.tms.models;

import javax.persistence.*;

public enum TicketStatus {
    NEW("new"),
    OPEN("open"),
    ON_HOLD("on hold"),
    SOLVED("solved"),
    CLOSED("closed");

    String name;
    TicketStatus(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name();
    }
}
