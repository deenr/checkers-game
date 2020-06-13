/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import java.util.ArrayList;
import javafx.scene.paint.Color;

/**
 *
 * @author Dean Reymen
 * @author Sven Kumpen
 * @author Yannick Claes
 */

public class Spel {
    private Pion pion;
    private Vierkant vierkant;
    
    private boolean zwartBeurt;
    private boolean witBeurt;
    private boolean zwartKamikaze;
    private boolean witKamikaze;
    
    private int aantalZwart=12;
    private int aantalWit=12;
    
    private ArrayList<Pion> pionnenZwart;
    private ArrayList<Pion> pionnenWit;
    private ArrayList<Vierkant> vierkanten;
    
    private int diameter;
    private int schaal;
    
    /** Constructor van het spel
     * 
     */
    public Spel ()    
    {   
        this.schaal = 50;
        this.diameter = schaal/5;
        this.zwartBeurt = true;
        this.witBeurt = false;
        
        pionnenZwart = new ArrayList<>();
        pionnenWit = new ArrayList<>();
        vierkanten = new ArrayList<>();
        
        //pionnen maken
        for (int i=0; i<12; i++) 
        {
            pionnenZwart.add(new Pion(diameter, Color.BLACK));
            pionnenWit.add(new Pion(diameter,Color.WHITE));      
        }
        
        //vierkanten maken
        for (int i=0; i<64; i++)
        {
            vierkanten.add(new Vierkant(schaal, 0, 0));
        }
        
        //geef alles een plaatst
        reset();
    }
    
    /** Alle kleuren van pionnen en vlakken veranderen naar hun beginwaarde
     * 
     */
    public void resetKleuren()
    {
        for (Vierkant v: vierkanten){
            if (v.isVoorspelVlak()){
                v.setVoorspelVlak(false);
            }
            if (v.isGesprongenVlak()){
                v.setGesprongenVlak(false);
            }
        }
        
        for (Pion p : pionnenZwart){
            p.setGeselecteerd(false);
        }
        
        for (Pion p : pionnenWit){
            p.setGeselecteerd(false);
        }
    }
    
    /** Controleren of een vierkant bezet is of niet en deze status teruggeven
     * 
     */
    public void bezetheidControlleren()
    {
        for (Vierkant vk: vierkanten)
        {
            if (vk.isBezet() == true)
            {
                vk.setBezet(false);
            }
            
            for (Pion pz: pionnenZwart)
            {
                if (vk.getxPos() + 0.5*schaal == pz.getxPlaats() && vk.getyPos() +0.5*schaal == pz.getyPlaats())
                {
                    vk.setBezet(true);
                }
            }
            
            for (Pion pw: pionnenWit)
            {
                if (vk.getxPos() +0.5*schaal == pw.getxPlaats() && vk.getyPos() +0.5*schaal == pw.getyPlaats() && vk.isBezet() != true)
                {
                    vk.setBezet(true);
                }
                
            }
            
        }
    
    }
    
