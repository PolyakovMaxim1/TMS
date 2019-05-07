package netCracker.tms.repositories;

import netCracker.tms.models.UserStatusInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStatusInfoRep extends JpaRepository<UserStatusInfo,Long> {

}
