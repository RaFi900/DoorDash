package org.example.doordash.controller;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import org.example.doordash.HelloApplication;
import org.example.doordash.model.DashBoardUser;
import org.example.doordash.model.User;
import org.example.doordash.service.DashBoardUserService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class OrderController implements Initializable {

 @FXML
 public TableView<DashBoardUser> userTableView;

 @FXML
 public TableColumn<DashBoardUser, Number> billColumn;

 @FXML
 public TableColumn<DashBoardUser, Number> codColumn;

 @FXML
 public TableColumn<DashBoardUser, String> itemColumn;

 @FXML
 public TableColumn<DashBoardUser, String> restaurantcloudColumn;

 @FXML
 public TableColumn<DashBoardUser, String> serviceColumn;

 @FXML
 public TableColumn<DashBoardUser, Number> totalBillColumn;

 @FXML
 public TableColumn<DashBoardUser, String> vendorTypeColumn;
 ObservableList<DashBoardUser> orderObservableList = FXCollections.observableArrayList();
 @FXML
 public void goToDashBoard(MouseEvent event)
 {
  HelloApplication.changeScene("dashboard");
 }


 @Override
 public void initialize(URL url, ResourceBundle resourceBundle) {
   DashBoardUserService dashBoardUserService = new DashBoardUserService();
  List<DashBoardUser> boardUserList = dashBoardUserService.show();
  List<DashBoardUser> filterByUser = boardUserList.stream().filter(dashBoardUser ->dashBoardUser.getMobile().equals(HelloApplication.loggedUser.getMobile())).collect(Collectors.toList());

   orderObservableList.setAll(filterByUser);


  serviceColumn.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getService()));
  vendorTypeColumn.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getVendor()));
  restaurantcloudColumn.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getType()));
  itemColumn.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getMenuItem()));
  billColumn.setCellValueFactory(cell-> new SimpleDoubleProperty(cell.getValue().getBill()));
  codColumn.setCellValueFactory(cell-> new SimpleDoubleProperty(cell.getValue().getCod()));
  totalBillColumn.setCellValueFactory(cell-> new SimpleDoubleProperty(cell.getValue().getTotalbill()));



  userTableView.setItems(orderObservableList);
 }
}
