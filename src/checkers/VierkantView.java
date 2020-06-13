/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import java.util.ArrayList;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



/**
 *
 * @author Dean Reymen
 * @author Sven Kumpen
 * @author Yannick Claes
 */

public class VierkantView extends Region{
    private Vierkant model;
    private Rectangle rechthoek;
    
    /** Constuctor voor het vierkantView te maken
     * 
     * @param model model van het vierkant
     */    
    public VierkantView(Vierkant model){
        this.model = model;
        //rechthoek = new Rectangle(model.getxPos(),model.getyPos(), model.getBreedteVakje(), model.getBreedteVakje());
        rechthoek = new Rectangle(model.getxPos(), model.getyPos(), model.getBreedteVakje(), model.getBreedteVakje());
        if (model.isVoorspelVlak() == true){
            rechthoek.setFill(Color.BLUEVIOLET);
        }
        
        else if (model.isGesprongenVlak() == true){
            rechthoek.setFill(Color.GREEN);
        }
        
        else {
            rechthoek.setFill(model.getKleur());
        }
        getChildren().addAll(rechthoek);
    }
}
    
    
