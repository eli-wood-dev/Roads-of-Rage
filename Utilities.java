/**
 * Extra! Extra! Come get your useful functions! Basically a bunch of methods that you can call from anywhere.
 */
public class Utilities  
{
    
    /**
     * Lineraly interpolates a value
     * @param a     the current value
     * @param b     the destination value
     * @param f     the rate of interpolation
     * 
     * @author  Zachary Sousa, Eli Wood (Repurposed from 2023 FRC robot code)
     */
    public static double lerp(double a, double b, double f){
        double newSpeed = a * (1.0 - f) + (b * f);
        return newSpeed;
    }
    
    /**
     * remaps a number between two ranges
     *
     * @author EliWood
     * @version 1
     *
     * @param s the number to map
     * @param low1 the low range
     * @param high1 the high range
     * @param low2 the new low range
     * @param high2 the new high range
     * @return s remapped to the new range
     */
    public static double map(double s, double low1, double high1, double low2, double high2){
        return (s-low1)*(high2-low2)/(high1-low1) + low2;
    }
    
    /**
     * clamps a value in a range.
     * 
     * @param value     the value to clamp
     * @param min       the minimum of the range
     * @param max       the maximum of the range
     * 
     * @return          if within range; value, if exceeding range; max, if below range; min
     * 
     * @author  Zachary Sousa
     * @version 1.00
     */
    public static int clamp(int value, int min, int max) {
        if(value > max) {
            return max;
        } else if(value < min) {
            return min;
        } else {
            return value;
        }
    }
}
