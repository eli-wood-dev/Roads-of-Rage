import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * test world for weapons
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WeaponTest extends AncestorGame{
    MachineGun testGun;
    
    
    /**
     * Constructor for objects of class WeaponTest.
     * 
     */
    public WeaponTest(){
        super(600, 600);
        testGun = new MachineGun(mousePos, new GreenfootImage("barrel.png"), 10, null);
        addObject(testGun, 300, 300);
    }
    
    public void act(){
        updateMouse();
        
        if(mouse != null/* && mouse.getButton() == 1*/){
            testGun.shoot();
        }
    }
}
