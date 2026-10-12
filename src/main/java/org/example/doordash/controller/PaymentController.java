package org.example.doordash.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.doordash.HelloApplication;
import org.example.doordash.model.Transaction;
import org.example.doordash.service.TransactionService;

import java.net.URL;
import java.util.ResourceBundle;

public class PaymentController implements Initializable{

    @FXML
    public TextField amountField;

    @FXML
    public TextField mobileTextField;
    @FXML
    public Label balanceLabel;

    @FXML
   public Label nameLabel;

    @FXML
  public   void goToDashBoard(MouseEvent event) {
        HelloApplication.changeScene("dashboard");
    }

    @FXML
  public void pay(ActionEvent event) {

        String mobile = mobileTextField.getText();
     double amount = Double.parseDouble(amountField.getText());

        TransactionService transactionService = new TransactionService();
        boolean isAdvance = transactionService.advance(new Transaction(mobile, "payment",amount));

        if(isAdvance)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(" Success ");
            alert.setContentText("Payment Successful");
            alert.setContentText("Booking Successful");
            alert.showAndWait();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(" Error ");
            alert.setContentText("Failed to make payment");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mobileTextField.setText("1472");
        mobileTextField.setDisable(true);

    }

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        nameLabel.setText(HelloApplication.loggedUser.getName());
//    }

}
