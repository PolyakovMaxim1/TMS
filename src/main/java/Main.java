import services.*;
import models.*;

public class Main {
    public static void main(String[] args){
        UserService service = new UserService();
        RoleService roleService = new RoleService();
        Role role1 = new Role(1, "Администратор");
        Role role2 = new Role(2, "Пользователь");
//        roleService.saveUser(role1);
//        roleService.saveUser(role2);
        User userone = new User("София",
                "yksd",
                "@mail.ru",
                role1);
        User usertwo = new User("Маким",
                "lksfj",
                "@bk.ru",
                role2);
        service.saveUser(userone);
        service.saveUser(usertwo);
    }
}
