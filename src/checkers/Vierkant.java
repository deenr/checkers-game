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

public class Vierkant {
    private double breedteVakje;
    private Color kleur;
    private double xPos;
    private double yPos;
    
    private boolean voorspelVlak;
    private boolean bezet;
    private boolean gesprongenVlak;
    
    /** Constructor voor het maken van het vierkant
     * 
     * @param breedteVakje de breedte van het veerkant
     * @param xPos de x-positie van het vierkant
     * @param yPos de y-positie van het vierkant
     */
    public Vierkant(double breedteVakje, double xPos, double yPos) {
        this.breedteVakje = breedteVakje;
        this.xPos=xPos;
        this.yPos=yPos;
    }
    
    /** Wat is de breedte van het vierkant?
     * 
     * @return breedteVakje de breedte van het vierkant
     */
    public double getBreedteVakje() {
        return breedteVakje;
    }

    /** Verander de breedte voor het vierkant?
     * 
     * @param breedteVakje de nieuwe breedte van het vierkant
     */
    public void setBreedteVakje(double breedteVakje) {
        this.breedteVakje = breedteVakje;
    }

    /** Wat is de kleur van het vierkant?
     * 
     * @return kleur de kleur van het vierkant
     */
    public Color getKleur() {
        return kleur;
    }

    /** Verander kleur van het vierkant?
     * 
     * @param kleur de nieuwe kleur van het vierkant
     */
    public void setKleur(Color kleur) {
        this.kleur = kleur;
    }

    /** Wat is de x-positie van het vierkant?
     * 
     * @return xPos de x-positie van het vierkant
     */
    public double getxPos() {
        return xPos;
    }

    /** Verander de x-positie van het vierkant?
     * 
     * @param xPos de nieuwe x-positie van het vierkant
     */
    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    /** Wat is de y-positie van het vierkant?
     * 
     * @return yPos de y-positie van het vierkant
     */
    public double getyPos() {
        return yPos;
    }

    /** Verander de y-positie van het vierkant?
     * 
     * @param yPos de nieuwe y-positie van het vierkant
     */
    public void setyPos(double yPos) {
        this.yPos = yPos;
    }

    /** Is het vlak een voorspellende positie voor de pion?
     * 
     * @return voorspelVlak true of false
     */
    public boolean isVoorspelVlak() {
        return voorspelVlak;
    }

    /** Verander het vlak naar een voorspellend vlak of gewoon vlak
     * 
     * @param voorspelVlak true of false
     */
    public void setVoorspelVlak(boolean voorspelVlak) {
        this.voorspelVlak = voorspelVlak;
    }

    /** Is zit vlak bezet? Is er op dit vlak een pion aanwezig?
     * 
     * @return bezet true of false
     */
    public boolean isBezet() {
        return bezet;
    }

    /** Verander het vlak naar een bezet vlak of gewoon vlak
     * 
     * @param bezet true of false
     */
    public void setBezet(boolean bezet) {
        this.bezet = bezet;
    }

    /** Is het vlak een vlak waar de pion naartoe kan gaan om te slagen?
     * 
     * @return gesprongenVlak true of false
     */
    public boolean isGesprongenVlak() {
        return gesprongenVlak;
    }

    /** Verander het vlak naar een vlak waar de pion naar toe kan gaan om te slagen of een gewoon vlak
     * 
     * @param gesprongenVlak true of false
     */
    public void setGesprongenVlak(boolean gesprongenVlak) {
        this.gesprongenVlak = gesprongenVlak;
    }
}
