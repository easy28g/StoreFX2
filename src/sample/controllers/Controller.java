package sample.controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.services.database.DBservice;
import sample.services.database.DatabaseConnection;
import sample.services.forUsersSignIN.FindLogin;
import sample.services.forUsersSignIN.FindPassword;
import sample.services.forUsersSignIN.impl.UserServiceImpl;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button userReg;

    @FXML
    private Button signInForUser;

    @FXML
    private TextField userLogin;

    @FXML
    private PasswordField userPassword;

    @FXML
    void initialize() {
        DBservice dBservice = new DatabaseConnection();
        dBservice.databaseConnection();
        FindLogin findLogin = new UserServiceImpl();
        FindPassword findPassword = new UserServiceImpl();
        signInForUser.setOnAction(actionEvent -> {
            String loginButton = userLogin.getText().trim();
            boolean boolLogin = findLogin.loginUser(loginButton);
            String passwordButton = userPassword.getText().trim();
            boolean boolPassword = findPassword.passwordUser(passwordButton);
            if (boolLogin && boolPassword){
                System.out.println("Вход выполнен!");
                signInForUser.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/views/saleOperation.fxml"));
                try{
                    loader.load();
                }catch (IOException e){
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
                dBservice.databaseClose();
            }else {
                Alert alert = new Alert(Alert.AlertType.WARNING,"Вход невыполнен! Неверный логин или пароль!");
                alert.show();
//                System.out.println("Вход невыполнен!");
            }
        });
        userReg.setOnAction(actionEvent -> {
            userReg.getScene().getWindow().hide(); // закрыть прошлое окно
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/views/userRegistrationPage.fxml"));
            try{
                loader.load();
            }catch (IOException e){
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
    }
}




