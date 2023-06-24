import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class Shotgun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shotgun extends Weapon{
    protected double maxShotDeviance;
    protected Random r;
    protected GreenfootImage bulletImage;
    protected int numPellets;
    protected GifImage bulletGif;
    protected boolean animating = false;
    
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
        bulletGif = new GifImage("plasma2.gif");
        bulletGif.pause();
        damage = 5;
        this.numPellets = numPellets;
    }
    
    /**
     * Constructor
     * 
     * @param target what to shoot at
     * @param image the image for the gun
     */
    public Shotgun(Vector target, GreenfootImage image, int maxShotDeviance, Car owner, int attackSpeed, int numPellets, int damage){
        super(target, image, owner, attackSpeed, damage);
        this.maxShotDeviance = maxShotDeviance;
        r = new Random();
        bulletImage = new GreenfootImage("pellet.png");
        bulletImage.scale(16, 9);
        bulletGif = new GifImage("plasma2.gif");
        bulletGif.pause();
        this.numPellets = numPellets;
    }
    
    /**
     * Constructor
     * 
     * @param target what to shoot at
     * @param image the image for the gun
     */
    public Shotgun(Vector target, GreenfootImage image, int maxShotDeviance, Car owner, int attackSpeed, int numPellets, int damage, double bulletSpeed){
        super(target, image, owner, attackSpeed, damage, bulletSpeed);
        this.maxShotDeviance = maxShotDeviance;
        r = new Random();
        bulletImage = new GreenfootImage("pellet.png");
        bulletImage.scale(16, 9);
        bulletGif = new GifImage("plasma2.gif");
        bulletGif.pause();
        this.numPellets = numPellets;
    }
    
    /**
     * Constructor
     * 
     * @param target what to shoot at
     * @param image the image for the gun
     */
    public Shotgun(Vector target, GifImage gif, int maxShotDeviance, Car owner, int attackSpeed, int numPellets){
        super(target, gif, owner, attackSpeed);
        this.maxShotDeviance = maxShotDeviance;
        r = new Random();
        bulletImage = new GreenfootImage("pellet.png");
        bulletImage.scale(9, 18);
        bulletGif = new GifImage("plasma2.gif");
        bulletGif.pause();
        damage = 5;
        this.numPellets = numPellets;
    }
    
    /**
     * Constructor
     * 
     * @param target what to shoot at
     * @param image the image for the gun
     */
    public Shotgun(Vector target, GifImage gif, int maxShotDeviance, Car owner, int attackSpeed, int numPellets, int damage){
        super(target, gif, owner, attackSpeed, damage);
        this.maxShotDeviance = maxShotDeviance;
        r = new Random();
        //bulletImage = new GreenfootImage("pellet.png");
        //bulletImage.scale(16, 9);
        bulletGif = new GifImage("plasma2.gif");
        bulletGif.pause();
        this.numPellets = numPellets;
    }
    
    /**
     * Constructor
     * 
     * @param target what to shoot at
     * @param image the image for the gun
     */
    public Shotgun(Vector target, GifImage gif, int maxShotDeviance, Car owner, int attackSpeed, int numPellets, int damage, double bulletSpeed){
        super(target, gif, owner, attackSpeed, damage, bulletSpeed);
        this.maxShotDeviance = maxShotDeviance;
        r = new Random();
        //bulletImage = new GreenfootImage("pellet.png");
        //bulletImage.scale(16, 9);
        bulletGif = new GifImage("plasma2.gif");
        bulletGif.pause();
        this.numPellets = numPellets;
    }
    
    public void act(){
        super.act();
        if(animating){
            gif.advanceFrame();
            if(gif.getCurrentImage() == gif.getImages().get(0)){
                animating = false;
            }
        }
    }
    
    public void shoot(){
        if(game.getFrameCount() - lastAttack > attackSpeed){
            if(gif != null){
                animating = true;
                gif.advanceFrame();
            }
            
            lastAttack = game.getFrameCount();
            
            for(int i = 0; i < numPellets; i++){
                Vector vel = Vector.sub(target, pos);
                
                Vector posOffset = vel.copy();
            
                vel.rotate(Math.toRadians((r.nextDouble() * maxShotDeviance) - maxShotDeviance/2));
                vel.setMag(5);
                
                posOffset.setMag(getImage().getHeight()/2);
                posOffset.add(pos);
                
                bullets.add(new Bullet(vel, damage,/*new GreenfootImage(bulletImage)*/ new GifImage(bulletGif), bullets, owner));
                game.addObject(bullets.get(bullets.size()-1), (int)posOffset.getX(), (int)posOffset.getY());
            }
        }
    }
}
