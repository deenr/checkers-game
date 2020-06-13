/**
 * Sample Skeleton for 'BeginScherm.fxml' Controller Class
 */

package checkers;

import checkers.CheckersViewController;
import checkers.Spel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BeginSchermController implements Initializable{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnStart"
    private Button btnStart; // Value injected by FXMLLoader
    @FXML
    private Circle c1;

    @FXML
    private Circle c2;

    @FXML
    private Circle c3;
    
    @FXML
    private Button btnUitleg;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setRotate(c1, true,360,10);
        setRotate(c2, true, 180,16);
        setRotate(c3, true,145,24);
    }
    int rotate = 0;
    
    
    @FXML
    void btnStartHandler(ActionEvent event) throws IOException {
         // stage maken 
        Stage a = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //doorlevend model maken
        Spel model = new Spel();
        
        FXMLLoader lader = new FXMLLoader(getClass().getResource("CheckersView.fxml"));
        Parent root = lader.load();
        CheckersViewController controller = lader.getController();
        
        controller.setModel(model);
        
        Scene scene1 = new Scene(root);
        //stage setten
        a.setScene(scene1);
        a.show();
    }
    @FXML
    void btnUitlegHandler(ActionEvent event) throws IOException {
        Stage a = (Stage) ((Node) event.getSource()).getScene().getWindow();
      
        FXMLLoader lader = new FXMLLoader(getClass().getResource("Uitleg1.fxml"));
        Parent root = lader.load();
        
    
        Scene scene1 = new Scene(root);
        //stage setten
        a.setScene(scene1);
        a.show();
    }
    
    
    private void setRotate(Circle c, boolean reverse, int angle, int duration){
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(duration), c);
        rotateTransition.setAutoReverse(reverse);
        rotateTransition.setByAngle(angle);
        rotateTransition.setDelay(Duration.seconds(0));
        rotateTransition.setRate(3);
        rotateTransition.setCycleCount(5);
        rotateTransition.play();
    }
}
