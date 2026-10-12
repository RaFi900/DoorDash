package org.example.doordash.model;

public class User
 {
  private String name;
  private String mobile;
  private String password;
  private String type;

  public User(String name, String mobile, String password, String type)
  {
      this.name = name;
      this.mobile = mobile;
      this.password = password;
      this.type = type;
  }
//
//     public User(String name, String mobile, String type)
//     {
//         this.name = name;
//         this.mobile = mobile;
//         this.type = type;
//     }


     public String getName()
   {
       return name;
   }
   public void setName()
   {
       this.name=name;
   }
   public String getMobile()
   {
       return mobile;
   }
   public void setMobile()
   {
       this.mobile=mobile;
   }
   public String getPassword()
   {
       return password;
   }
   public void setPassword()
   {
       this.password=password;
   }
   public  String getType() { return type; }
     public  void  setType() { this.type=type; }
 }
