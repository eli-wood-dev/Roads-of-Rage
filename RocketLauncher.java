import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RocketLauncher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RocketLauncher extends Weapon{
    private GreenfootImage bulletImage;
    GifImage bulletGif;
    
    
    /**
     * Constructor
     * 
     * @param target what to shoot at
     * @param image the image for the gun
     */
    public RocketLauncher(Vector target, GreenfootImage image,Car owner, int attackSpeed){
        super(target, image, owner, attackSpeed);
        bulletImage = new GreenfootImage("bullet.png");
        bulletGif = new GifImage("rocket.gif");
        bulletGif.pause();
        bulletImage.scale(9, 18);
    }
    
    /**
     * Constructor
     * 
     * @param target what to shoot at
     * @param image the image for the gun
     */
    public RocketLauncher(Vector target, GreenfootImage image, Car owner, int attackSpeed, int damage){
        super(target, image, owner, attackSpeed, damage);
        bulletImage = new GreenfootImage("bullet.png");
        bulletGif = new GifImage("rocket.gif");
        bulletGif.pause();
        bulletImage.scale(9, 18);
    }
    
    /**
     * Constructor
     * 
     * @param target what to shoot at
     * @param image the image for the gun
     */
    public RocketLauncher(Vector target, GreenfootImage image, Car owner, int attackSpeed, int damage, double bulletSpeed){
        super(target, image, owner, attackSpeed, damage, bulletSpeed);
        bulletImage = new GreenfootImage("bullet.png");
        bulletGif = new GifImage("rocket.gif");
        bulletGif.pause();
        bulletImage.scale(9, 18);
    }
    
    /**
     * Constructor
     * 
     * @param target what to shoot at
     * @param image the image for the gun
     */
    public RocketLauncher(Vector target, GifImage gif, Car owner, int attackSpeed){
        super(target, gif, owner, attackSpeed);
        bulletImage = new GreenfootImage("bullet.png");
        bulletGif = new GifImage("rocket.gif");
        bulletGif.pause();
        bulletImage.scale(9, 18);
    }
    
    /**
     * Constructor
     * 
     * @param target what to shoot at
     * @param image the image for the gun
     */
    public RocketLauncher(Vector target, GifImage gif, Car owner, int attackSpeed, int damage){
        super(target, gif, owner, attackSpeed, damage);
        bulletImage = new GreenfootImage("bullet.png");
        bulletGif = new GifImage("rocket.gif");
        bulletGif.pause();
        bulletImage.scale(9, 18);
    }
    
    /**
     * Constructor
     * 
     * @param target what to shoot at
     * @param image the image for the gun
     */
    public RocketLauncher(Vector target, GifImage gif, Car owner, int attackSpeed, int damage, double bulletSpeed){
        super(target, gif, owner, attackSpeed, damage, bulletSpeed);
        bulletImage = new GreenfootImage("bullet.png");
        bulletGif = new GifImage("rocket.gif");
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
            
            vel.setMag(bulletSpeed);
            
            bullets.add(new Missile(vel, target, damage, new GifImage(bulletGif), bullets, owner));
            game.addObject(bullets.get(bullets.size()-1), (int)pos.getX(), (int)pos.getY());
        }
    }
}
