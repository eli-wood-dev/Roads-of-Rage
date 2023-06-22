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
    GifImage flameGif;
    GreenfootImage rocket;
    boolean alive = true;
    GifImage carGif;
    
    /**
     * Constructor for objects of class SpeedometerTest.
     * 
     */
    public WeaponTest(){
        super(1500, 645);
        
        
        ArrayList<GreenfootImage> temp = new ArrayList<GreenfootImage>();
        for(int i = 0; i < 3; i++){
            temp.add(new GreenfootImage("car" + i + ".png"));
            temp.get(temp.size()-1).scale(temp.get(temp.size()-1).getWidth() * 2, temp.get(temp.size()-1).getHeight() * 2);
            temp.add(new GreenfootImage("car" + i + "Left.png"));
            temp.get(temp.size()-1).scale(temp.get(temp.size()-1).getWidth() * 2, temp.get(temp.size()-1).getHeight() * 2);
            temp.add(new GreenfootImage("car" + i + "Right.png"));
            temp.get(temp.size()-1).scale(temp.get(temp.size()-1).getWidth() * 2, temp.get(temp.size()-1).getHeight() * 2);
        }
        
        carGif = new GifImage(temp);
        
        
        globalSpeed = 5;
        
        setPaintOrder(new Class[]{Explosion.class, Weapon.class, Projectile.class, RoadObject.class, Road.class});
        setActOrder(new Class[]{RoadObject.class, Weapon.class, Projectile.class});
        
        car = new ArrayList<Car>();
        enemy = new ArrayList<Car>();
        
        machineGif = new GifImage("machineTurret.gif");
        shotGif = new GifImage("shotGunTurret.gif");
        rocket = new GreenfootImage("rocketLauncher.png");
        flameGif = new GifImage("flameTurret.gif");
        
        
        for(GreenfootImage g : machineGif.getImages()){
            g.scale(96*2, 96*2);
            g.rotate(90);
        }
        
        for(GreenfootImage g : shotGif.getImages()){
            g.scale(96*2, 96*2);
            g.rotate(90);
        }
        
        for(GreenfootImage g : flameGif.getImages()){
            g.scale(96*2, 96*2);
            g.rotate(90);
        }
        
        car.add(new Car(this, car, new GifImage(carGif), 1000));
        addObject(car.get(0), 300, 300);
        car.get(0).setVel(new Vector(0, -globalSpeed));
        car.get(0).setLocalSpeed(5);
        
        rocket.scale(96*2, 96*2);
        rocket.rotate(90);
        
        //testGun = new RocketLauncher(mousePos, rocket, car.get(0), 30, 10, 7);
        //testGun = new MachineGun(mousePos, new GifImage(machineGif), 20, car.get(0), 10, 5, 5);
        //testGun = new Shotgun(mousePos, new GifImage(shotGif), 40, car.get(0), 30, 8, 5, 5);
        testGun = new FlameThrower(mousePos, new GifImage(flameGif), 30, car.get(0), 2, 2, 4, 1);
        
        addObject(testGun, 300, 300);
        
        Road a = new Road(5, 1280*2, 880);//incredibly stupid code
        Road b = new Road(5, 1280*2, 880);
        addObject(a, 600, 0);
        addObject(b, 600, 1280);
        
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
            for(int i = 0; i < 3; i++){
                enemy.add(new Car(this, enemy, new GifImage(carGif), 15));
                addObject(enemy.get(enemy.size()-1), 600 + i * 100, 0);
                
                
                Weapon g;
                Vector target = new Vector();
                if(car.size() > 0){
                    target = car.get(0).getPos();
                } 
                
                //g = new MachineGun(target, new GifImage(machineGif), 30, enemy.get(enemy.size()-1), 10, 1, 5);
                //g = new RocketLauncher(target, rocket, enemy.get(enemy.size()-1), 30, 1, 5);
                g = new Shotgun(target, new GifImage(shotGif), 40, enemy.get(enemy.size()-1), 30, 8, 1, 5);
                //g = new FlameThrower(target, new GifImage(flameGif), 30, enemy.get(enemy.size()-1), 2, 1, 4, 1);
                
                addObject(g, 600 + i * 100, 0);
            }
            
        }
        
        //System.out.println(enemy.size());
        
        for(Car c : enemy){
            if(car.size() > 0){
               c.shoot(); 
            }
        }
        
        //player movement
        
        try{
            Car player = car.get(0);
            Vector playerVel = new Vector();//make sure the car stays in place
            double localSpeed = player.getLocalSpeed();
            
            if(Greenfoot.isKeyDown("w") && player.getPos().getY() - localSpeed > 0){
                playerVel.setY(playerVel.getY() - 1); //subtract 1
            }
            if(Greenfoot.isKeyDown("s") && player.getPos().getY() + localSpeed < getHeight()){
                playerVel.setY(playerVel.getY() + 1); //add 1
            }
            if(Greenfoot.isKeyDown("a") && player.getPos().getX() - localSpeed > 0){
                playerVel.setX(playerVel.getX() - 1); //subtract 1
            }
            if(Greenfoot.isKeyDown("d") && player.getPos().getX() + localSpeed < getWidth()){
                playerVel.setX(playerVel.getX() + 1); //add 1
            }
            
            if(playerVel.getMag() != 0){
                playerVel.setMag(localSpeed);
            }
            playerVel.setY(playerVel.getY() - globalSpeed);
            
            player.setVel(playerVel);
        } catch(Exception e){
            
        }
        
    }
}
