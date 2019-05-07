package netCracker.tms.services.Intefraces;

import netCracker.tms.models.UserStatusInfo;

public interface UserStatusInfoServiceInterface {

    public UserStatusInfo findUserStatusInfoById(long id);

    public void insertUserStatusInfo(UserStatusInfo userStatusInfo);

    public void deleteUserStatusInfo(UserStatusInfo userStatusInfo);

    public void updateUserStatusInfo(UserStatusInfo userStatusInfo);
}