    /** De pion aanduiden en bijhoorende vlakken errond tekenen, kleur van de vlakken afhankelijk van posities
     * 
     * @param p de pion die wordt aangeduid
     */
    public void aanduidenPion (Pion p)
    {
        resetKleuren();
        
        p.setGeselecteerd(true);
        
        double x = p.getxPlaats();
        double y = p.getyPlaats();
        
        for (Vierkant v : vierkanten){
            if (zwartBeurt){
                
                if (x == (v.getxPos()+1.5*schaal) && y == (v.getyPos()+1.5*schaal) && v.isBezet() == false)
                {
                    v.setVoorspelVlak(true);
                }
                
                else if (x == (v.getxPos()-.5*schaal) && y == (v.getyPos()+1.5*schaal) && v.isBezet() == false)
                {
                    v.setVoorspelVlak(true);
                }
                
                else{
                    v.setVoorspelVlak(false);
                }
                
                if (x == (v.getxPos()+2.5*schaal) && y == (v.getyPos()+2.5*schaal) && v.isBezet() == false)
                {   
                    for (Pion w : pionnenWit){
                        if (x == w.getxPlaats()+1*schaal && y == w.getyPlaats()+1*schaal){
                            v.setGesprongenVlak(true);
                        }
                    }
                    
                }
                
                else if (x == (v.getxPos()-1.5*schaal) && y == (v.getyPos()+2.5*schaal) && v.isBezet() == false)
                {
                    for (Pion w : pionnenWit){
                        if (x == w.getxPlaats()-1*schaal && y == w.getyPlaats()+1*schaal){
                            v.setGesprongenVlak(true);
                        }
                    }
                }
                
                else{
                    v.setGesprongenVlak(false);
                }
            }
            
            if (witBeurt){
                if (x == (v.getxPos()-.5*schaal) && y == (v.getyPos()-.5*schaal) && v.isBezet() == false)
                {
                    v.setVoorspelVlak(true);
                }
                
                else if (x == (v.getxPos()+1.5*schaal) && y == (v.getyPos()-.5*schaal) && v.isBezet() == false)
                {
                    v.setVoorspelVlak(true);
                }
                else
                {
                    v.setVoorspelVlak(false);
                }
                
                if (x == (v.getxPos()+2.5*schaal) && y == (v.getyPos()-1.5*schaal) && v.isBezet() == false)
                {   
                    for (Pion z : pionnenZwart){
                        if (x == z.getxPlaats()+1*schaal && y == z.getyPlaats()-1*schaal){
                            v.setGesprongenVlak(true);
                        }
                    }
                    
                }
                
                else if (x == (v.getxPos()-1.5*schaal) && y == (v.getyPos()-1.5*schaal) && v.isBezet() == false)
                {
                    for (Pion z : pionnenZwart){
                        if (x == z.getxPlaats()-1*schaal && y == z.getyPlaats()-1*schaal){
                            v.setGesprongenVlak(true);
                        }
                    }
                }
                
                else{
                    v.setGesprongenVlak(false);
                }
            }
                
            //dubbele dam
            
            //paars
            if (p.isDubbeleDam()){
                if (x == (v.getxPos()-.5*schaal) && y == (v.getyPos()-.5*schaal) && v.isBezet() == false)
                {
                    v.setVoorspelVlak(true);
                }
                
                else if (x == (v.getxPos()+1.5*schaal) && y == (v.getyPos()-.5*schaal) && v.isBezet() == false)
                {
                    v.setVoorspelVlak(true);
                }
                
                else if (x == (v.getxPos()+1.5*schaal) && y == (v.getyPos()+1.5*schaal) && v.isBezet() == false)
                {
                    v.setVoorspelVlak(true);
                }
                
                else if (x == (v.getxPos()-.5*schaal) && y == (v.getyPos()+1.5*schaal) && v.isBezet() == false)
                {
                    v.setVoorspelVlak(true);
                }
                
                else {
                    v.setVoorspelVlak(false);
                }
            }
                
            //groen
            if (zwartBeurt && p.isDubbeleDam())
            {
                if (x == (v.getxPos()+2.5*schaal) && y == (v.getyPos()+2.5*schaal) && v.isBezet() == false)
                {   
                    for (Pion w : pionnenWit){
                        if (x == w.getxPlaats()+1*schaal && y == w.getyPlaats()+1*schaal){
                            v.setGesprongenVlak(true);
                        }
                    }
                    
                }
                
                else if (x == (v.getxPos()-1.5*schaal) && y == (v.getyPos()+2.5*schaal) && v.isBezet() == false)
                {
                    for (Pion w : pionnenWit){
                        if (x == w.getxPlaats()-1*schaal && y == w.getyPlaats()+1*schaal){
                            v.setGesprongenVlak(true);
                        }
                    }
                }
                
                else if (x == (v.getxPos()+2.5*schaal) && y == (v.getyPos()-1.5*schaal) && v.isBezet() == false)
                {   
                    for (Pion z : pionnenWit){
                        if (x == z.getxPlaats()+1*schaal && y == z.getyPlaats()-1*schaal){
                            v.setGesprongenVlak(true);
                        }
                    }
                    
                }
                
                else if (x == (v.getxPos()-1.5*schaal) && y == (v.getyPos()-1.5*schaal) && v.isBezet() == false)
                {
                    for (Pion z : pionnenWit){
                        if (x == z.getxPlaats()-1*schaal && y == z.getyPlaats()-1*schaal){
                            v.setGesprongenVlak(true);
                        }
                    }
                }
                
                else{
                    v.setGesprongenVlak(false);
                }
            }
            
            if (witBeurt && p.isDubbeleDam())
            {
                if (x == (v.getxPos()+2.5*schaal) && y == (v.getyPos()-1.5*schaal) && v.isBezet() == false)
                {   
                    for (Pion z : pionnenZwart){
                        if (x == z.getxPlaats()+1*schaal && y == z.getyPlaats()-1*schaal){
                            v.setGesprongenVlak(true);
                        }
                    }
                    
                }
                
                else if (x == (v.getxPos()-1.5*schaal) && y == (v.getyPos()-1.5*schaal) && v.isBezet() == false)
                {
                    for (Pion z : pionnenZwart){
                        if (x == z.getxPlaats()-1*schaal && y == z.getyPlaats()-1*schaal){
                            v.setGesprongenVlak(true);
                        }
                    }
                }
                
                else if (x == (v.getxPos()+2.5*schaal) && y == (v.getyPos()+2.5*schaal) && v.isBezet() == false)
                {   
                    for (Pion w : pionnenZwart){
                        if (x == w.getxPlaats()+1*schaal && y == w.getyPlaats()+1*schaal){
                            v.setGesprongenVlak(true);
                        }
                    }
                    
                }
                
                else if (x == (v.getxPos()-1.5*schaal) && y == (v.getyPos()+2.5*schaal) && v.isBezet() == false)
                {
                    for (Pion w : pionnenZwart){
                        if (x == w.getxPlaats()-1*schaal && y == w.getyPlaats()+1*schaal){
                            v.setGesprongenVlak(true);
                        }
                    }
                }
                
                else{
                    v.setGesprongenVlak(false);
                }
            }
        }
    }
    
