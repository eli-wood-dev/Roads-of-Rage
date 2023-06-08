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
    protected int degRot;//rotation in degrees
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @param img the image to use
     */
    public Projectile(Vector vel, GreenfootImage img){
        this.img = img;
        setImage(img);
        this.vel = vel;
    }
    
    /**
     * main act function
     */
    public void act(){
        pos.add(vel);
        
        rotateStraight();
        
        checkEdge();
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
    
    /**
     * rotates towards the direction the velocity is in
     * 
     * @author Eli Wood
     */
    private void rotateStraight(){
        double degTarget = Math.toDegrees(vel.heading()) + 90;
        
        if(degTarget >= 360){
            degTarget -= 360;
        }
        
        img.rotate((int)degTarget - degRot);
        degRot += (int)degTarget;
    }
}
