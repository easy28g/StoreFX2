package sample.services.forUsersRegistration.impl;

import javafx.scene.control.Alert;
import sample.services.forUsersRegistration.CorrectUserRegistration;

public class PasswordUserFieldReg implements CorrectUserRegistration {

    @Override
    public boolean userRegistration(String userLoginPassword) {

        if (userLoginPassword.length() >=4){
            return true;
        }
        return false;
    }
}
