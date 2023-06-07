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
    /*^^ GLOBAL VARIABLES ^^*/
    
    /**
     * Calls the constructor of the super class world to generate the canvas.
     * 
     * @author  Zachary Sousa
     * @version 1.00
     */
    public AncestorGame(int width, int height) {    
        super(width, height, 1);
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
    
}
