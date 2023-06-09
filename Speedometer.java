import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays the 'speed' of the Car. Also displays how many nitro boosts the player holds.
 * 
 * @author      Zachary Sousa
 * @version     1.00
 */
public class Speedometer extends SmoothMover
{
    private double speed;
    private int numNitros;
    private boolean isBoosting = false; //not implemented yet
    private SpeedometerStick stick;
    private final int LOW_LIMIT = 111;
    private final int HI_LIMIT = 297;
    
    private final int imgScaler = 3;    //used to multiply the original scale of the image by this number
    
    private GreenfootImage[] frames = new GreenfootImage[4];
    
    private AncestorGame game;
    
    /**
     * Constructor for Speedometer
     * 
     * @author  Zachary Sousa
     * @version 1.00
     */
    public Speedometer() {
        setLocation(400, 400);
        for(int i = 0; i < frames.length; i++) {
            frames[i] = new GreenfootImage("speedometer" + i + ".png");
            frames[i].scale(frames[i].getWidth() * imgScaler, frames[i].getHeight() * imgScaler);
        }
        setImage(frames[0]);
        numNitros = 3;
        speed = 0;
    }
    
    /**
     * Called by the car to update the values of the Speedometer to match.
     * 
     * @param speed         the new speed of travel
     * @param numNitros     the new remaining amount of nitros
     * @param isBoosting    whether the player is actively burning a nitro charge
     * 
     * @author  Zachary Sousa
     * @version 1.00
     */
    public void updateValues(double speed, int numNitros, boolean isBoosting) {
        this.speed      = speed;
        this.numNitros  = numNitros;
        this.isBoosting = isBoosting;
    }
    
    /**
     * Called once per frame.
     */
    public void act() {
        if(game == null) {
            game = (AncestorGame)getWorld();
            stick = new SpeedometerStick(imgScaler, LOW_LIMIT, HI_LIMIT);
            game.addObject(stick, getX(), getY());
        }
        try {
            setImage(frames[numNitros]);
        } catch(IndexOutOfBoundsException e) {
            System.err.println(e);
        }
        stick.updateSpeed(speed);
        System.out.println(speed);
    }
}
