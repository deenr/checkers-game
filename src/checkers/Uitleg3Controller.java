/**
 * Sample Skeleton for 'Uitleg2.fxml' Controller Class
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

public class Uitleg3Controller {

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

    @FXML // fx:id="foto2"
    private ImageView foto2; // Value injected by FXMLLoader

    @FXML // fx:id="foto3"
    private ImageView foto3; // Value injected by FXMLLoader

    @FXML // fx:id="foto1"
    private ImageView foto1; // Value injected by FXMLLoader

    @FXML // fx:id="btnSetFoto"
    private Button btnSetFoto; // Value injected by FXMLLoader

    @FXML
    void btnBackHandler(ActionEvent event) throws IOException {
        Stage a = (Stage) ((Node) event.getSource()).getScene().getWindow();
      
        FXMLLoader lader = new FXMLLoader(getClass().getResource("Uitleg1.fxml"));
        Parent root = lader.load();
    
        Scene scene1 = new Scene(root);
        //stage setten
        a.setScene(scene1);
        a.show();
    }

    @FXML
    void btnNextHandler(ActionEvent event) throws IOException {
        Stage a = (Stage) ((Node) event.getSource()).getScene().getWindow();
      
        FXMLLoader lader = new FXMLLoader(getClass().getResource("Uitleg5.fxml"));
        Parent root = lader.load();
    
        Scene scene1 = new Scene(root);
        //stage setten
        a.setScene(scene1);
        a.show();
    }

    @FXML
    void btnSetFoto(ActionEvent event) {
        Image im = new Image("/img/foto4.png");
        foto1.setImage(im);
        
        Image ima = new Image("/img/foto5.png");
        foto2.setImage(ima);
        
        Image imag = new Image("/img/foto6.png");
        foto3.setImage(imag);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'Uitleg2.fxml'.";
        assert btnNext != null : "fx:id=\"btnNext\" was not injected: check your FXML file 'Uitleg2.fxml'.";
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'Uitleg2.fxml'.";
        assert foto2 != null : "fx:id=\"foto2\" was not injected: check your FXML file 'Uitleg2.fxml'.";
        assert foto3 != null : "fx:id=\"foto3\" was not injected: check your FXML file 'Uitleg2.fxml'.";
        assert foto1 != null : "fx:id=\"foto1\" was not injected: check your FXML file 'Uitleg2.fxml'.";
        assert btnSetFoto != null : "fx:id=\"btnSetFoto\" was not injected: check your FXML file 'Uitleg2.fxml'.";

    }
}
