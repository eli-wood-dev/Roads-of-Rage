import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * test world for weapons
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WeaponTest extends AncestorGame{
    Weapon testGun;
    
    /**
     * Constructor for objects of class SpeedometerTest.
     * 
     */
    public WeaponTest(){
        super(600, 600);
        //testGun = new MachineGun(mousePos, new GreenfootImage("barrel.png"), 20, null, 10, 5);
        //testGun = new Shotgun(mousePos, new GreenfootImage("barrel.png"), 40, null, 30, 8, 5);
        testGun = new RocketLauncher(mousePos, new GreenfootImage("barrel.png"), null, 10, 5, 5);
        
        addObject(testGun, 300, 300);
    }
    
    public void act(){
        super.act();
        
        if(mouse != null /*&& mouse.getButton() == 1*/){
            testGun.shoot();
        }
    }
}
