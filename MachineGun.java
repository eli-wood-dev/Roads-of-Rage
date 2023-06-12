import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Random;

/**
 * Write a description of class MachineGun here.
 * 
 * @author Eli Wood
 * @version 1
 */
public class MachineGun extends Weapon{
    private double maxShotDeviance;
    private Random r;
    private GreenfootImage bulletImage;
    GifImage bulletGif;
    
    
    /**
     * Constructor
     * 
     * @param target what to shoot at
     * @param image the image for the gun
     */
    public MachineGun(Vector target, GreenfootImage image, int maxShotDeviance, Car owner, int attackSpeed){
        super(target, image, owner, attackSpeed);
        this.maxShotDeviance = maxShotDeviance;
        r = new Random();
        bulletImage = new GreenfootImage("bullet.png");
        bulletGif = new GifImage("plasma1.gif");
        bulletGif.pause();
        bulletImage.scale(9, 18);
        damage = 5;
    }
    
    /**
     * Constructor
     * 
     * @param target what to shoot at
     * @param image the image for the gun
     */
    public MachineGun(Vector target, GreenfootImage image, int maxShotDeviance, Car owner, int attackSpeed, int damage){
        super(target, image, owner, attackSpeed, damage);
        this.maxShotDeviance = maxShotDeviance;
        r = new Random();
        bulletImage = new GreenfootImage("bullet.png");
        bulletGif = new GifImage("plasma1.gif");
        bulletGif.pause();
        bulletImage.scale(9, 18);
    }
    
    /**
     * Constructor
     * 
     * @param target what to shoot at
     * @param image the image for the gun
     */
    public MachineGun(Vector target, GreenfootImage image, int maxShotDeviance, Car owner, int attackSpeed, int damage, double bulletSpeed){
        super(target, image, owner, attackSpeed, damage, bulletSpeed);
        this.maxShotDeviance = maxShotDeviance;
        r = new Random();
        bulletImage = new GreenfootImage("bullet.png");
        bulletGif = new GifImage("plasma1.gif");
        bulletGif.pause();
        bulletImage.scale(9, 18);
    }
    
    /**
     * Constructor
     * 
     * @param target what to shoot at
     * @param image the image for the gun
     */
    public MachineGun(Vector target, GifImage gif, int maxShotDeviance, Car owner, int attackSpeed){
        super(target, gif, owner, attackSpeed);
        this.maxShotDeviance = maxShotDeviance;
        r = new Random();
        bulletImage = new GreenfootImage("bullet.png");
        bulletGif = new GifImage("plasma1.gif");
        bulletGif.pause();
        bulletImage.scale(9, 18);
        damage = 5;
    }
    
    /**
     * Constructor
     * 
     * @param target what to shoot at
     * @param image the image for the gun
     */
    public MachineGun(Vector target, GifImage gif, int maxShotDeviance, Car owner, int attackSpeed, int damage){
        super(target, gif, owner, attackSpeed, damage);
        this.maxShotDeviance = maxShotDeviance;
        r = new Random();
        bulletImage = new GreenfootImage("bullet.png");
        bulletGif = new GifImage("plasma1.gif");
        bulletGif.pause();
        bulletImage.scale(9, 18);
    }
    
    /**
     * Constructor
     * 
     * @param target what to shoot at
     * @param image the image for the gun
     */
    public MachineGun(Vector target, GifImage gif, int maxShotDeviance, Car owner, int attackSpeed, int damage, double bulletSpeed){
        super(target, gif, owner, attackSpeed, damage, bulletSpeed);
        this.maxShotDeviance = maxShotDeviance;
        r = new Random();
        bulletImage = new GreenfootImage("bullet.png");
        bulletGif = new GifImage("plasma1.gif");
        bulletGif.pause();
        bulletImage.scale(9, 18);
    }
    
    /**
     * shoots the gun
     */
    public void shoot(){
        if(game.getFrameCount() - lastAttack > attackSpeed){
            if(gif != null){
                gif.resume();
            }
            
            lastAttack = game.getFrameCount();
            
            Vector vel = Vector.sub(target, pos);
            
        
            vel.rotate(Math.toRadians((r.nextDouble() * maxShotDeviance) - maxShotDeviance/2));
            vel.setMag(bulletSpeed);
            
            bullets.add(new Bullet(vel, damage,/* new GreenfootImage(bulletImage)*/ new GifImage(bulletGif), bullets, owner));
            game.addObject(bullets.get(bullets.size()-1), (int)pos.getX(), (int)pos.getY());
        }
    }
}
