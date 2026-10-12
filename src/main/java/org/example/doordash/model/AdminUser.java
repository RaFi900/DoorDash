package org.example.doordash.model;

public class AdminUser
 {
   private String name;
   private String mobile;
   private String password;
   private String type;

   public AdminUser(String name, String mobile, String password, String type)
   {
       this.name = name;
       this.mobile = mobile;
       this.password = password;
       this.type = type;
   }

     public AdminUser(String name, String mobile, String password) {
         this.name = name;
         this.mobile = mobile;
         this.password = password;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getMobile() {
         return mobile;
     }

     public void setMobile(String mobile) {
         this.mobile = mobile;
     }

     public String getPassword() {
         return password;
     }

     public void setPassword(String password) {
         this.password = password;
     }

     public String getType() {
         return type;
     }

     public void setType(String type) {
         this.type = type;
     }
 }

