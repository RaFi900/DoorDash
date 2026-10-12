package org.example.doordash.service;

import org.example.doordash.HelloApplication;
import org.example.doordash.Singletone;
import org.example.doordash.model.DashBoardUser;
import org.example.doordash.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DashBoardUserService {

    public boolean insert(DashBoardUser dashBoardUser) {
        try {
            Connection connection = Singletone.getConnection();
            Statement statement = connection.createStatement();
            String query = "INSERT INTO dashboard_user VALUE('" + dashBoardUser.getService() + "','" + dashBoardUser.getVendor() + "','" + dashBoardUser.getType() + "','" + dashBoardUser.getMenuItem() + "'," + dashBoardUser.getBill() + "," + dashBoardUser.getCod() + "," + dashBoardUser.getTotalbill() + ",'" + dashBoardUser.getMobile() + "');";
            System.out.println(query);
            statement.execute(query);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public List<DashBoardUser> show() {

        List<DashBoardUser> dashBoardUserList = new ArrayList<>();
        try {
            Connection connection = Singletone.getConnection();

            Statement statement = connection.createStatement();

            String query = "SELECT * FROM  dashboard_user";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String service = resultSet.getString("service");
                String vendor = resultSet.getString("vendor");
                String vtype = resultSet.getString("vtype");
                String menuitem = resultSet.getString("menuitem");
                double cod = resultSet.getDouble("cod");
                double bill = resultSet.getDouble("bill");
                double totalBill = resultSet.getDouble("totalbill");
                String mobile = resultSet.getString("mobile");
                DashBoardUser dashBoardUser = new DashBoardUser(service,vendor,vtype,menuitem,cod,bill,totalBill);
                dashBoardUser.setMobile(mobile);

                dashBoardUserList.add(dashBoardUser);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dashBoardUserList;
    }
    }
