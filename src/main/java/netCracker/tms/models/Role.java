package netCracker.tms.models;

import javax.persistence.*;

public enum Role {
    USER("User");

    String name;
    Role(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }

}
