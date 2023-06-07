import greenfoot.*;
import java.util.ArrayList;

/**
 * Use this interface for any actor that can die.
 * 
 * @author      Zachary Sousa
 * @version     1.00
 */
public interface Despawnable  
{
    /**
     * Fill this in with code to remove the object from the game, and do any extra things
     * before dying. (huge_explosion.mp4!!!!)
     * 
     * @author  Zachary Sousa
     * @version 1.00
     */
    public void despawn(Actor a, ArrayList<Actor> list);
}
