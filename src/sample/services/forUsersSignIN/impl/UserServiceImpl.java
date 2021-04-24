package sample.services.forUsersSignIN.impl;
import java.sql.*;
import sample.services.database.DBservice;
import sample.services.database.DatabaseConnection;
import sample.services.forUsersSignIN.FindActiveAccount;
import sample.services.forUsersSignIN.FindLogin;
import sample.services.forUsersSignIN.FindPassword;

public class UserServiceImpl implements FindPassword, FindLogin, FindActiveAccount {
    DBservice dBservice = new DatabaseConnection();
    Statement statement ;
    @Override
    public boolean loginUser(String login) {
        String loginUser;
        try{
            statement = DatabaseConnection.connection.createStatement();
            String query = "SELECT login FROM accounts WHERE accounts.login = '"+login+"'";
            ResultSet rs = statement.executeQuery(query);
            loginUser = rs.getString("login");
            if (loginUser.equals(login)){
                rs.close();
                statement.close();
                return true;
            }
        }catch (Exception e){
            System.out.println("Неверный логин!");
        }
        return false;
    }
    @Override
    public boolean passwordUser(String password) {
        try {
            statement = DatabaseConnection.connection.createStatement();
            String query = "SELECT password FROM accounts WHERE accounts.password = '"+password+"'";
            ResultSet rs = statement.executeQuery(query);
            String passwordUser = rs.getString("password");
            if (passwordUser.equals(password)){
                rs.close();
                statement.close();
                return true;
            }
        }catch (Exception e){
            System.out.println("Неверный пароль");
        }
        return false;
    }

    @Override
    public boolean checkActiveAccount(String login) {
        try {
            statement = DatabaseConnection.connection.createStatement();
            String query = "SELECT active FROM accounts WHERE accounts.login = '"+login+"'";
            ResultSet resultSet = statement.executeQuery(query);
            int active = resultSet.getInt("active");
            if (active == 1){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
