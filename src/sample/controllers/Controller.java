package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.services.database.DBservice;
import sample.services.database.DatabaseConnection;

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
    }
}




