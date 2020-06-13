/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Dean Reymen
 * @author Sven Kumpen
 * @author Yannick Claes
 */

public class PionView extends Region{
        
    private Pion model;
    private Circle cirkel;

    /** Constructor voor de pionView te maken
     * 
     * @param model model van de pion
     */
    public PionView(Pion model){
        this.model = model;
        cirkel = new Circle(model.getxPlaats(), model.getyPlaats(), model.getDiameter());
        
        if (model.isDubbeleDam() == true) {
            if (model.isGeselecteerd() == true){
                cirkel.setFill(Color.BLUEVIOLET);
            }
            else {
                cirkel.setFill(model.getColor());
            }
            
            cirkel.setStroke(Color.ORANGE);
            cirkel.setStrokeWidth(5);
        }
        
        else if (model.isGeselecteerd() == true) {
            cirkel.setFill(Color.BLUEVIOLET);
        }
        
        
        else {
            cirkel.setFill(model.getColor());
        }
        
        
        getChildren().addAll(cirkel);
    }
}
