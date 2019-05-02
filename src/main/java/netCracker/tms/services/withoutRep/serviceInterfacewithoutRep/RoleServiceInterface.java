package netCracker.tms.services.withoutRep.serviceInterfacewithoutRep;

import netCracker.tms.models.Role;

public interface RoleServiceInterface {

    public Role findUser(long id);

    public void saveUser(Role role);

    public void deleteUser(Role role);

    public void updateUser(Role role);
}
