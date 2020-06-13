/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import javafx.scene.paint.Color;

/**
 *
 * @author Dean Reymen
 * @author Sven Kumpen
 * @author Yannick Claes
 */

public class Pion {
 
    private boolean gesprongen;
    private boolean dubbeleDam;
    private boolean geselecteerd;
    
    private int diameter;
    private double xPlaats;
    private double yPlaats;
    private Color color;
    
    /** Constructor voor het maken van een pion
     * 
     * @param diameter de diameter van het  pion
     * @param color de kleur van het pion
     */
    public Pion (int diameter,Color color){
        this.color = color;
        this.diameter = diameter;
    }
    
    /** Wat is de x-positie van het pion?
     * 
     * @return xPlaats de x-positie van het pion
     */
    public double getxPlaats() {
        return xPlaats;
    }

    /** Verander de x-positie van het pion
     * 
     * @param xPlaats de nieuwe x-positie van het pion
     */
    public void setxPlaats(double xPlaats) {
        this.xPlaats = xPlaats;
    }

    /** Wat is de y-positie van het pion?
     * 
     * @return yPlaats de y-positie van het pion
     */
    public double getyPlaats() {
        return yPlaats;
    }

    /** Verander de y-positie van het pion
     * 
     * @param yPlaats de nieuwe y-positie van het pion
     */
    public void setyPlaats(double yPlaats) {
        this.yPlaats = yPlaats;
    }
    
    /** Wat is de diameter van het pion?
     * 
     * @return diameter de diameter van het pion
     */
    public int getDiameter() {
        return diameter;
    }
    
    /** Verander de diameter van het pion
     * 
     * @param diameter de nieuwe diameter van het pion
     */
    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    /** Wat is de kleur van het pion?
     * 
     * @return color de kleur van het pion
     */
    public Color getColor() {
        return color;
    }

    /** Verander de kleur van het pion
     * 
     * @param color de nieuwe kleur van het pion
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /** Heeft de pion een slag gemaakt?
     * 
     * @return gesprongen true of false
     */
    public boolean isGesprongen() {
        return gesprongen;
    }

    /** Verander de pion naar gesprongen of niet gesprongen
     * 
     * @param gesprongen true of false
     */
    public void setGesprongen(boolean gesprongen) {
        this.gesprongen = gesprongen;
    }

    /** Is de pion een dubbele dam?
     * 
     * @return dubbeleDam true of false
     */
    public boolean isDubbeleDam() {
        return dubbeleDam;
    }

    /** Verander de pion naar een dubbele dam of gewone pion
     * 
     * @param dubbeleDam true of false
     */
    public void setDubbeleDam(boolean dubbeleDam) {
        this.dubbeleDam = dubbeleDam;
    }

    /** Is de pion een geselecteerde pion?
     * 
     * @return geselecteerd true of false
     */
    public boolean isGeselecteerd() {
        return geselecteerd;
    }

    /** Verander de pion naar een geselecteerde of gewone pion
     * 
     * @param geselecteerd true of false
     */
    public void setGeselecteerd(boolean geselecteerd) {
        this.geselecteerd = geselecteerd;
    }
}
