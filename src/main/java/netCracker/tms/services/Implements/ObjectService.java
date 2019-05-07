package netCracker.tms.services.Implements;

import netCracker.tms.models.Object;
import netCracker.tms.repositories.ObjectRep;
import netCracker.tms.services.Intefraces.ObjectServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjectService implements ObjectServiceInterface {
    @Autowired
    ObjectRep objectRep;

    @Override
    public Object findObjectById(long id) {
        return objectRep.findById(id).get();
    }

    @Override
    public void insertObject(Object object) {
        objectRep.save(object);
    }

    @Override
    public void deleteObject(Object object) {
        objectRep.delete(object);
    }

    @Override
    public void updateObject(Object object) {

    }

}
