package org.example.doordash.model;

public class Transaction
 {
     private String mobile;
     private String service;
     private double amount;

     public String getMobile() {
         return mobile;
     }

     public void setMobile(String mobile) {
         this.mobile = mobile;
     }

     public String getService() {
         return service;
     }

     public void setService(String service) {
         this.service = service;
     }

     public double getAmount() {
         return amount;
     }

     public void setAmount(double amount) {
         this.amount = amount;
     }

     public Transaction(String mobile, String service, double amount) {
         this.mobile = mobile;
         this.service = service;
         this.amount = amount;
     }
 }
