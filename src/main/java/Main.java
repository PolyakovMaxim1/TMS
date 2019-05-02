import netCracker.tms.models.*;
import netCracker.tms.services.withoutRep.serviceImplementswithoutRep.RoleService;
import netCracker.tms.services.withoutRep.serviceImplementswithoutRep.UserService;

import java.util.*;

public class Main {
    public static void main(String[] args){
        UserService service = new UserService();

        RoleService roleService = new RoleService();
        Role role1 = new Role(1L, "Администратор");
        Role role2 = new Role(2L, "Пользователь");
        roleService.saveUser(role1);
        roleService.saveUser(role2);
        User userone = new User(1,"София",
                "yksd",
                "@mail.ru",
                role1);
        User usertwo = new User(2,"Маким",
                "lksfj",
                "@bk.ru",
                role2);
        service.saveUser(userone);
        service.saveUser(usertwo);

        System.out.println("-----------------");
//        System.out.println(service.findUser(1));
        List<User> users =  service.getAllUsers();
        users.stream().forEach(System.out::println);

    }
}
