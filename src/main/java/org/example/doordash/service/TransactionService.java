package org.example.doordash.service;

import org.example.doordash.Singletone;
import org.example.doordash.model.Transaction;
import org.example.doordash.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionService
 {
     public boolean advance(Transaction transaction)
     {
         try
         {
             Connection connection = Singletone.getConnection();
             Statement statement = connection.createStatement();
             String query = "INSERT INTO transactionservice VALUE('" + transaction.getMobile() + "','" + transaction.getService() + "'," + transaction.getAmount() + ");";
             statement.execute(query);
             return true;
         }
         catch (SQLException ex)
         {
             ex.printStackTrace();
         }
         return false;
     }
 }
