package org.example.doordash.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import org.example.doordash.HelloApplication;
import org.example.doordash.model.DashBoardUser;
import org.example.doordash.service.DashBoardUserService;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable
 {


 @FXML
 public ChoiceBox<String> cloudField;

// @FXML
// public ChoiceBox<String> cuisineField;

     @FXML
     public ComboBox<String> menuItemField;

 @FXML
 public ChoiceBox<String> restaurantField;

 @FXML
 public ChoiceBox<String> servicesField;

 @FXML
 public ComboBox<String> vendorField;

     @FXML
     public Label nameLabel;


     @FXML
   public   void changeToPreorderScene(MouseEvent event) {
       HelloApplication.changeScene("preorder");
     }


     @FXML
   public void order(ActionEvent event)
    {
        String service = servicesField.getValue();
        String foodVendor = vendorField.getValue();
        String type;
        if(vendorField.getValue().equals("Restaurant")){
            type = restaurantField.getValue();
            cloudField.setVisible(false);
        }else {
            type = cloudField.getValue();
            restaurantField.setVisible(false);
        }
        String menuItem =menuItemField.getValue();
        String[] menuItemSplit = menuItem.split("=");
        String menu = menuItemSplit[0];
        String billString = menuItemSplit[1];
        double bill = Integer.parseInt(billString);
        double cod = 60;
        double totalBill = bill + cod;
        DashBoardUser dashBoardUser = new DashBoardUser(service,foodVendor,type,menu,bill,cod,totalBill);
        System.out.println(HelloApplication.loggedUser.getMobile());
        dashBoardUser.setMobile(HelloApplication.loggedUser.getMobile());
        DashBoardUserService dashBoardUserService = new DashBoardUserService();
        dashBoardUserService.insert(dashBoardUser);

        HelloApplication.changeScene("order");

    }
    public void onSelect(ActionEvent event) {
        String selectedItem = vendorField.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            if (vendorField.getValue().equals("Restaurant")) {
                restaurantField.setVisible(true);
                cloudField.setVisible(false);
            }
            if (vendorField.getValue().equals("Cloud Kitchen"))
            {
                restaurantField.setVisible(false);
                cloudField.setVisible(true);
            }
        }
    }
    @FXML
   public void changeToOrderScene(MouseEvent event)
    {

        HelloApplication.changeScene("order");
    }


    @FXML
   public void goToProfile(MouseEvent event)
    {
      HelloApplication.changeScene("profile");
    }


     @FXML
     void reserve(ActionEvent event) {
        HelloApplication.changeScene("prebook");

     }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        ObservableList<String> serviceFieldList = FXCollections.observableArrayList();
        serviceFieldList.add("Home Delivery");
        serviceFieldList.add("Take Away");
        servicesField.setItems(serviceFieldList);

        ObservableList<String> vendorList = FXCollections.observableArrayList();
        vendorList.add("Restaurant");
        vendorList.add("Cloud Kitchen");
        vendorField.setItems(vendorList);

        ObservableList<String> restaurantList = FXCollections.observableArrayList();
        restaurantList.add("Farzi Cafe");
        restaurantList.add("138 East");
        restaurantList.add("Aandaazz");
        restaurantList.add("UpperCrust");
        restaurantList.add("Peyala");
        restaurantField.setItems(restaurantList);

        ObservableList<String> cloudList = FXCollections.observableArrayList();
        cloudList.add("Kludio");
        cloudList.add("The Ghost Kitchen");
        cloudList.add("Borsale");
        cloudField.setItems(cloudList);

//        ObservableList<String> cuisineList = FXCollections.observableArrayList();
//        cuisineList.add("Thai");
//        cuisineList.add("Indian");
//        cuisineList.add("Chinese");
//        cuisineList.add("Italian");
//        cuisineList.add("Japanese");
//        cuisineField.setItems(cuisineList);

        ObservableList<String> menuList = FXCollections.observableArrayList();
        menuList.add("Wonthon with chili oil(5pcs) =360");
        menuList.add("Nizami tarka biriyani =670");
        menuList.add("Beef double patty bacon burger =599");
        menuList.add("Tandori malai lollipop(3pcs) =565");
        menuList.add("Grilled prawns(6pcs) =1399");
        menuList.add("Umami cheese burger =345");
        menuList.add("Thai fried chicken burger =395");
        menuList.add("Salmon sushi(4pcs) =758");
        menuList.add("Beef ramen =520");
        menuList.add("Prawn tempura(4pcs) =899");
        menuList.add("Mixed chowmin(1:2) =499");
        menuList.add("Chefs special chinese fried rice(Chicken,Beef,Seafood-1:2) =645");
        menuList.add("Mango sticky rice =400");
        menuItemField.setItems(menuList);
        vendorField.setOnAction(this::onSelect);


     nameLabel.setText(HelloApplication.loggedUser.getName());


    }
}
