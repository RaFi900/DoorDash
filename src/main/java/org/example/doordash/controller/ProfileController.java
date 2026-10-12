package org.example.doordash.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.doordash.HelloApplication;
import org.example.doordash.model.User;
import org.example.doordash.service.UserService;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {

 @FXML
 public TextField mobileField;

 @FXML
 public TextField nameField;

 @FXML
 public PasswordField passwordField;

    @FXML
    public TextField typeField1;

 @FXML
 public void goToDashBoard(MouseEvent event) {
  HelloApplication.changeScene("dashboard");
 }

 @FXML
 public void logout(ActionEvent event) {

  HelloApplication.changeScene("login");
 }

 @FXML
 public void update(ActionEvent event) {

  String name = nameField.getText();
  String mobile = mobileField.getText();
  String password = passwordField.getText();
//  String type = typeField1.getText();
  UserService userService = new UserService();
  User user = new User(name, mobile, password, HelloApplication.loggedUser.getType());
  boolean isUpdated = userService.update(user);
  if (isUpdated) {
   HelloApplication.changeScene("login");
  } else {
   Alert alert = new Alert(Alert.AlertType.INFORMATION);
   alert.setTitle(" Update ");
   alert.setContentText("Credentials change successful");
   alert.showAndWait();
  }
 }

 @Override
 public void initialize(URL url, ResourceBundle resourceBundle) {
  nameField.setText(HelloApplication.loggedUser.getName());
  mobileField.setText(HelloApplication.loggedUser.getMobile());
  passwordField.setText(HelloApplication.loggedUser.getPassword());
//  typeField1.setText(HelloApplication.loggedUser.getType());
  mobileField.setDisable(true);

 }
}
