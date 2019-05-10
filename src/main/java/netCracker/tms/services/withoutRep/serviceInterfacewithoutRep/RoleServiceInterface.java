package netCracker.tms.services.withoutRep.serviceInterfacewithoutRep;

import netCracker.tms.models.Enums.Role;

public interface RoleServiceInterface {

    public Role findRole(long id);

    public void saveRole(Role role);

    public void deleteRole(Role role);

    public void updateRole(Role role);
}
