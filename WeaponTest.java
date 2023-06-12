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
    boolean shooting = false;
    GifImage machineGif;
    GifImage shotGif;
    GreenfootImage rocket;
    
    /**
     * Constructor for objects of class SpeedometerTest.
     * 
     */
    public WeaponTest(){
        super(600, 600);
        
        setPaintOrder(new Class[]{Weapon.class, Projectile.class});
        
        car = new ArrayList<RoadObject>();
        
        car.add(new Car(this, car, 100));
        addObject(car.get(0), 500, 200);
        
        machineGif = new GifImage("machineTurret.gif");
        shotGif = new GifImage("shotGunTurret.gif");
        rocket = new GreenfootImage("rocketLauncher.png");
        
        
        for(GreenfootImage g : machineGif.getImages()){
            g.scale(96, 96);
            g.rotate(90);
        }
        
        for(GreenfootImage g : shotGif.getImages()){
            g.scale(96, 96);
            g.rotate(90);
        }
        
        rocket.scale(96, 96);
        rocket.rotate(90);
        
        testGun = new RocketLauncher(mousePos, rocket, null, 30, 5, 5);
        //testGun = new MachineGun(mousePos, machineGif, 20, null, 10, 5, 5);
        //testGun = new Shotgun(mousePos, shotGif, 40, null, 30, 8, 5, 5);
        
        addObject(testGun, 300, 300);
    }
    
    public void act(){
        super.act();
        
        if(mouse != null && Greenfoot.mousePressed(this)){
            shooting = true;
        } else if(mouse != null && Greenfoot.mouseClicked(this)){
            shooting = false;
        }
        
        if(shooting){
            testGun.shoot();
        }
    }
}
