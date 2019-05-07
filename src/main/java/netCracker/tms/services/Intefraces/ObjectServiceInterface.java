package netCracker.tms.services.Intefraces;

import netCracker.tms.models.Object;

public interface ObjectServiceInterface {

    public Object findObjectById(long id);

    public void insertObject(Object object);

    public void deleteObject(Object object);

    public void updateObject(Object object);

}
