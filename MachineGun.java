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
    double maxShotDeviance;
    Random r;
    GreenfootImage bulletImage;
    
    
    /**
     * Constructor
     * 
     * @param target what to shoot at
     * @param image the image for the gun
     */
    public MachineGun(Vector target, GreenfootImage image, int maxShotDeviance, Car owner){
        super(target, image, owner);
        this.maxShotDeviance = maxShotDeviance;
        r = new Random();
        bulletImage = new GreenfootImage("bullet.png");
        bulletImage.scale(9, 18);
        damage = 5;
    }
    
    /**
     * Constructor
     * 
     * @param target what to shoot at
     * @param image the image for the gun
     */
    public MachineGun(Vector target, GreenfootImage image, int maxShotDeviance, Car owner, double damage){
        super(target, image, owner, damage);
        this.maxShotDeviance = maxShotDeviance;
        r = new Random();
        bulletImage = new GreenfootImage("bullet.png");
        bulletImage.scale(9, 18);
    }
    
    /**
     * shoots the gun
     */
    public void shoot(){
        Vector vel = Vector.sub(target, pos);
        
        vel.rotate(Math.toRadians((r.nextDouble() * maxShotDeviance) - maxShotDeviance/2));
        vel.setMag(5);
        
        bullets.add(new Bullet(vel, damage, bulletImage, bullets, owner));
        game.addObject(bullets.get(bullets.size()-1), (int)pos.getX(), (int)pos.getY());
    }
}
