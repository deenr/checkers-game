package checkers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CheckersViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane ankerpane;

    @FXML
    private Label lblGedaan;

    @FXML
    private Button btnReset;

    @FXML
    private Label lblBeurt;

    @FXML
    private Label lblZwart;

    @FXML
    private Label lblWit;

    @FXML
    private Button btnOpnieuw;

    @FXML
    private Label lblKamikazeZwart;

    @FXML
    private Label lblKamikazeWit;
    
     @FXML
    private Button btnHome;


    @FXML
    void ankerPaneHandeler(MouseEvent event) {

    }

    @FXML
    void btnOpnieuwHandler(ActionEvent event) {
        spel.reset();
        lblWit.setText("WIT = 12");
        lblKamikazeWit.setText("Wit heeft nog 1 kamikaze");
        lblZwart.setText("ZWART = 12");
        lblKamikazeZwart.setText("Zwart heeft nog 1 kamikaze");
        
        btnOpnieuw.setScaleX(0);
        lblGedaan.setText("");
        update();

    }
    
    @FXML
    void btnHomeHandler(ActionEvent event) throws IOException {
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
    void btnResetHandler(ActionEvent event) {
        spel.reset();
        lblWit.setText("WIT = 12");
        lblKamikazeWit.setText("Wit heeft nog 1 kamikaze.");
        lblZwart.setText("ZWART = 12");
        lblKamikazeZwart.setText("Zwart heeft nog 1 kamikaze.");
        update();

    }
    
    private Spel spel;
    private SpelView view ;
    public void setModel(Spel spel) {
        this.spel = spel;
        view = new SpelView(spel);
        ankerpane.getChildren().clear();
        ankerpane.getChildren().add(view);
    }
    
    @FXML
    void initialize() {
        btnOpnieuw.setScaleX(0);
        ankerpane.setOnMouseClicked(this::selecteer);
        ankerpane.setOnScroll(this::kamikaze);

    }
    
    public void selecteer(MouseEvent e) {
        //spel.resetKleuren();
        spel.bezetheidControlleren();
        
        update();
        
        double x = e.getX();
        double y = e.getY();
        System.out.println("Muisklik: " + x + " - " + y);
        
        Pion p = view.getWittePionOnder(x, y);
        Pion q = view.getZwartePionOnder(x, y);
        Vierkant v = view.getVierkantOnder(x, y);
        
        if (p != null && spel.getWitAanDeBeurt() == true) {
            spel.aanduidenPion(p);
            
        }
        
        if (q != null && spel.getZwartAanDeBeurt() == true) {
            spel.aanduidenPion(q);
        }
        spel.verplaatsPion(v);
        spel.dubbeleDam();
        
        update();
    }
    
    public void kamikaze(ScrollEvent event){
        
        ArrayList <Pion> zwartePionnen = spel.getZwartePionnen();
        ArrayList <Pion> wittePionnen = spel.getWittePionnen();
        
        for (Pion z : zwartePionnen){
            if(z.isGeselecteerd()){
                spel.kamikazeZwartPion(z);
                
            }
        }
        
        for (Pion w : wittePionnen) {
            if(w.isGeselecteerd()){
                spel.kamikazeWitPion(w);
            }
        }
        
        update();  
    }
    
    public void hoeveelPionnen(){
        lblWit.setText("Wit heeft nog " + spel.getAantalWit() + " pionnen.");
        lblZwart.setText("Zwart heeft nog " + spel.getAantalZwart() + " pionnen.");
    
    }
    
    public void beurt(){
        if (spel.getWitAanDeBeurt() == true){
            lblBeurt.setText("Wit is aan de beurt.");
        }
        if (spel.getZwartAanDeBeurt() == true){
            lblBeurt.setText("Zwart is aan de beurt.");
        }
    }
    
    public void update(){ 
        view.update();
        beurt();
        gameOver();
        kamikazeLbl();
        hoeveelPionnen();
    }
    
    public void gameOver(){
        if(spel.getAantalWit() == 0){
            btnOpnieuw.setScaleX(1);
            lblGedaan.setText("Zwart heeft gewonnen");
        }
        
        if(spel.getAantalZwart() == 0){
            btnOpnieuw.setScaleX(1);
            lblGedaan.setText("Wit heeft gewonnen");
        }
    }
    
    public void kamikazeLbl(){
        if(spel.isWitKamikaze() == false){
            lblKamikazeWit.setText("Wit heeft geen kamikaze meer.");
        }
        
        if(spel.isZwartKamikaze()== false){
            lblKamikazeZwart.setText("Zwart heeft geen kamikaze meer.");
        }
    }
}
