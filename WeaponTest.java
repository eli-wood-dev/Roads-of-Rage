import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * test world for weapons
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WeaponTest extends AncestorGame{
    Weapon testGun;
    ArrayList<RoadObject> car;
    
    /**
     * Constructor for objects of class SpeedometerTest.
     * 
     */
    public WeaponTest(){
        super(600, 600);
        
        car = new ArrayList<RoadObject>();
        
        car.add(new Car(this, car, 100));
        addObject(car.get(0), 500, 200);
        
        //testGun = new RocketLauncher(mousePos, new GreenfootImage("barrel.png"), null, 30, 5, 5);
        testGun = new MachineGun(mousePos, new GreenfootImage("barrel.png"), 20, null, 10, 5, 5);
        //testGun = new Shotgun(mousePos, new GreenfootImage("barrel.png"), 40, null, 30, 8, 5, 5);
        
        addObject(testGun, 300, 300);
    }
    
    public void act(){
        super.act();
        
        if(mouse != null /*&& mouse.getButton() == 1*/){
            testGun.shoot();
        }
    }
}
