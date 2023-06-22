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
    protected AncestorGame game;
    protected ArrayList<Projectile> list;
    protected Car ignores;
    protected int damage;
    GifImage gif;
    protected boolean shouldDespawn = false;
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @param img the image to use
     * @param vel the velocity of the projectile
     */
    public Projectile(Vector vel, GreenfootImage img, ArrayList<Projectile> list, Car ignores){
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
    public Projectile(Vector vel, int damage, GreenfootImage img, ArrayList<Projectile> list, Car ignores){
        this.img = img;
        setImage(img);
        this.vel = vel;
        this.list = list;
        this.ignores = ignores;
        this.damage = damage;
    }
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @param img the image to use
     * @param vel the velocity of the projectile
     */
    public Projectile(Vector vel, GifImage gif, ArrayList<Projectile> list, Car ignores){
        this.gif = gif;
        setImage(gif.getCurrentImage());
        gif.resume();
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
    public Projectile(Vector vel, int damage, GifImage gif, ArrayList<Projectile> list, Car ignores){
        this.gif = gif;
        setImage(gif.getCurrentImage());
        gif.resume();
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
        
        if(gif != null){
            setImage(gif.getCurrentImage());
        }
        
        pos.add(vel);
        
        rotateStraight();
        
        setLocation(pos);
        
        //move(vel.getMag());
        
        //pos.set(getExactX(), getExactY());
        
        if(getIntersectingObjects(Car.class) != null){
            for(Car c: getIntersectingObjects(Car.class)){
                interact(c);//need to change
            }
        }
        
        
        if(shouldDespawn){
            despawn();
        } else{//prevent double despawning
            checkEdge();
        }
    }
    
    /**
     * check if off screen (usually remove object)
     */
    public abstract void checkEdge();
    
    /**
     * default interaction to damage car and kill itself
     */
    public void interact(Car c){
        if(c != ignores){
            c.hurt(damage);
            //despawn();
            shouldDespawn = true;
        }
    }
    
    /**
     * rotates towards the direction the velocity is in
     * 
     * @author Eli Wood
     */
    protected void rotateStraight(){
        /*
        double degTarget = Math.toDegrees(vel.heading()) + 90;
        
        if(degTarget >= 360){
            degTarget -= 360;
        }
        
        setRotation((int)degTarget - degRot);
        degRot += (int)degTarget;
        
        Vector tar = new Vector(pos.getX() + vel.getX(), pos.getY() + vel.getY());
        
        turnTowards((int)tar.getX(), (int)tar.getY());
        */
        
        setRotation((int)Math.toDegrees(vel.heading()));
        
    }
    
    public void despawn(/*Actor a, ArrayList<? extends Actor> list*/){
        game.despawn(this, list);
    }
}
