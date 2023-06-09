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
    protected int frameCount;//increment in all act methods
    /*^^ GLOBAL VARIABLES ^^*/
    
    /**
     * Calls the constructor of the super class world to generate the canvas.
     * 
     * @author  Zachary Sousa
     * @version 1.00
     */
    public AncestorGame(int width, int height) {    
        super(width, height, 1, false);
        mouse = Greenfoot.getMouseInfo();
    }
    
    public int getFrameCount(){
        return frameCount;
    }
    
    public void act(){
        frameCount++;
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
     * 
     * @param obj       the Actor to despawn
     * @param list      the list the Actor is in
     * 
     * @author  Zachary Sousa
     * @version 1.00
     */
    public void despawn(Actor obj, ArrayList<Actor> list) {
        removeObject(obj);
        list.remove(obj);
    }
    
    public ArrayList<Actor> getBullets(){
        return projectiles;
    }
    
    
}
