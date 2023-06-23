import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Random;

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
        objects.add(new RoadObject(this, objects));
        objects.add(new RoadObject(this, objects));
        objects.add(new RoadObject(this, objects));
        objects.add(new RoadObject(this, objects));
        for(RoadObject o : objects) {
            addObject(o, new Random().nextInt(900), new Random().nextInt(500));
        }
        globalSpeed = 1;
        
        ArrayList<GreenfootImage> temp = new ArrayList<GreenfootImage>();
        for(int i = 0; i < 3; i++){
            temp.add(new GreenfootImage("car" + i + ".png"));
            temp.add(new GreenfootImage("car" + i + "Left.png"));
            temp.add(new GreenfootImage("car" + i + "Right.png"));
        }
        GifImage carGif = new GifImage(temp);
        Player p1 = new Player(this, carGif, 100);
        addObject(p1, 400, 400);
    }
    
    /**
     * Called once per frame.
     */
    public void act(){
        
    }
}
