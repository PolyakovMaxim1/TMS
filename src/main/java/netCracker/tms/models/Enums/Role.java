package netCracker.tms.models.Enums;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation;
import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER("User"),
    ADMIN("Admin"),
    ANONYMOUS("Anonymous");

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
