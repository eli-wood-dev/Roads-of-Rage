import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class Shotgun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shotgun extends Weapon{
    private double maxShotDeviance;
    private Random r;
    private GreenfootImage bulletImage;
    private int numPellets;
    
    /**
     * Constructor
     * 
     * @param target what to shoot at
     * @param image the image for the gun
     */
    public Shotgun(Vector target, GreenfootImage image, int maxShotDeviance, Car owner, int attackSpeed, int numPellets){
        super(target, image, owner, attackSpeed);
        this.maxShotDeviance = maxShotDeviance;
        r = new Random();
        bulletImage = new GreenfootImage("pellet.png");
        bulletImage.scale(9, 18);
        damage = 5;
        this.numPellets = numPellets;
    }
    
    /**
     * Constructor
     * 
     * @param target what to shoot at
     * @param image the image for the gun
     */
    public Shotgun(Vector target, GreenfootImage image, int maxShotDeviance, Car owner, int attackSpeed, int numPellets, double damage){
        super(target, image, owner, attackSpeed, damage);
        this.maxShotDeviance = maxShotDeviance;
        r = new Random();
        bulletImage = new GreenfootImage("pellet.png");
        bulletImage.scale(16, 9);
        this.numPellets = numPellets;
    }
    
    public void shoot(){
        if(game.getFrameCount() - lastAttack > attackSpeed){
            lastAttack = game.getFrameCount();
            
            for(int i = 0; i < numPellets; i++){
                Vector vel = Vector.sub(target, pos);
                
            
                vel.rotate(Math.toRadians((r.nextDouble() * maxShotDeviance) - maxShotDeviance/2));
                vel.setMag(5);
                
                bullets.add(new Bullet(vel, damage, new GreenfootImage(bulletImage), bullets, owner));
                game.addObject(bullets.get(bullets.size()-1), (int)pos.getX(), (int)pos.getY());
            }
        }
    }
}
