/**
 * Constants for global variables.
 */
public class Constants  
{
    /*Speed related*/
    public static final int MAX_SPEED = 10;
    public static final int MIN_SPEED = 0;
    public static final int BOOST_SPEED = 20; //make sure that this can override any limits set with the MAX_SPEED
    
    
    public static final int MISSILE_LIFESPAN = 120;
    public static final double MISSILE_TURN_RATE = 0.05;
    public static final double MISSILE_TURN_AMOUNT = 0.05;//radians moved in 1 frame
    public static final double MISSILE_ALLOWANCE = 0.1;
    
    public static final int FLAME_LIFESPAN = 60;
    public static final int MAX_FLAME_LIFE = 60;
    /*=============*/
}
