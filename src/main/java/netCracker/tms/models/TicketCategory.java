package netCracker.tms.models;

import javax.persistence.*;

public enum TicketCategory {
    BUG("bug"),
    DEV_TASK("dev task"),
    WORK_ITEM("work item");

    String name;
    TicketCategory(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name();
    }
}