    /** Verplaatsen naar een vlak en als dit vlak een groen vlak is zal de pion waarover gesprongen is verwijderd worden
     * 
     * @param w het vierkant naar waar de pion zal verplaatsen
     */
    public void verplaatsPion (Vierkant w)
    {
        //voorspelbaar vlak
        //groen
        if (w.isGesprongenVlak() && w.isBezet() == false)
        {
            double x = w.getxPos();
            double y = w.getyPos();
            System.out.println(x + " - " + y + " - " + w.getKleur());
            
            for (Pion p : pionnenZwart){
                //rechts
                if(x == p.getxPlaats()+1.5*schaal && y == p.getyPlaats()-2.5*schaal && p.isGeselecteerd() == true){
                    p.setxPlaats(x + 0.5*schaal);
                    p.setyPlaats(y + 0.5*schaal);
                    
                    for (Pion wit : pionnenWit){
                        double zwartX = p.getxPlaats();
                        double zwartY = p.getyPlaats();
                        
                        if (zwartX == wit.getxPlaats()+1*schaal && zwartY == wit.getyPlaats()-1*schaal){
                            wit.setxPlaats(-5*schaal);
                            wit.setyPlaats(-5*schaal);
                            aantalWit--;
                        }
                    }
                    
                    setWitAanDeBeurt(true);
                    setZwartAanDeBeurt(false);
                }
                
                if(x == p.getxPlaats()+1.5*schaal && y == p.getyPlaats()+1.5*schaal && p.isGeselecteerd() == true){
                    p.setxPlaats(x + 0.5*schaal);
                    p.setyPlaats(y + 0.5*schaal);
                
                    for (Pion wit : pionnenWit){
                        double zwartX = p.getxPlaats();
                        double zwartY = p.getyPlaats();
                        
                        if (zwartX == wit.getxPlaats()+1*schaal && zwartY == wit.getyPlaats()+1*schaal){
                            wit.setxPlaats(-5*schaal);
                            wit.setyPlaats(-5*schaal);
                            aantalWit--;
                        }
                    }
                        
                    setWitAanDeBeurt(true);
                    setZwartAanDeBeurt(false);
                }
                
                //links
                if(x == p.getxPlaats()-2.5*schaal && y == p.getyPlaats()-2.5*schaal && p.isGeselecteerd() == true){
                    p.setxPlaats(x + 0.5*schaal);
                    p.setyPlaats(y + 0.5*schaal);
                    
                    for (Pion wit : pionnenWit){
                        double zwartX = p.getxPlaats();
                        double zwartY = p.getyPlaats();
                        
                        if (zwartX == wit.getxPlaats()-1*schaal && zwartY == wit.getyPlaats()-1*schaal){
                            wit.setxPlaats(-5*schaal);
                            wit.setyPlaats(-5*schaal);
                            aantalWit--;
                        }
                    }
                    
                    setWitAanDeBeurt(true);
                    setZwartAanDeBeurt(false);
                }
                
                if(x == p.getxPlaats()-2.5*schaal && y == p.getyPlaats()+1.5*schaal && p.isGeselecteerd() == true){
                    p.setxPlaats(x + 0.5*schaal);
                    p.setyPlaats(y + 0.5*schaal);
                
                    for (Pion wit : pionnenWit){
                        double zwartX = p.getxPlaats();
                        double zwartY = p.getyPlaats();
                        
                        if (zwartX == wit.getxPlaats()-1*schaal && zwartY == wit.getyPlaats()+1*schaal){
                            wit.setxPlaats(-5*schaal);
                            wit.setyPlaats(-5*schaal);
                            aantalWit--;
                        }
                    }
                           
                    setWitAanDeBeurt(true);
                    setZwartAanDeBeurt(false);
                }
                
                p.setGeselecteerd(false);
            }

            for (Pion p : pionnenWit){
                //rechtsonder
                if(x == p.getxPlaats()+1.5*schaal && y == p.getyPlaats()+1.5*schaal && p.isGeselecteerd() == true){
                    p.setxPlaats(x + 0.5*schaal);
                    p.setyPlaats(y + 0.5*schaal);
                
                    for (Pion zwart : pionnenZwart){
                        double witX = p.getxPlaats();
                        double witY = p.getyPlaats();
                        
                        if (witX == zwart.getxPlaats()+1*schaal && witY == zwart.getyPlaats()+1*schaal){
                            zwart.setxPlaats(-5*schaal);
                            zwart.setyPlaats(-5*schaal);
                            aantalZwart--;
                        }
                    }
                        
                    setWitAanDeBeurt(false);
                    setZwartAanDeBeurt(true);
                }
                //rechtsboven
                if(x == p.getxPlaats()+1.5*schaal && y == p.getyPlaats()-2.5*schaal && p.isGeselecteerd() == true){
                    p.setxPlaats(x + 0.5*schaal);
                    p.setyPlaats(y + 0.5*schaal);
                    
                    for (Pion zwart : pionnenZwart){
                        double witX = p.getxPlaats();
                        double witY = p.getyPlaats();
                        
                        if (witX == zwart.getxPlaats()+1*schaal && witY == zwart.getyPlaats()-1*schaal){
                            zwart.setxPlaats(-5*schaal);
                            zwart.setyPlaats(-5*schaal);
                            aantalZwart--;
                        }
                    }
                    
                    setWitAanDeBeurt(false);
                    setZwartAanDeBeurt(true);
                }
                //linksonder
                if(x == p.getxPlaats()-2.5*schaal && y == p.getyPlaats()+1.5*schaal && p.isGeselecteerd() == true){
                    p.setxPlaats(x + 0.5*schaal);
                    p.setyPlaats(y + 0.5*schaal);
                
                    for (Pion zwart : pionnenZwart){
                        double witX = p.getxPlaats();
                        double witY = p.getyPlaats();
                        
                        if (witX == zwart.getxPlaats()-1*schaal && witY == zwart.getyPlaats()+1*schaal){
                            zwart.setxPlaats(-5*schaal);
                            zwart.setyPlaats(-5*schaal);
                            aantalZwart--;
                        }
                    }
                           
                    setWitAanDeBeurt(false);
                    setZwartAanDeBeurt(true);
                }
                //linksboven
                if(x == p.getxPlaats()-2.5*schaal && y == p.getyPlaats()-2.5*schaal && p.isGeselecteerd() == true){
                    p.setxPlaats(x + 0.5*schaal);
                    p.setyPlaats(y + 0.5*schaal);
                    
                    for (Pion zwart : pionnenZwart){
                        double witX = p.getxPlaats();
                        double witY = p.getyPlaats();
                        
                        if (witX == zwart.getxPlaats()-1*schaal && witY == zwart.getyPlaats()-1*schaal){
                            zwart.setxPlaats(-5*schaal);
                            zwart.setyPlaats(-5*schaal);
                            aantalZwart--;
                        }
                    }
                    
                    setWitAanDeBeurt(false);
                    setZwartAanDeBeurt(true);
                }
                
                p.setGeselecteerd(false);
            }     
            
            for (Vierkant v : vierkanten) {
                v.setVoorspelVlak(false);
                v.setGesprongenVlak(false);
            }
            
        }

        //paars
        if (w.isVoorspelVlak() && w.isBezet() == false)
        {
            double x = w.getxPos();
            double y = w.getyPos();
            
            for (Pion p : pionnenZwart){
                if(p.isGeselecteerd() || p.isGeselecteerd() && p.isDubbeleDam()){
                    p.setxPlaats(x + 0.5*schaal);
                    p.setyPlaats(y + 0.5*schaal);
                    
                    setWitAanDeBeurt(true);
                    setZwartAanDeBeurt(false);
                }
                p.setGeselecteerd(false);
            }

            for (Pion p : pionnenWit){
                if(p.isGeselecteerd() || p.isGeselecteerd() && p.isDubbeleDam()){
                    p.setxPlaats(x + 0.5*schaal);
                    p.setyPlaats(y + 0.5*schaal);
                    
                    setWitAanDeBeurt(false);
                    setZwartAanDeBeurt(true);
                }
                
                p.setGeselecteerd(false);
            }     
            
            for (Vierkant v : vierkanten) {
                v.setVoorspelVlak(false);
                v.setGesprongenVlak(false);
            }
        }
    }
    
