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
    ArrayList<Car> car;
    ArrayList<Car> enemy;
    boolean shooting = false;
    GifImage machineGif;
    GifImage shotGif;
    GreenfootImage rocket;
    boolean alive = true;
    
    /**
     * Constructor for objects of class SpeedometerTest.
     * 
     */
    public WeaponTest(){
        super(1500, 645);
        
        globalSpeed = 5;
        
        setPaintOrder(new Class[]{Weapon.class, Projectile.class});
        setActOrder(new Class[]{RoadObject.class, Weapon.class, Projectile.class});
        
        car = new ArrayList<Car>();
        enemy = new ArrayList<Car>();
        
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
        
        //null is passed as the owner as a messy fix
        //the owner is currently being handled by the car
        //testGun = new RocketLauncher(mousePos, rocket, null, 30, 5, 7);
        //testGun = new MachineGun(mousePos, machineGif, 20, null, 10, 5, 5);
        testGun = new Shotgun(mousePos, shotGif, 40, null, 30, 8, 5, 5);
        
        addObject(testGun, 300, 300);
        
        car.add(new Car(this, car, testGun, 1000));
        addObject(car.get(0), 300, 300);
        car.get(0).setVel(new Vector(0, -globalSpeed));
    }
    
    public void act(){
        super.act();
        
        if(mouse != null && Greenfoot.mousePressed(null)){
            shooting = true;
        } else if(mouse != null && Greenfoot.mouseClicked(null)){
            shooting = false;
        }
        
        if(car.size() > 0 && shooting){
            testGun.shoot();
        }
        
        if(frameCount % 30 == 0){
            Weapon g;
            if(car.size() > 0){
                g = new MachineGun(car.get(0).getPos(), new GifImage(machineGif), 20, null, 10, 1, 5);
            } else{
                g = new MachineGun(new Vector(), new GifImage(machineGif), 20, null, 10, 1, 5);
            }
            
            enemy.add(new Car(this, car, g, 1));
            addObject(enemy.get(enemy.size()-1), 600, 0);
            addObject(g, 600, 0);
            /*
            if(car.size() > 0){
                g = new MachineGun(car.get(0).getPos(), new GifImage(machineGif), 20, null, 10, 1, 5);
            } else{
                g = new MachineGun(new Vector(), new GifImage(machineGif), 20, null, 10, 1, 5);
            }
            
            enemy.add(new Car(this, car, g, 1));
            addObject(enemy.get(enemy.size()-1), 800, 0);
            addObject(g, 800, 0);
            */
        }
        
        //System.out.println(enemy.size());
        
        for(int i = 0; i < enemy.size(); i++){//set i to 1 to ignore the first car
            if(enemy.get(i).getPos() != null && enemy.get(i).getPos().getY() > getHeight()){
                enemy.get(i).despawn(enemy.get(i), enemy);//should be handled by the car
                i--;
                continue;
            }
            
            enemy.get(i).shoot();
        }
    }
}
