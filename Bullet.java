import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Bullet here.
 * 
 * @author Eli Wood
 * @version 1
 */
public class Bullet extends Projectile{
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @param img the image to use
     * @param vel the velocity of the projectile
     */
    public Bullet(Vector vel, double damage, GreenfootImage img, ArrayList<Actor> list, Car ignores){
        super(vel, damage, img, list, ignores);
    }
    
    public void checkEdge(){
        if(pos.getX() < 0 || pos.getX() > game.getWidth() || pos.getY() < 0 || pos.getY() > game.getHeight()){
            despawn(this, list);
        }
    }
    
    public void interact(Car c){
        if(c != ignores){
            //damage the car
        }
    }
    
    
}
