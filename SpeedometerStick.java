import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The funny little stick indicator on the Speedometer. Rotates in a range that somewhat represents the speed of 
 * travel. When in the red zone of the Speedometer, the player is actively boosting.
 * 
 * @author  Zachary Sousa
 * @version 1.00
 */
public class SpeedometerStick extends SmoothMover
{
    private int LOW_LIMIT;
    private int HI_LIMIT;
    private double speed;
    private final double TURN_RATE = 0.25;
    
    /**
     * Constructor for SpeedometerStick
     * @param imgScaler     the amount to multiply the image size by
     * @param LOW_LIMIT     the lowest degree the SpeedometerStick can rotate to
     * @param HI_LIMIT      the highest degree the SpeedometerStick can rotate to
     * 
     * @author  Zachary Sousa
     * @version 1.00
     */
    public SpeedometerStick(int imgScaler, int LOW_LIMIT, int HI_LIMIT) {
        GreenfootImage img = new GreenfootImage("speedometerStick.png");
        img.scale(img.getWidth() * imgScaler, img.getHeight() * imgScaler);
        setImage(img);
        this.LOW_LIMIT = LOW_LIMIT;
        this.HI_LIMIT = HI_LIMIT;
        this.setRotation(LOW_LIMIT);
    }
    
    /**
     * Sent from the Speedometer.
     * 
     * @param speed         the new speed of travel
     * 
     * @author  Zachary Sousa
     * @version 1.00
     */
    public void updateSpeed(double speed) {
        this.speed      = speed;
    }
    
    /**
     * Called once per frame.
     */
    public void act()
    {
        doRotation();
    }
    
    /**
     * The destination rotation (rot) is ca lculated by mapping the current speed within the degrees of freedom
     * of the speedometer (LOW_LIMIT, HI_LIMIT). It is then clamped between those values as well, because it
     * is technically possible that the speed would exceed the limit, and the stick should never spin outside
     * the range. The current rotation is then interpolated between the current rotation and new rotation
     * by a fraction (TURN_RATE). The only time these behaviors would be ignored is when the player is boosting,
     * in which case the stick would turn directly to the red area for the duration.
     * 
     * @author  Zachary Sousa
     * @version 1.00
     */
    private void doRotation() {
        int rot = (int)Utilities.map(speed, Constants.MIN_SPEED, Constants.MAX_SPEED, LOW_LIMIT, HI_LIMIT);
        rot = Utilities.clamp(rot, (int)LOW_LIMIT, (int)HI_LIMIT);  
        setRotation((int)Utilities.lerp(getRotation(), rot, TURN_RATE));
        System.out.println((int)Utilities.lerp(getRotation(), rot, TURN_RATE));
    }
}
