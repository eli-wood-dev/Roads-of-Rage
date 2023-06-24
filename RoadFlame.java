import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RoadFlame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoadFlame extends RoadObject{
    private GifImage gif;
    private int timer;
    /**
     * Constructor for the RoadObject, initializes the Vector position.
     * 
     * @author  Zachary Sousa
     * @version 1.00
     */
    public RoadFlame(AncestorGame game) {
        this.game = game;
        gif = new GifImage("fire.gif");
        gif.resume();
    }
    
    /**
     * Constructor for the RoadObject, initializes the Vector position.
     * 
     * @author  Zachary Sousa
     * @version 1.00
     */
    public RoadFlame(AncestorGame game, GifImage gif) {
        this.game = game;
        this.gif = gif;
        gif.resume();
    }
    
    public void act(){
        super.act();
        try{
            setImage(gif.getCurrentImage());
            
            if(getIntersectingObjects(Car.class) != null){
                for(Car c: getIntersectingObjects(Car.class)){
                    interact(c);//need to change
                }
            }
            
            /*timer++;
            if(timer > Constants.MAX_FLAME_LIFE){
                despawn();
            }*/
        } catch(Exception e){
            
        }
    }
    
    public void interact(Car c){
        c.hurt(5);//make this a variable?
        despawn();
    }
    
    public void despawn(){
        game.removeObject(this);
    }
}
