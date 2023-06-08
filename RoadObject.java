import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * RoadObject moves with the screen using the global speed of travel.
 * 
 * @author      Zachary Sousa
 * @version     1.00
 */
public class RoadObject extends SmoothMover implements Despawnable
{
    private Vector pos;                 //the position of the Car on the screen
    private double globalSpeed;         //the rate that the world is moving at
    private double speedMultiplier = 1; //multiplies the speed, 1 for down, -1 for up
    protected AncestorGame game;
    protected ArrayList<Actor> list;    //the list that this object is a part of
    
    /**
     * Constructor for the RoadObject, initializes the Vector position.
     * 
     * @author  Zachary Sousa
     * @version 1.00
     */
    public RoadObject(AncestorGame game, ArrayList<Actor> list) {
        pos = new Vector(getX(), getY());
        this.game = game;
        this.list = list;
    }
    
    /**
     * act is called once per frame. The RoadObject moves downward (or upward if 
     * speedMultiplier is set to a negative number).
     * 
     * @author  Zachary Sousa
     * @version 1.00
     */
    public void act() {
        globalSpeed = game.getGlobalSpeed();
        pos.add(0, globalSpeed * speedMultiplier);
        
        setLocation(pos.getX(), pos.getY());    //update actor position to match pos
    }
    
    /**
     * returns the Vector position of the RoadObject.
     * 
     * @author  Zachary Sousa
     * @version 1.00
     */
    public Vector getPos() {
        return pos;
    }
    
    /**
     * sets the globalSpeed of the RoadObject
     * 
     * @author  Zachary Sousa
     * @version 1.00
     */
    public void setGlobalSpeed(double globalSpeed) {
        this.globalSpeed = globalSpeed;
    }
    
    /**
     * 
     */
    public void despawn(Actor a, ArrayList<Actor> list) {
        
    }
}
