package org.example.doordash.controller;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import org.example.doordash.HelloApplication;
import org.example.doordash.model.PreOrderUser;
import org.example.doordash.service.PreOrderUserService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class PreOrderController implements Initializable {

    @FXML
    private TableColumn<PreOrderUser, Number> advanceColumn;

    @FXML
    private TableColumn<PreOrderUser, Number> billTotalColumn;

    @FXML
    private TableColumn<PreOrderUser, Number> chargeColumn;

    @FXML
    private TableColumn<PreOrderUser, String> menuColumn;

    @FXML
    private TableView<PreOrderUser> preOrderTableView;

    @FXML
    private TableColumn<PreOrderUser, Number> priceColumn;

    @FXML
    private TableColumn<PreOrderUser, String> quantityColumn;

    @FXML
    private TableColumn<PreOrderUser, String> restaurantColumn;

    @FXML
    private TableColumn<PreOrderUser, String> tableBookColumn;

   ObservableList<PreOrderUser> preOrderUserObservableList = FXCollections.observableArrayList();
    @FXML
  public void goToDashBoard(MouseEvent event) {
        HelloApplication.changeScene("dashboard");

    }

    @FXML
    public void goToPayment(ActionEvent event) {
         HelloApplication.changeScene("payment");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PreOrderUserService preOrderUserService = new PreOrderUserService();
        List<PreOrderUser> preOrderlist = preOrderUserService.show();
        List<PreOrderUser> filterByUser = preOrderlist.stream().filter(preOrderUser -> preOrderUser.getMobile().equals(HelloApplication.loggedUser.getMobile())).collect(Collectors.toList());

        preOrderUserObservableList.setAll(filterByUser);

        restaurantColumn.setCellValueFactory(cell->new SimpleStringProperty(cell.getValue().getRestaurant()));
        menuColumn.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getMenu()));
        quantityColumn.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getQuantity()));
        tableBookColumn.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getTableBook()));
        priceColumn.setCellValueFactory(cell-> new SimpleDoubleProperty(cell.getValue().getPrice()));
        chargeColumn.setCellValueFactory(cell-> new SimpleDoubleProperty(cell.getValue().getBookingCharge()));
        billTotalColumn.setCellValueFactory(cell-> new SimpleDoubleProperty(cell.getValue().getBillTotal()));
        advanceColumn.setCellValueFactory(cell-> new SimpleDoubleProperty(cell.getValue().getAdvancePay()));



        preOrderTableView.setItems(preOrderUserObservableList);
    }
}
