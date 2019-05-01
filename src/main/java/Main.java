import netCracker.tms.services.*;
import netCracker.tms.models.*;
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
        List<User> users = new ArrayList<>();
        Collections.addAll(users, userone, usertwo);
        users.stream().forEach(System.out::println);

        System.out.println("-----------------");
        System.out.println(service.findUser(1));

    }
}
