package netCracker.tms.repositories;

import netCracker.tms.models.Object;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectRep extends JpaRepository<Object, Long> {
}
