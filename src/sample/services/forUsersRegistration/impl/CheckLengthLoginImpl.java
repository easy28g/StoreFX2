package sample.services.forUsersRegistration.impl;

import sample.services.forUsersRegistration.CheckLengthLogin;

public class CheckLengthLoginImpl implements CheckLengthLogin {

    @Override
    public boolean checkLengthUserLogin(String userLogin) {

        if (userLogin.length()>=5){
            return true;
        }
        return false;
    }
}