    /** Kijken of de witte of zwarte Pion een dubbele dam is
     * 
     */
    public void dubbeleDam()
    {
        for (Pion p : pionnenWit){
            if (p.getyPlaats() == 7.5*schaal){
                p.setDubbeleDam(true);
            }
        }
        
        for (Pion p : pionnenZwart){
            if (p.getyPlaats() == 0.5*schaal){
                p.setDubbeleDam(true);
            }
        }
    }
    
    /** Witte pion die kamikaze zal plegen
     * 
     * @param p de pion die kamikaze zal plegen
     */
    public void kamikazeWitPion (Pion p){
        double x = p.getxPlaats();
        double y = p.getyPlaats();
        
        if (witKamikaze){
            for (Pion z : pionnenZwart){
                if(z.getxPlaats() > x-1.5*schaal && z.getxPlaats() < x+1.5*schaal && z.getyPlaats() > y-1.5*schaal && z.getyPlaats() < y+1.5*schaal){
                    z.setxPlaats(-5*schaal);
                    z.setyPlaats(-5*schaal);
                    aantalZwart--;
                }
            }
            for (Pion z : pionnenWit){
                if(z.getxPlaats() > x-1.5*schaal && z.getxPlaats() < x+1.5*schaal && z.getyPlaats() > y-1.5*schaal && z.getyPlaats() < y+1.5*schaal){
                    z.setxPlaats(-5*schaal);
                    z.setyPlaats(-5*schaal);
                    aantalWit--;
                }
            }
            
            setWitKamikaze(false);
            setWitAanDeBeurt(false);
            setZwartAanDeBeurt(true);
        }
        
        resetKleuren();
    }
    
