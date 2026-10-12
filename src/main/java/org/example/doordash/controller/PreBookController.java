package org.example.doordash.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import org.example.doordash.HelloApplication;
import org.example.doordash.model.PreOrderUser;
import org.example.doordash.service.PreOrderUserService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class PreBookController implements Initializable {

 @FXML
 public ChoiceBox<String> QuantityChoiceBox;

 @FXML
 public ChoiceBox<String> TableChoiceBox;

 @FXML
 public ChoiceBox<String> menuItemChoiceBox;

 @FXML
 public ChoiceBox<String> restaurantRatingChoicebox;

 @FXML
 public void changeToPreorderScene(MouseEvent event) {
   HelloApplication.changeScene("preorder");
 }

 @FXML
 public void goToDashBoard(MouseEvent event) {
  HelloApplication.changeScene("dashboard");
 }

 @FXML
 public void preOrder(ActionEvent event)
 {
  String restaurant = restaurantRatingChoicebox.getValue();
  String menuitem = menuItemChoiceBox.getValue();
  String[] menuSplit = menuitem.split("=");
  String menu = menuSplit[0];
  String priceString = menuSplit[1];
  double price = Integer.parseInt(priceString);
  String  quantity = QuantityChoiceBox.getValue();
  String table = TableChoiceBox.getValue();


  double bookingCharge = 50;
  double billTotal = price + bookingCharge;
  double advancePay = 300;
  PreOrderUser preOrderUser = new PreOrderUser(restaurant,menu,quantity,table,price,bookingCharge,billTotal,advancePay);
  PreOrderUserService preOrderUserService = new PreOrderUserService();
  preOrderUser.setMobile(HelloApplication.loggedUser.getMobile());
  preOrderUserService.insert(preOrderUser);





  HelloApplication.changeScene("preorder");
 }

 @Override
 public void initialize(URL url, ResourceBundle resourceBundle) {
  ObservableList<String> restaurantRatingList = FXCollections.observableArrayList();
  restaurantRatingList.add("Yumcha District");
  restaurantRatingList.add("Ruen Busaba");
  restaurantRatingList.add("Ugochi");
  restaurantRatingList.add("WoodHouse Grill");
  restaurantRatingList.add("Terracotta Tales");
  restaurantRatingList.add("Soi71");
  restaurantRatingList.add("Zephyr");
  restaurantRatingChoicebox.setItems(restaurantRatingList);

  ObservableList<String> menuItemList = FXCollections.observableArrayList();
  menuItemList.add("Prawn & Cream Cheese Rangoon =520");
  menuItemList.add("YCD Special Fried Rice =650");
  menuItemList.add("Chicken Satay =695");
  menuItemList.add("Holy Basil with Beef =895");
  menuItemList.add("Thai Chicken Green Curry =950");
  menuItemList.add("Volcano Sushi Roll =599");
  menuItemList.add("Austin Ribs 800gm =3385");
  menuItemList.add("Sobre Pescado =1685");
  menuItemList.add("Spicy Chingri Skewers =625");
  menuItemList.add("Ossobuco =995");
  menuItemList.add("Garlic Fried Rice =560");
  menuItemList.add("Chicken with Cashewnut =600");
  menuItemList.add("Brownie Sundae =450");
  menuItemList.add("Chocolate Lava =480");
  menuItemChoiceBox.setItems(menuItemList);

  ObservableList<String> quantityList = FXCollections.observableArrayList();
  quantityList.add("1-2person");
  quantityList.add("2-4person");
  quantityList.add("3-6person");
  quantityList.add("Family 8+person");
  QuantityChoiceBox.setItems(quantityList);

  ObservableList<String> tableList =FXCollections.observableArrayList();
  tableList.add("1-2 person");
  tableList.add("2-4 person");
  tableList.add("3-6 person");
  tableList.add("Family(8+) person");
  TableChoiceBox.setItems(tableList);

 }
}
