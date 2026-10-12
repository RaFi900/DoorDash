package org.example.doordash.service;

import org.example.doordash.Singletone;
import org.example.doordash.model.DashBoardUser;
import org.example.doordash.model.PreOrderUser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PreOrderUserService {

    public  boolean insert(PreOrderUser preOrderUser) {
        try {
            Connection connection = Singletone.getConnection();
            Statement statement = connection.createStatement();
            String query = "INSERT INTO preorder_user VALUE('" + preOrderUser.getRestaurant() + "','" + preOrderUser.getMenu() + "','" + preOrderUser.getQuantity() + "','" + preOrderUser.getTableBook() + "'," + preOrderUser.getPrice() + "," + preOrderUser.getBookingCharge() + "," + preOrderUser.getBillTotal() + "," + preOrderUser.getAdvancePay() + ",'"+preOrderUser.getMobile()+"');";
            System.out.println(query);
            statement.execute(query);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public List<PreOrderUser> show() {

        List<PreOrderUser> preOrderUserList = new ArrayList<>();
        try {
            Connection connection = Singletone.getConnection();

            Statement statement = connection.createStatement();

            String query = "SELECT * FROM  preorder_user";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String restaurant = resultSet.getString("restaurant");
                String menu = resultSet.getString("menu");
                String quantity = resultSet.getString("quantity");
                String tableBook = resultSet.getString("tableBook");
                double price = resultSet.getDouble("price");
                double bookingCharge = resultSet.getDouble("bookingCharge");
                double billTotal = resultSet.getDouble("billTotal");
                double advancePay = resultSet.getDouble("advancePay");
                String mobile = resultSet.getString("mobile");
                PreOrderUser preOrderUser = new PreOrderUser(restaurant,menu,quantity,tableBook,price,bookingCharge,billTotal,advancePay);
                preOrderUser.setMobile(mobile);

                preOrderUserList.add(preOrderUser);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return preOrderUserList;
    }
 }
