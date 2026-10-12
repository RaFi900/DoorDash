package org.example.doordash.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import org.example.doordash.HelloApplication;
import org.example.doordash.model.AdminUser;
import org.example.doordash.model.User;
import org.example.doordash.service.AdminUserService;
import org.example.doordash.service.UserService;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    public TextField mobileField;

    @FXML
    public PasswordField passwordField;

    @FXML
    public CheckBox checkboxShow;

    @FXML
    public TextField passwordTextField;

    @FXML
    public void changeVisibilityTo(ActionEvent event) {
     if (checkboxShow.isSelected())
     {
         passwordTextField.setText(passwordField.getText());
         passwordTextField.setVisible(true);
         passwordField.setVisible(false);
         return;
     }
     passwordField.setText(passwordTextField.getText());
     passwordField.setVisible(true);
     passwordTextField.setVisible(false);
    }

    @FXML
    public void changeToRegisterScene()
    {
        HelloApplication.changeScene("registration");
    }

    @FXML
  public void login(ActionEvent event)
    {
      String mobile = mobileField.getText();
      String password = passwordField.getText();

        UserService userService = new UserService();
        User user = userService.login(mobile,password);
        HelloApplication.loggedUser = user;
        if (HelloApplication.loggedUser.getType().equals("Customer"))
        {
            HelloApplication.changeScene("dashboard");
        }
       else if (HelloApplication.loggedUser.getType().equals("Admin"))
        {
            HelloApplication.changeScene("order");
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(" Error ");
            alert.setContentText("Mobile or Password is Incorrect");
            alert.showAndWait();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        passwordTextField.setVisible(false);
    }
}
