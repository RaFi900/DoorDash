package org.example.doordash.model;

public class DashBoardUser
 {
   private String service;
   private String vendor;
   private String type;
   private String menuItem;
   private double cod;
   private double bill;
   private double totalbill;
   private String mobile;

  public DashBoardUser(String service, String vendor, String type, String menuItem, double cod, double bill, double totalbill)
  {
   this.service = service;
   this.vendor = vendor;
   this.type = type;
   this.menuItem = menuItem;
   this.cod = cod;
   this.bill =bill;
   this.totalbill = totalbill;
  }

  public String getService() {
   return service;
  }

  public DashBoardUser() {
  }

  public void setService(String service) {
   this.service = service;
  }

  public String getVendor() {
   return vendor;
  }

  public void setVendor(String vendor) {
   this.vendor = vendor;
  }

//  public String getRestaurant() {
//   return restaurant;
//  }
//
//  public void setRestaurant(String restaurant) {
//   this.restaurant = restaurant;
//  }
//
//  public String getCloudKitchen() {
//   return cloudKitchen;
//  }
//
//  public void setCloudKitchen(String cloudKitchen) {
//   this.cloudKitchen = cloudKitchen;
//  }

  public String getMenuItem() {
   return menuItem;
  }

  public void setMenuItem(String menuItem) {
   this.menuItem = menuItem;
  }

  public double getCod() {
   return cod;
  }

  public void setCod(double cod) {
   this.cod = cod;
  }

  public double getBill() {
   return bill;
  }

  public void setBill(double bill) {
   this.bill = bill;
  }

  public String getType() {
   return type;
  }

  public void setType(String type) {
   this.type = type;
  }

  public double getTotalbill() {
   return totalbill;
  }

  public void setTotalbill(double totalbill) {
   this.totalbill = totalbill;
  }

  public String getMobile() {
   return mobile;
  }

  public void setMobile(String mobile) {
   this.mobile = mobile;
  }
 }
