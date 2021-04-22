package sample.services.forUsersRegistration.impl;

import javafx.scene.control.Alert;
import sample.services.forUsersRegistration.CorrectUserRegistration;


public class NameUserFieldReg implements CorrectUserRegistration {

    @Override
    public boolean userRegistration(String userLoginPassword) {
        // проверка имени пользователя на длину
        if(userLoginPassword.length()<=3){
//            Alert alert = new Alert(Alert.AlertType.WARNING,"Коротокое имя пользователя.");
//            alert.show();
            return false;
        }
        return true;
    }


}
