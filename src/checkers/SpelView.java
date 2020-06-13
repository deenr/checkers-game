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

public class SpelView extends Region{
    private VierkantView roosterView;
    private Spel spel;
    
    private ArrayList<Pion> pionnenZwart;
    private ArrayList<Pion> pionnenWit;
    private ArrayList<Vierkant> vierkanten;
    
    /**
     * 
     * @param spel 
     */
    public SpelView (Spel spel){
        this.spel = spel;
        //initieleTekening();
        update();
    }
    
    /**
     * 
     * @param x
     * @param y
     * @return 
     */
    public Pion getWittePionOnder(double x, double y){
        ArrayList<Pion> wittePionnen = spel.getWittePionnen();
        for (Pion p : wittePionnen){
            double visueleStraal = p.getDiameter();
            
            double visueleX = p.getxPlaats();
            double visueleY = p.getyPlaats();
            
            double x2 = Math.pow(visueleX - x,2);
            double y2 = Math.pow(visueleY - y,2);

            double visueleAfstand = Math.sqrt(x2+y2);
            
            if (visueleAfstand <= visueleStraal){
                return p;
            }
        }
        
       return null;
    }
    
    /**
     * 
     * @param x
     * @param y
     * @return 
     */   
    public Pion getZwartePionOnder(double x, double y){
        ArrayList<Pion> zwartePionnen = spel.getZwartePionnen();
        for (Pion p : zwartePionnen){
            double visueleStraal = p.getDiameter();
            
            double visueleX = p.getxPlaats();
            double visueleY = p.getyPlaats();
            
            double x2 = Math.pow(visueleX - x,2);
            double y2 = Math.pow(visueleY - y,2);

            double visueleAfstand = Math.sqrt(x2+y2);
            
            if (visueleAfstand <= visueleStraal){
                return p;
            }
        }
        
        return null; 
    }
    
    /**
     * 
     * @param x
     * @param y
     * @return 
     */   
    public Vierkant getVierkantOnder(double x, double y){
        ArrayList<Vierkant> vierkanten = spel.getVierkanten();
        for (Vierkant vk : vierkanten){
            if (vk.getxPos() <=x && x<(vk.getxPos() +vk.getBreedteVakje()))
            {
                if (vk.getyPos()<=y && y<(vk.getyPos() +vk.getBreedteVakje()))
                {
                    return vk;
                }
            }
        }
        
        return null;
    }
    
    /**
     * 
     */
    public void update(){
        getChildren().clear();
        
        ArrayList<Vierkant> vierkanten = spel.getVierkanten();
        for (Vierkant v : vierkanten){
            VierkantView vv = new VierkantView(v);
            getChildren().add(vv);
        }
        
        ArrayList<Pion> zwartePionnen = spel.getZwartePionnen();
        for (Pion p : zwartePionnen){
            PionView pv = new PionView(p);
            getChildren().add(pv);
        }
        
        ArrayList<Pion> wittePionnen = spel.getWittePionnen();
        for (Pion p : wittePionnen){
            PionView pv = new PionView(p);
            getChildren().add(pv);
        }
    }
}
    
    

