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
    protected Vector pos;                              //the position of the Car on the screen
    protected double globalSpeed;                      //the rate that the world is moving at
    protected double speedMultiplier = 1;              //multiplies the speed, 1 for down, -1 for up
    protected AncestorGame game;
    protected ArrayList<? extends RoadObject> list;    //the list that this object is a part of
    protected Vector vel = new Vector(0, 0);           //current speed(only here to prevent ordering problems)
    protected GreenfootImage image;
    
    protected Weapon w;
    
    public RoadObject(){
        
    }
    
    /**
     * Constructor for the RoadObject, initializes the Vector position.
     * 
     * @author  Zachary Sousa
     * @version 1.00
     */
    public RoadObject(AncestorGame game, ArrayList<? extends RoadObject> list) {
        this.game = game;
        this.list = list;
    }
    
    /**
     * Constructor for the RoadObject, initializes the Vector position.
     * 
     * @author  Zachary Sousa
     * @version 1.00
     */
    public RoadObject(AncestorGame game, ArrayList<? extends RoadObject> list, GreenfootImage image) {
        this.game = game;
        this.list = list;
        this.image = image;
        setImage(image);
    }
    
    /**
     * act is called once per frame. The RoadObject moves downward (or upward if 
     * speedMultiplier is set to a negative number).
     * 
     * @author  Zachary Sousa
     * @version 1.00
     */
    public void act() {
        if(pos == null){
            pos = new Vector(getExactX(), getExactY());
        }
        
        globalSpeed = game.getGlobalSpeed();
        pos.add(0, globalSpeed * speedMultiplier);
        pos.add(vel);
        
        setLocation(pos);    //update actor position to match pos
        
        if(pos.getX() > game.getWidth() || pos.getX() < 0 || pos.getY() > game.getHeight() || pos.getY() < 0){
            despawn();
        }
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
     * despawn an actor, override this method to add explosions or sounds.
     * 
     * @author  Zachary Sousa
     * @version 1.00
     */
    public void despawn(/*Actor a, ArrayList<? extends Actor> list*/) {
        if(w != null){
            w.despawn();
        }
        game.despawn(this, list);
    }
    
    /**
     * sets the velocity
     * probably used to control the player
     */
    public void setVel(Vector v){
        vel = v;
    }
    
    /**
     * shoots the gun
     */
    public void shoot(){
        if(w != null){
            w.shoot();
        }
        
    }
    
    /**
     * sets the gun
     * should only be called by a gun
     */
    public void setGun(Weapon w){
        this.w = w;
    }
    
    /**
     * gets the car's gun
     */
    public Weapon getGun(){
        return w;
    }
}