    /** Zwarte pion die kamikaze zal plegen
     * 
     * @param p de pion die kamikaze zal plegen
     */
    public void kamikazeZwartPion (Pion p){
        double x = p.getxPlaats();
        double y = p.getyPlaats();
        
        if (zwartKamikaze){
            for (Pion z : pionnenZwart){
                if(z.getxPlaats() > x-1.5*schaal && z.getxPlaats() < x+1.5*schaal && z.getyPlaats() > y-1.5*schaal && z.getyPlaats() < y+1.5*schaal){
                    z.setxPlaats(-5*schaal);
                    z.setyPlaats(-5*schaal);
                    aantalZwart--;
                }
            }
            for (Pion z : pionnenWit){
                if(z.getxPlaats() > x-1.5*schaal && z.getxPlaats() < x+1.5*schaal && z.getyPlaats() > y-1.5*schaal && z.getyPlaats() < y+1.5*schaal){
                    z.setxPlaats(-5*schaal);
                    z.setyPlaats(-5*schaal);
                    
                    aantalWit--;
                }
            }
            setZwartKamikaze(false);
            setWitAanDeBeurt(true);
            setZwartAanDeBeurt(false);
        }
        
        resetKleuren();
    }
    
    
    /** Het resetten van het spel en alles terug op zijn beginpositie zetten
     * 
     */
    public void reset()
    {
        this.zwartBeurt = true;
        this.witBeurt = false;
        
        this.setWitKamikaze(true);
        this.setZwartKamikaze(true);
        
        this.aantalWit = 12;
        this.aantalZwart = 12;
        
        pionnenZwart = new ArrayList<>();
        pionnenWit = new ArrayList<>();
        vierkanten = new ArrayList<>();
        
        //pionnen maken
        for (int i=0; i<12; i++) 
        {
            pionnenZwart.add(new Pion(diameter, Color.BLACK));
            pionnenWit.add(new Pion(diameter,Color.WHITE));      
        }
        
        //vierkanten maken
        for (int i=0; i<64; i++)
        {
            vierkanten.add(new Vierkant(schaal, 0, 0));
        }
        
        //pionnen Wit positioneren
        double n=0.5; double y=0.5;
        for (Pion w: pionnenWit)
            {
            w.setxPlaats(schaal*n);
            w.setyPlaats(schaal*y);
            
            n=n+2;
            
            if (n>6.5 && y==0.5){
                n=1.5;
                y++;
            }
            
            if (n>7.5 && y==1.5){
                n=0.5;
                y++;
            }
            
            if (y==3.5 && n==6.5){ 
                  break;          
            }
        }
    
        //pionnen Zwart positioneren
        double a=1.5; double b=5.5;
        for (Pion w: pionnenZwart)
            {

            w.setxPlaats(schaal*a);
            w.setyPlaats(schaal*b);

            a=a+2;
            
            if (a>7.5 && b==5.5){
                a=0.5;
                b++;
            }
            
            if (a>6.5 && b==6.5){
                a=1.5;
                b++;
            }
            
            if (a>7.5 && b==7.5){ 
              break;          
            }
        }
        
        //vierkanten positioneren
        int i=0; int j=0;
        for (Vierkant vk : vierkanten)
        {
            vk.setxPos(i*vk.getBreedteVakje());
            vk.setyPos(j*vk.getBreedteVakje());

            vk.setKleur(Color.BISQUE);
            if (j%2 ==0 && i%2 == 0){
                vk.setKleur(Color.BROWN);
            }

            if (j%2 !=0 && i%2 != 0) {
                vk.setKleur(Color.BROWN);
            } 
        
            if (i==7) {
                i=-1;
                j++;
            }
            
            i++;  
        }
    }
            
