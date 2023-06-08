import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Projectile here.
 * 
 * @author Eli Wood
 * @version 1
 */
public abstract class Projectile extends SmoothMover implements Despawnable{
    protected Vector pos;
    protected Vector vel = new Vector();
    protected GreenfootImage img;
    protected int degRot;//rotation in degrees
    protected AncestorGame game;
    protected ArrayList<Actor> list;
    protected Car ignores;
    protected double damage;
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @param img the image to use
     * @param vel the velocity of the projectile
     */
    public Projectile(Vector vel, GreenfootImage img, ArrayList<Actor> list, Car ignores){
        this.img = img;
        setImage(img);
        this.vel = vel;
        this.list = list;
        this.ignores = ignores;
        
    }
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @param img the image to use
     * @param vel the velocity of the projectile
     */
    public Projectile(Vector vel, double damage, GreenfootImage img, ArrayList<Actor> list, Car ignores){
        this.img = img;
        setImage(img);
        img.rotate(90);
        this.vel = vel;
        this.list = list;
        this.ignores = ignores;
        this.damage = damage;
    }
    
    /**
     * main act function
     */
    public void act(){
        if(game == null){
            game = (AncestorGame)getWorld();
        }
        if(pos == null){
            pos = new Vector(getExactX(), getExactY());
        }
        
        pos.add(vel);
        
        rotateStraight();
        
        setLocation(pos);
        
        checkEdge();
    }
    
    /**
     * check if off screen (usually remove object)
     */
    public abstract void checkEdge();
    
    /**
     * interact with the player
     * 
     * @param c the car to interact with
     */
    public abstract void interact(Car c);
    
    /**
     * rotates towards the direction the velocity is in
     * 
     * @author Eli Wood
     */
    private void rotateStraight(){
        /*
        double degTarget = Math.toDegrees(vel.heading()) + 90;
        
        if(degTarget >= 360){
            degTarget -= 360;
        }
        
        img.rotate((int)degTarget - degRot);
        degRot += (int)degTarget;
        */
        Vector tar = new Vector(pos.getX() + vel.getX(), pos.getY() + vel.getY());
        
        turnTowards((int)tar.getX(), (int)tar.getY());
    }
    
    public void despawn(Actor a, ArrayList<Actor> list){
        game.despawn(a, list);
    }
}
