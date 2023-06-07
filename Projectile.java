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
    
    public Projectile(){
        
    }
    
    public abstract void checkCollision();
    public abstract void checkEdge();
}
