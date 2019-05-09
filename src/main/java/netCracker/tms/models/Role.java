package netCracker.tms.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER("User");

    String name;
    Role(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
