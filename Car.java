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
    protected double localSpeed;      //the rate that the car can move locally on the screen
    protected double durability = 1;  //percentage scalar for other stats, based on the hp of the vehicle
    protected int hp;                 //current health of the Car
    protected int maxHp;              //the maximum health of the Car
    
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
    public Car(AncestorGame game, ArrayList<Car> list, Weapon w, int maxHp) {
        super(game, list, w);
        this.maxHp = maxHp;
        this.hp = maxHp;
        gun.setOwner(this);//kind of a temporary fix, weapon should probably be created by the car
    }
    
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        super.act();
        durability = (double)(hp)/maxHp;
        /*System.out.println("DURABILITY: " + durability + " HP: " + hp);*/
        if(durability <= 0){
            despawn(this, list);
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
     * @param damage        the amount of damage for the Car to recieve
     */
    public void hurt(int damage){
        hp -= damage;
    }
    
    public void setLocalSpeed(double speed){
        this.localSpeed = speed;
    }
}
