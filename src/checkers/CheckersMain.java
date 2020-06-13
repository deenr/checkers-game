/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Yannick Claes
 */
public class CheckersMain extends Application {
    Stage window;
    Scene scen1,scene2;
    @Override
    public void start(Stage PrimaryStage) throws Exception {
        window = PrimaryStage;
       
        // beginscherm maken en stage setten naar beginscherm
        
        FXMLLoader lader1 = new FXMLLoader(getClass().getResource("BeginScherm.fxml"));
        Parent root1 = lader1.load();
  
        Scene scene1 = new Scene(root1);
        
        window.setScene(scene1);
        window.setTitle("CHECKERS");
        window.show();
                
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

