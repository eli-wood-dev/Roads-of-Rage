import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Abstract car class that can be used for both the Player and Enemy vehicles.
 * 
 * @author      Zachary Sousa
 * @version     1.00
 */
public class Car extends RoadObject
{
    private double localSpeed;      //the rate that the car can move locally on the screen
    private double durability;      //scalar for other stats, decreases when damage taken, higher is better
    
    /**
     * Calls the super constructor for the RoadObject.
     */
    public Car(AncestorGame game, ArrayList<Actor> list) {
        super(game, list);
    }
    
    /**
     * Act - do whatever the AbstCar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        super.act();
    }
    
    /**
     * returns the durability value of the vehicle. Scale from 0.0 - 1.0.
     */
    public double getDurability() {
        return durability;
    }
}
