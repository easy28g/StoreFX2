package sample.services.forUsers.impl;

import sample.services.forUsers.FindLogin;
import sample.services.forUsers.FindPassword;

public class UserServiceImpl implements FindPassword, FindLogin {


    @Override
    public boolean passwordUser(String password) {
        return false;
    }

    @Override
    public boolean loginUser(String login) {
        return false;
    }
}
