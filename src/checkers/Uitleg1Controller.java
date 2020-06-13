/**
 * Sample Skeleton for 'Uitleg1.fxml' Controller Class
 */

package checkers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Uitleg1Controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="pane"
    private AnchorPane pane; // Value injected by FXMLLoader

    @FXML // fx:id="btnNext"
    private Button btnNext; // Value injected by FXMLLoader

    @FXML // fx:id="btnBack"
    private Button btnBack; // Value injected by FXMLLoader
    
    @FXML // fx:id="btnBack"
    private ImageView foto1;
    
    @FXML
    private Button btnSetFoto;
    
    @FXML // fx:id="btnBack"
    private ImageView foto2;
    
    @FXML // fx:id="btnBack"
    private ImageView foto3;
    

    @FXML
    void btnBackHandler(ActionEvent event) throws IOException {
        
       Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // beginscherm maken en stage setten naar beginscherm
        
        FXMLLoader lader1 = new FXMLLoader(getClass().getResource("BeginScherm.fxml"));
        Parent root1 = lader1.load();
  
        Scene scene1 = new Scene(root1);
        
        window.setScene(scene1);
        window.setTitle("CHECKERS");
        window.show();
    }

    @FXML
    void btnNextHandler(ActionEvent event) throws IOException {
        Stage a = (Stage) ((Node) event.getSource()).getScene().getWindow();
      
        FXMLLoader lader = new FXMLLoader(getClass().getResource("Uitleg3.fxml"));
        Parent root = lader.load();
    
        Scene scene1 = new Scene(root);
        //stage setten
        a.setScene(scene1);
        a.show();
    }
      @FXML
    void btnSetFoto(ActionEvent event) {
        Image im = new Image("/img/foto.png");
        foto1.setImage(im);
        
        Image ima = new Image("/img/foto22.png");
        foto2.setImage(ima);
        
        Image imag = new Image("/img/foto33.png");
        foto3.setImage(imag);
    }
    
   

    @FXML
    void initialize() {
        
    }
}
