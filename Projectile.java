import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author Eli Wood
 * @version 1
 */
public abstract class Projectile extends SmoothMover{
    protected Vector pos;
    protected Vector vel;
    protected GreenfootImage img;
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @param img the image to use
     */
    public Projectile(GreenfootImage img){
        this.img = img;
        setImage(img);
    }
    
    /**
     * Constructor
     * 
     * @param img the image to use
     * @param degRot the intial rotation in degrees
     */
    public Projectile(GreenfootImage img, int degRot){
        this.img = img;
        setImage(img);
        
        img.rotate(degRot);
    }
    
    /**
     * check if off screen (usually remove object)
     */
    public abstract void checkEdge();
    
    /**
     * interact with the player
     * 
     * @param p the player(not implemented yet)
     */
    public abstract void interact(/*Player p*/);
}
