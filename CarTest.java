import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Temporary World for testing the car.
 * 
 * @author      Zachary Sousa
 * @version     1.00
 */
public class CarTest extends AncestorGame{
    private ArrayList<RoadObject> objects = new ArrayList<RoadObject>();
    
    
    /**
     * Constructor for objects of class CarTest.
     * 
     */
    public CarTest(){
        super(1500, 645);   //almost ultrawide, about 21:9
        
        objects.add(new RoadObject(this, objects));
        addObject(objects.get(0), 400, 400);
        globalSpeed = 1;
    }
    
    /**
     * Called once per frame.
     */
    public void act(){
        
    }
}
