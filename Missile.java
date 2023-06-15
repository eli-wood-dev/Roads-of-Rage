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
    public Missile(Vector vel, Vector target, int damage, GreenfootImage img, ArrayList<Projectile> list, Car ignores){
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
    public Missile(Vector vel, Vector target, int damage, GifImage img, ArrayList<Projectile> list, Car ignores){
        super(vel, damage, img, list, ignores);
        this.target = target;
    }
    
    public void checkEdge(){
        frame++;
        if(frame > Constants.MISSILE_LIFESPAN){
            despawn(this, list);
        }
    }
    
    protected void rotateStraight(){
        //rotate vel to target
        Vector dir = Vector.sub(target, pos);
        dir.normalize();
        
        double speed = vel.getMag();
        
        //vel.normalize();
        
        if(/*dir.heading() - vel.heading() > 0.01 || dir.heading() - vel.heading() < -0.01*/Math.abs(pos.getX() - target.getX()) > Constants.MISSILE_ALLOWANCE && Math.abs(pos.getY() - target.getY()) > Constants.MISSILE_ALLOWANCE){
            
            if(vel.heading() > dir.heading() || Vector.angleBetween(vel, dir) > Math.PI){
                if(vel.heading() - dir.heading() > Constants.MISSILE_TURN_AMOUNT){
                    vel.rotate(-Constants.MISSILE_TURN_AMOUNT);
                } else{
                    vel.setRotation(Utilities.lerp(0, Vector.angleBetween(dir, vel), Constants.MISSILE_TURN_RATE) + dir.heading());
                }
            } else{
                if(vel.heading() - dir.heading() < -Constants.MISSILE_TURN_AMOUNT){
                    vel.rotate(Constants.MISSILE_TURN_AMOUNT);
                } else{
                    vel.setRotation(Utilities.lerp(vel.heading(), dir.heading(), Constants.MISSILE_TURN_RATE));
                }
            }
            
            //vel.setRotation(dir.heading());
            
        }
        vel.setMag(speed);
        
        super.rotateStraight();
        
        setRotation(getRotation() + 90);
    }
    
    public void despawn(Actor a, ArrayList<? extends Actor> list){
        game.addObject(new Explosion(this), getX(), getY());
        
        super.despawn(this, list);
    }
}
