//package netCracker.tms.services;
//
//import netCracker.tms.models.User;
//import netCracker.tms.repositories.UserRep;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserServiceDetails implements UserDetailsService
//{
//    @Autowired
//    private UserRep userRep;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
//    {
//        User userFindByUsername = userRep.findUserByLogin(username);
//        //Остальные поиски
//
//        if(userFindByUsername != null)
//        {
//            return userFindByUsername;
//        }
//        //Остальные проверки
//        return null;
//    }
//}
