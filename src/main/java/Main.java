import netCracker.tms.models.*;
import netCracker.tms.services.withoutRep.serviceImplementswithoutRep.RoleService;
import netCracker.tms.services.withoutRep.serviceImplementswithoutRep.UserService;

import java.util.*;

public class Main {
    public static void main(String[] args){
        UserService service = new UserService();

        RoleService roleService = new RoleService();
//        Role role1 = new Role(1L, "Администратор");
//        Role role2 = new Role(2L, "Пользователь");
//        roleService.saveRole(role1);
//        roleService.saveRole(role2);

//        roleService.saveRole(Role.USER);

        User userone = new User("София",
                "yksd",
                "@mail.ru",4);
        User usertwo = new User("Маким",
                "lksfj",
                "@bk.ru", 3);
        Set<Role> roles = new HashSet<>();
        roles.add(Role.USER);
        userone.setRoles(roles);
        usertwo.setRoles(roles);
        service.saveUser(userone);
        service.saveUser(usertwo);


        System.out.println("-----------------");
//        System.out.println(service.findUser(1));
//        List<User> users =  service.getAllUsers();
//        users.stream().forEach(System.out::println);

    }
}
