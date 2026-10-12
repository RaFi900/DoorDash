package org.example.doordash.service;

import org.example.doordash.Singletone;
import org.example.doordash.model.User;

import java.sql.*;

import static org.example.doordash.Singletone.getConnection;

public class UserService
   {
       public boolean update;

       public boolean register(User user)
     {
         try
         {
             Connection connection = Singletone.getConnection();
             Statement statement = connection.createStatement();
             String query = "INSERT INTO user VALUE('" + user.getName() + "','" + user.getMobile() + "','" + user.getPassword() + "','Customer');";
             statement.execute(query);
             return true;
         }
         catch (SQLException ex)
         {
             ex.printStackTrace();
         }
         return false;
     }

     public User login(String mobile, String password)
     {
         try
         {
            Connection connection = Singletone.getConnection();

             Statement statement = connection.createStatement();

             String query = "SELECT * FROM user WHERE mobile='" + mobile + "' and password='" + password +"';";
             ResultSet resultSet = statement.executeQuery(query);
             while (resultSet.next())
             {
               String name =  resultSet.getString("name");
               String mobileNumber = resultSet.getString("mobile");
               String type = resultSet.getString("type");
//               String pass = resultSet.getString("password");

               return new User(name, mobileNumber,password,type);
             }
         }
         catch (SQLException ex)
         {
             ex.printStackTrace();
         }
         return null;
     }

     public boolean update (User user)
     {
         try
         {
             Connection connection = Singletone.getConnection();
             Statement statement = connection.createStatement();
             String query = "UPDATE user SET name='" + user.getName() + "', type= '" + user.getType() + "', password= '" + user.getPassword() + "' WHERE mobile='" + user.getMobile() + "'";
             System.out.println(query);
             statement.execute(query);

         }
         catch (SQLException ex)
         {
             ex.printStackTrace();
         }
         return false;
     }
   }
