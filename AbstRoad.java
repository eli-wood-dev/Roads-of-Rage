import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Has 
 * speed
 * width height
 * world, img
 * 
 * Does
 * move to the side 
 * resets to the other side
 * interacts with the player
 * 
 * @author Treyton Smith
 */
public abstract class AbstRoad extends Actor
{
    protected int speed;
    protected int width;
    protected int height;
    
    protected RoadTest world;
    protected GreenfootImage img;
    
    
    
    public AbstRoad(int speed){
        this.speed = speed;
        
    }
    
    public AbstRoad(int speed, int w, int h){
        this.speed = speed;
        this.width = w;
        this.height = h;
        img = getImage();
        img.scale(width, height);
        
    }
    
    /**
     * Act - do whatever the AbstOther wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (world == null){
            world = (RoadTest)getWorld();
        }
        //move it by speed
        move(speed);
        //if it reaches the edge of the screen
        if(getY()>world.getHeight() + height/2 ){
            //set it to the the side
            setLocation(getX(), 0 - height/2);
        }
          
    }
    
    
}
