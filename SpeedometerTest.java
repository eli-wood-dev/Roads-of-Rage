import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Temporary World for testing the speedometer.
 * 
 * @author      Zachary Sousa
 * @version     1.00
 */
public class SpeedometerTest extends AncestorGame{
    Speedometer spdMtr;
    double speed = 0;
    int numNitro = 0;
    
    /**
     * Constructor for objects of class WeaponTest.
     * 
     */
    public SpeedometerTest(){
        super(1500, 645);   //almost ultrawide, about 21:9
         spdMtr = new Speedometer();
        addObject(spdMtr, 400, 400);
    }
    
    /**
     * Called once per frame.
     */
    public void act(){
        showText("0-3 to test boost indcator. UP and DOWN to adjust speed,\nW and S for big increments.", 300, 100);
        String key = Greenfoot.getKey();
        
        if(key == null) {
            key = "";
        }
        
        if(key.equals("up")) {
            speed += 1;
        }
        if(key.equals("down")) {
            speed -= 1;
        }
        if(key.equals("w")) {
            speed += 4;
        }
        if(key.equals("s")) {
            speed -= 4;
        }
        if(key.equals("0")) {
            numNitro = 0;
        }
        if(key.equals("1")) {
            numNitro = 1;
        }
        if(key.equals("2")) {
            numNitro = 2;
        }
        if(key.equals("3")) {
            numNitro = 3;
        }
        
        spdMtr.updateValues(speed, numNitro, false);
        System.out.println(speed);
    }
}
