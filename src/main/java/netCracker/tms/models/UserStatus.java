package netCracker.tms.models;

import javax.persistence.*;

public enum UserStatus {
    ONLINE("online"),
    OFFLINE("offline");

    String name;
    UserStatus(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name();
    }
}
