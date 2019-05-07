package netCracker.tms.repositories;

import netCracker.tms.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRep extends JpaRepository<User, Long> {
}
