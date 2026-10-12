package org.example.doordash;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.doordash.model.User;

import java.io.IOException;

public class HelloApplication extends Application {

 public static Stage stage;
 public  static User loggedUser;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage=stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 370);
        stage.setTitle("DoorDash");
        stage.setScene(scene);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch();
    }

    public static void changeScene(String fxmlFileName)
    {
        try
        {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlFileName + ".fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 400);
        stage.setScene(scene);
    }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


//    public static  void changeScene(String fileName)
//    {
//    try
//    {
//        FXMLLoader fxmlLoader = new FXMLLoader(org.example.doordash.HelloApplication.class.getResource(fileName + ".fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 530, 400);
//        stage.setScene(scene);
//        stage.show();
//    }
//    catch (IOException e)
//            {
//                throw new RuntimeException(e);
//            }
//    }
}
