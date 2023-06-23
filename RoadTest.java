import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Test World for the Road
 * 
 * @author Treyton Smith
 * @version 1.1
 */
public class RoadTest extends AncestorGame
{
    protected int speed = 20;
    private int numRoads = 2;
    Road[] road = new Road[numRoads];
    
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public RoadTest()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 705);
        setPaintOrder(new Class[]{Weapon.class, Projectile.class, Car.class});
        reset();
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
    
    
    
    public void act()
    {
      List<Road> allRoads = getObjects(Road.class);
       
      for(int i=0; i < numRoads; i++){
            road[i].setSpeed(globalSpeed);
      }
    }
    
    
    public void reset()
    {//resets the game
        
        for(int i=0; i < numRoads; i++){
            road[i] = new Road(speed, getHeight() + 250, 550);
            road[i].setRotation(90);
            road[i].setSpeed(globalSpeed);
            addObject(road[i], getWidth()/2, getHeight() - (i * getHeight()) );
        }
       
    }
}
