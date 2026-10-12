package org.example.doordash.model;

public class PreOrderUser
 {
     private String restaurant;
     private String menu;
     private String quantity;
     private String  tableBook;
     private  double price;
     private double bookingCharge;
     private double billTotal;
     private double advancePay;
     private String mobile;

     public String getMobile() {
         return mobile;
     }

     public void setMobile(String mobile) {
         this.mobile = mobile;
     }

     public PreOrderUser(String restaurant, String menu, String quantity, String tableBook, double price, double bookingCharge, double billTotal, double advancePay) {
         this.restaurant = restaurant;
         this.menu = menu;
         this.quantity = quantity;
         this.tableBook = tableBook;
         this.price = price;
         this.bookingCharge = bookingCharge;
         this.billTotal = billTotal;
         this.advancePay = advancePay;
     }

     public PreOrderUser() {
     }

     public String getRestaurant() {
         return restaurant;
     }

     public void setRestaurant(String restaurant) {
         this.restaurant = restaurant;
     }

     public String getMenu() {
         return menu;
     }

     public void setMenu(String menu) {
         this.menu = menu;
     }

     public String getQuantity() {
         return quantity;
     }

     public void setQuantity(String quantity) {
         this.quantity = quantity;
     }

     public String getTableBook() {
         return tableBook;
     }

     public void setTableBook(String tableBook) {
         this.tableBook = tableBook;
     }

     public double getPrice() {
         return price;
     }

     public void setPrice(double price) {
         this.price = price;
     }

     public double getBookingCharge() {
         return bookingCharge;
     }

     public void setBookingCharge(double bookingCharge) {
         this.bookingCharge = bookingCharge;
     }

     public double getBillTotal() {
         return billTotal;
     }

     public void setBillTotal(double billTotal) {
         this.billTotal = billTotal;
     }

     public double getAdvancePay() {
         return advancePay;
     }

     public void setAdvancePay(double advancePay) {
         this.advancePay = advancePay;
     }
 }
