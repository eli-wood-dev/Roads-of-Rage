import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Missile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Missile extends Projectile{
    Vector target;
    int frame = 0;
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @param img the image to use
     * @param vel the velocity of the projectile
     */
    public Missile(Vector vel, Vector target, double damage, GreenfootImage img, ArrayList<Actor> list, Car ignores){
        super(vel, damage, img, list, ignores);
        this.target = target;
    }
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @param img the image to use
     * @param vel the velocity of the projectile
     */
    public Missile(Vector vel, Vector target, double damage, GifImage img, ArrayList<Actor> list, Car ignores){
        super(vel, damage, img, list, ignores);
        this.target = target;
    }
    
    public void checkEdge(){
        frame++;
        if(frame > Constants.MISSILE_LIFESPAN){
            despawn(this, list);
        }
        
        if(pos.equals(target)){
            despawn(this, list);
        }
    }
    
    public void interact(Car c){
        if(c != ignores){
            //damage the car
        }
    }
    
    protected void rotateStraight(){
        //rotate vel to target
        Vector dir = Vector.sub(target, pos);
        dir.normalize();
        Vector currentDir = vel.copy();
        currentDir.normalize();
        
        double speed = vel.getMag();
        if(!dir.equals(currentDir)){//check if already straight
            vel.rotate(Utilities.lerp(vel.heading(), dir.heading(), Constants.MISSILE_TURN_RATE) - vel.heading());
            vel.setMag(speed);
        }
        super.rotateStraight();
        
        setRotation(getRotation() + 90);
    }
}
