import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Abstract world for storing global variables and functions that actors may need. The ACTUAL
 * 'GAME' world will inherit from this one. When creating a reference to the world for your
 * actor class, you may find it useful to use the AncestorGame Object.
 * 
 * @author      Zachary Sousa 
 * @version     1.00
 */
public class AncestorGame extends World
{
    /*vv GLOBAL VARIABLES vv*/
    protected double globalSpeed;
    protected ArrayList<Actor> projectiles = new ArrayList<Actor>();//only put projectile is here
    protected MouseInfo mouse;
    protected Vector mousePos = new Vector();
    /*^^ GLOBAL VARIABLES ^^*/
    
    /**
     * Calls the constructor of the super class world to generate the canvas.
     * 
     * @author  Zachary Sousa
     * @version 1.00
     */
    public AncestorGame(int width, int height) {    
        super(width, height, 1);
        mouse = Greenfoot.getMouseInfo();
    }
    
    public void act(){
        updateMouse();
    }
    
    protected void updateMouse(){
        try{
            mouse = Greenfoot.getMouseInfo();
            mousePos.setX(mouse.getX());
            mousePos.setY(mouse.getY());
        } catch (Exception e){
            mousePos.setX(0);
            mousePos.setY(0);
        }
    }
    
    /*vv USEFUL FUNCTIONS vv*/
    /**
     * getGlobalSpeed
     * @return globalSpeed
     * 
     * @author  Zachary Sousa
     * @version 1.00
     */
    public double getGlobalSpeed() {
        return globalSpeed;
    }
    
    /**
     * removes the given Object from the world and removes it from the list it originates from.
     */
    public void despawn(Actor obj, ArrayList<Actor> list) {
        removeObject(obj);
        list.remove(obj);
    }
    
    public ArrayList<Actor> getBullets(){
        return projectiles;
    }
    
    /**
     * remaps a number between two ranges
     *
     * @author EliWood
     * @version 1
     *
     * @param s the number to map
     * @param low1 the low range
     * @param high1 the high range
     * @param low2 the new low range
     * @param high2 the new high range
     * @return s remapped to the new range
     */
    public static double map(double s, double low1, double high1, double low2, double high2){
        return (s-low1)*(high2-low2)/(high1-low1) + low2;
    }
}
