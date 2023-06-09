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
    }
    
    /**
     * shoots the gun
     */
    public void shoot(){
        Vector vel = Vector.sub(target, pos);
        
        vel.rotate(Math.toRadians((r.nextDouble() * maxShotDeviance * 2) - maxShotDeviance));
        vel.setMag(5);
        
        bullets.add(new Bullet(vel, 5, bulletImage, bullets, owner));
        game.addObject(bullets.get(bullets.size()-1), (int)pos.getX(), (int)pos.getY());
    }
}
