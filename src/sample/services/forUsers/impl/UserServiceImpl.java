package sample.services.forUsers.impl;

import java.sql.*;
import sample.services.database.DBservice;
import sample.services.database.DatabaseConnection;
import sample.services.forUsers.FindLogin;
import sample.services.forUsers.FindPassword;

public class UserServiceImpl implements FindPassword, FindLogin {

    DBservice dBservice = new DatabaseConnection();
    Statement statement ;

    @Override
    public boolean loginUser(String login) {
        try{
            statement = DatabaseConnection.connection.createStatement();
            String query = "SELECT login FROM accounts WHERE accounts.login = '"+login+"'";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                String loginUser = rs.getString("login");
            }
            rs.close();
            statement.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean passwordUser(String password) {
        try {
            statement = DatabaseConnection.connection.createStatement();
            String query = "SELECT password FROM accounts WHERE accounts.password = '"+password+"'";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                String passwordUser = rs.getString("password");
            }
            rs.close();
            statement.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }


}
