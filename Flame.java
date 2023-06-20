import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Random;

/**
 * Write a description of class Flame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flame extends Bullet{
    private int frame = 0;
    protected GifImage roadGif;
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @param img the image to use
     * @param vel the velocity of the projectile
     */
    public Flame(Vector vel, int damage, GifImage img, ArrayList<Projectile> list, Car ignores){
        super(vel, damage, img, list, ignores);
        roadGif = new GifImage("fire.gif");
    }
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @param img the image to use
     * @param vel the velocity of the projectile
     */
    public Flame(Vector vel, int damage, GifImage img, ArrayList<Projectile> list, Car ignores, GifImage roadGif){
        super(vel, damage, img, list, ignores);
        this.roadGif = roadGif;
    }
    
    public void checkEdge(){
        super.checkEdge();
        
        try{
            frame++;
            if(frame > Constants.FLAME_LIFESPAN){
                despawn();
            }
        } catch(Exception e){
            //should only trigger if already removed
        }
    }
    
    public void despawn(){
        //spawn ground flame
        if(Math.floor(Math.random() * 5) == 0){
            game.addObject(new RoadFlame(game, roadGif), (int)pos.getX(), (int)pos.getY());
        }
        
        
        super.despawn();
    }
}