    /** 
     * 
     * @return pionnenWit 
     */
    public ArrayList<Pion> getWittePionnen(){
        return pionnenWit;
    }
    
    /**
     * 
     * @return pionnenZwart
     */
    public ArrayList<Pion> getZwartePionnen(){
        return pionnenZwart;
    }
    
    /**
     * 
     * @return vierkanten
     */
    public ArrayList<Vierkant> getVierkanten(){
        return vierkanten;
    }
    
    /**
     * 
     * @return zwartBeurt
     */
    public boolean getZwartAanDeBeurt(){ 
        return zwartBeurt;
    }
    
    /**
     * 
     * @return witBeurt
     */
    public boolean getWitAanDeBeurt(){ 
        return witBeurt;
    }
    
    /**
     * 
     * @param status 
     */
    public void setZwartAanDeBeurt(boolean status){ 
        zwartBeurt = status;
    }
    
    /**
     * 
     * @param status 
     */
    public void setWitAanDeBeurt(boolean status){ 
        witBeurt = status;
    }

    /** Wat is de ingestelde schaal van het spel?
     * 
     * @return schaal de schaal van het spel
     */
    public int getSchaal() {
        return schaal;
    }

    /** Verander de schaal van het spel
     * 
     * @param schaal de nieuwe schaal van het spel
     */
    public void setSchaal(int schaal) {
        this.schaal = schaal;
    }
 
