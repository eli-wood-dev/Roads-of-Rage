import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RocketLauncher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RocketLauncher extends Weapon{
    protected GreenfootImage bulletImage;
    protected GifImage bulletGif;
    
    
    /**
     * Constructor
     * 
     * @param target what to shoot at
     * @param image the image for the gun
     */
    public RocketLauncher(Vector target, GreenfootImage image, Car owner, int attackSpeed){
        super(target, image, owner, attackSpeed);
        //bulletImage = new GreenfootImage("bullet.png");
        bulletGif = new GifImage("rocket.gif");
        bulletGif.pause();
        //bulletImage.scale(9, 18);
        for(GreenfootImage g : bulletGif.getImages()){
            g.scale(16, 32);
        }
    }
    
    /**
     * Constructor
     * 
     * @param target what to shoot at
     * @param image the image for the gun
     */
    public RocketLauncher(Vector target, GreenfootImage image, Car owner, int attackSpeed, int damage){
        super(target, image, owner, attackSpeed, damage);
        //bulletImage = new GreenfootImage("bullet.png");
        bulletGif = new GifImage("rocket.gif");
        bulletGif.pause();
        //bulletImage.scale(9, 18);
        for(GreenfootImage g : bulletGif.getImages()){
            g.scale(16, 32);
        }
    }
    
    /**
     * Constructor
     * 
     * @param target what to shoot at
     * @param image the image for the gun
     */
    public RocketLauncher(Vector target, GreenfootImage image, Car owner, int attackSpeed, int damage, double bulletSpeed){
        super(target, image, owner, attackSpeed, damage, bulletSpeed);
        //bulletImage = new GreenfootImage("bullet.png");
        bulletGif = new GifImage("rocket.gif");
        bulletGif.pause();
        //bulletImage.scale(9, 18);
        for(GreenfootImage g : bulletGif.getImages()){
            g.scale(16, 32);
        }
    }
    
    /**
     * Constructor
     * 
     * @param target what to shoot at
     * @param image the image for the gun
     */
    public RocketLauncher(Vector target, GifImage gif, Car owner, int attackSpeed){
        super(target, gif, owner, attackSpeed);
        //bulletImage = new GreenfootImage("bullet.png");
        bulletGif = new GifImage("rocket.gif");
        bulletGif.pause();
        //bulletImage.scale(9, 18);
        for(GreenfootImage g : bulletGif.getImages()){
            g.scale(16, 32);
        }
    }
    
    /**
     * Constructor
     * 
     * @param target what to shoot at
     * @param image the image for the gun
     */
    public RocketLauncher(Vector target, GifImage gif, Car owner, int attackSpeed, int damage){
        super(target, gif, owner, attackSpeed, damage);
        //bulletImage = new GreenfootImage("bullet.png");
        bulletGif = new GifImage("rocket.gif");
        bulletGif.pause();
        //bulletImage.scale(9, 18);
        for(GreenfootImage g : bulletGif.getImages()){
            g.scale(16, 32);
        }
    }
    
    /**
     * Constructor
     * 
     * @param target what to shoot at
     * @param image the image for the gun
     */
    public RocketLauncher(Vector target, GifImage gif, Car owner, int attackSpeed, int damage, double bulletSpeed){
        super(target, gif, owner, attackSpeed, damage, bulletSpeed);
        //bulletImage = new GreenfootImage("bullet.png");
        bulletGif = new GifImage("rocket.gif");
        bulletGif.pause();
        //bulletImage.scale(9, 18);
        
        for(GreenfootImage g : bulletGif.getImages()){
            g.scale(16, 32);
        }
    }
    
    /**
     * shoots the gun
     */
    public void shoot(){
        if(game.getFrameCount() - lastAttack > attackSpeed){
            if(gif != null){
                gif.advanceFrame();
            }
            
            lastAttack = game.getFrameCount();
            
            Vector vel = Vector.sub(target, pos);
            Vector posOffset = vel.copy();
            
            vel.setMag(bulletSpeed);
            
            posOffset.setMag(getImage().getHeight()/2);
            posOffset.add(pos);
            
            bullets.add(new Missile(vel, target, damage, new GifImage(bulletGif), bullets, owner));
            game.addObject(bullets.get(bullets.size()-1), (int)posOffset.getX(), (int)posOffset.getY());
        }
    }
}
