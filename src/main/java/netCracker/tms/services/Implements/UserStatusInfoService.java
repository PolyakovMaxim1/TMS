package netCracker.tms.services.Implements;

import netCracker.tms.models.UserStatusInfo;
import netCracker.tms.repositories.UserStatusInfoRep;
import netCracker.tms.services.Intefraces.UserStatusInfoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserStatusInfoService implements UserStatusInfoServiceInterface {
    @Autowired
    UserStatusInfoRep userStatusInfoRep;

    @Override
    public UserStatusInfo findUserStatusInfoById(long id) {
        return userStatusInfoRep.findById(id).get();
    }

    @Override
    public void insertUserStatusInfo(UserStatusInfo userStatusInfo) {
        userStatusInfoRep.save(userStatusInfo);
    }

    @Override
    public void deleteUserStatusInfo(UserStatusInfo userStatusInfo) {
        userStatusInfoRep.delete(userStatusInfo);
    }

    @Override
    public void updateUserStatusInfo(UserStatusInfo userStatusInfo) {

    }
}