    /** Hoeveel witte pionnen zijn er nog over?
     * 
     * @return aantalWit de hoeveelheid witte pionnen
     */
    public int getAantalWit(){
        return aantalWit;
    }
    
    /** Hoeveel zwarte pionnen zijn er nog over?
     * 
     * @return aantalZwart de hoeveelheid zwarte pionnen
     */
    public int getAantalZwart(){
        return aantalZwart;
    
    }

    /** Verander het aantal zwarte pionnen
     * 
     * @param aantalzwart het nieuwe aantal zwarte pionnen
     */
    public void setAantalZwart(int aantalzwart) {
        this.aantalZwart = aantalzwart;
    }

    /** Verander het aantal witte pionnen
     * 
     * @param aantalwit het nieuwe aantal witte pionnen
     */
    public void setAantalWit(int aantalwit) {
        this.aantalWit = aantalwit;
    }

    /** Kan een zwarte pion kamikaze plegen?
     * 
     * @return zwartKamikaze true of false
     */
    public boolean isZwartKamikaze() {
        return zwartKamikaze;
    }

    /** Verander of de zwarte pion kamikaze kan plegen
     * 
     * @param zwartKamikaze true of false
     */
    public void setZwartKamikaze(boolean zwartKamikaze) {
        this.zwartKamikaze = zwartKamikaze;
    }

    /** Kan een witte pion kamikaze plegen?
     * 
     * @return witKamikaze true of false
     */
    public boolean isWitKamikaze() {
        return witKamikaze;
    }

    /** Verander of de witte pion kamikaze kan plegen
     * 
     * @param witKamikaze true of false
     */
    public void setWitKamikaze(boolean witKamikaze) {
        this.witKamikaze = witKamikaze;
    }
}
