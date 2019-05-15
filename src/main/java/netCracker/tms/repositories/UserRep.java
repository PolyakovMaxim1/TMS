package netCracker.tms.repositories;

import netCracker.tms.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRep extends JpaRepository<User, Long> {
    User findUserByLogin(String login);
    User findUserByEmail(String email);
    List<User> findAllByFirstNameOrSecondName(String firstName, String secondName);
}
