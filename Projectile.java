import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author Eli Wood
 * @version 1
 */
public abstract class Projectile extends SmoothMover{
    private Vector pos;
    private Vector vel;
    
    /**
     * Constructor
     */
    public Projectile(){
        
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
