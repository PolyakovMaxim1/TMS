package netCracker.tms.models;

import javax.persistence.*;

public enum TicketCategory {
    BUG("Bug"),
    DEV_TASK("Dev task"),
    WORK_ITEM("Work item");

    String name;
    TicketCategory(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
