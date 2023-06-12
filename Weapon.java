import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * abstract weapon class
 * 
 * @author Eli Wood 
 * @version 1
 */
public abstract class Weapon extends SmoothMover{
    protected Vector pos = new Vector();
    protected Vector target = new Vector();
    protected GreenfootImage image;
    private int degRot = 0;
    protected AncestorGame game;
    ArrayList<Projectile> bullets;
    Car owner;
    protected int damage;
    protected int attackSpeed;//frames between attacks
    protected int lastAttack = 0;
    protected double bulletSpeed = 5;
    
    /**
     * Constructor
     */
    public Weapon(Vector target, GreenfootImage image, Car owner, int attackSpeed){
        this.target = target;
        this.image = image;
        setImage(image);
        this.owner = owner;
        image.rotate(90);
        this.attackSpeed = attackSpeed;
    }
    
    /**
     * Constructor
     */
    public Weapon(Vector target, GreenfootImage image, Car owner, int attackSpeed, int damage){
        this.target = target;
        this.image = image;
        setImage(image);
        this.owner = owner;
        image.rotate(90);
        this.damage = damage;
        this.attackSpeed = attackSpeed;
    }
    
    /**
     * main act function *don't override*
     * use shoot for code instead
     * 
     * @author Eli Wood
     */
    public void act(){
        if(game == null){
            game = (AncestorGame)getWorld();
            bullets = game.getBullets();
        }
        
        pos.setX(getExactX());
        pos.setY(getExactY());
        
        rotateTowards(target);
    }
    
    /**
     * put weapon code here
     */
    public abstract void shoot();
    
    /**
     * rotates towards a Vector
     * 
     * @author Eli Wood
     * @param target what to rotate towards
     */
    private void rotateTowards(Vector target){
        /*
        Vector dir = Vector.sub(target, pos);
        
        double degTarget = Math.toDegrees(dir.heading()) + 90;
        
        if(degTarget >= 360){
            degTarget -= 360;
        }
        
        image.rotate((int)degTarget - degRot);
        degRot += (int)degTarget;
        */
        turnTowards((int)target.getX(), (int)target.getY());
        
        
        
    }
}
