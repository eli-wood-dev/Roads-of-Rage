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
    double maxShotDeviance;//positive shot deviance in degrees
    Random r;
    
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
    }
    
    /**
     * shoots the gun
     */
    public void shoot(){
        Vector vel = target.copy();
        vel.setMag(5);
        vel.rotate(Math.toDegrees(r.nextDouble() * maxShotDeviance * 2) - maxShotDeviance);
        
        bullets.add(new Bullet(vel, 5, new GreenfootImage("bullet.png"), bullets, owner));
    }
}
