
package org.example.doordash.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.doordash.HelloApplication;
import org.example.doordash.model.User;
import org.example.doordash.service.UserService;

public class RegistrationController {

    @FXML
    public TextField mobileField;

    @FXML
    public TextField nameField;

    @FXML
    public PasswordField passwordField;

    @FXML
    public TextField passTextField;
    @FXML
    public CheckBox showCheckbox;

    @FXML
  public void changeToLoginScene(MouseEvent event)
    {
        HelloApplication.changeScene("login");
    }

    @FXML
  public  void register(ActionEvent event) {
        String mobile = mobileField.getText();
        String name = nameField.getText();
        String password = passwordField.getText();
        String type = "Customer";

        User user = new User(name,mobile,password,type);
        UserService userService = new UserService();
        boolean isRegistered = userService.register(user);

        if (isRegistered)
        {
          HelloApplication.changeScene("login");
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Failed to Register");
            alert.showAndWait();
        }
    }

    @FXML
    void changeVisibility(ActionEvent event) {
     if (showCheckbox.isSelected())
     {
         passTextField.setText(passwordField.getText());
         passTextField.setVisible(true);
         passwordField.setVisible(false);
         return;
     }
     passwordField.setText(passTextField.getText());
     passwordField.setVisible(true);
     passTextField.setVisible(false);
    }


}

