import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Car class that can be used for both the Player and Enemy vehicles.
 * 
 * @author      Zachary Sousa
 * @version     1.00
 */
public class Car extends RoadObject
{
    protected double localSpeed = 1;      //the rate that the car can move locally on the screen
    protected double durability = 1;  //percentage scalar for other stats, based on the hp of the vehicle
    protected int hp;                 //current health of the Car
    protected int maxHp;              //the maximum health of the Car
    protected GifImage gif;           //used to store the states of the car. should be stored in the order of straight, left, right, increasingly damaged
    //^shouldn't play
    protected int maxDamageState = 0;
    protected int direction = 0;      //0 for straight, 1 for left, 2 for right
    
    /**
     * Calls the super constructor for the RoadObject.
     */
    public Car(AncestorGame game, ArrayList<Car> list, int maxHp) {
        super(game, list);
        this.maxHp = maxHp;
        this.hp = maxHp;
    }
    
    /**
     * Calls the super constructor for the RoadObject.
     */
    public Car(AncestorGame game, ArrayList<Car> list, GreenfootImage image, int maxHp) {
        super(game, list, image);
        this.maxHp = maxHp;
        this.hp = maxHp;
    }
    
    /**
     * Calls the super constructor for the RoadObject.
     */
    public Car(AncestorGame game, ArrayList<Car> list, GifImage gif, int maxHp) {
        super(game, list, gif.getImages().get(0));//sets the image to the first image
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.gif = gif;
        gif.pause();
        maxDamageState = gif.getImages().size()/3;
    }
    
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        super.act();
        if(getWorld() != null){
            durability = (double)(hp)/maxHp;
            /*System.out.println("DURABILITY: " + durability + " HP: " + hp);*/
            
            if(gif != null){
                setImage(gif.getImages().get(Utilities.clamp((int)Math.round(Utilities.map(hp, 0, maxHp, maxDamageState-1, 0)), 0, maxDamageState-1) * maxDamageState + direction));
            }
            
            if(durability <= 0){
                game.addObject(new Explosion(this, true), getX(), getY());
                despawn();
            }
        }
        
    }
    
    public void setVel(Vector v){
        super.setVel(v);
        direction = 0;
        //check if the car is turning left or right
        if(vel.getX() > 0){
            direction = 2;
        } else if(vel.getX() < 0){
            direction = 1;
        }
        
    }
    
    /**
     * returns the durability value of the vehicle. Scale from 0.0 - 1.0.
     * @return durability
     */
    public double getDurability() {
        return durability;
    }
    
    /**
     * returns the HP of the vehicle
     */
    public double getHp() {
        return hp;
    }
    
    /**
     * decrements the hp of the Car
     * @param damage        the amount of damage for the Car to receive
     */
    public void hurt(int damage){
        hp -= damage;
    }
    
    public void setLocalSpeed(double speed){
        this.localSpeed = speed;
    }
    
    public double getLocalSpeed(){
        return localSpeed;
    }
}
