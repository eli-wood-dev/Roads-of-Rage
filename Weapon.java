import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * abstract weapon class
 * 
 * @author Eli Wood 
 * @version 1
 */
public abstract class Weapon extends SmoothMover{
    private Vector pos;
    Vector target;
    private GreenfootImage image;
    private int degRot = 0;
    
    public Weapon(Vector target, GreenfootImage image){
        this.target = target;
        this.image = image;
    }
    
    public void act(){
        rotateTowards(target);
        shoot();
    }
    
    /**
     * put weapon code here
     */
    abstract void shoot();
    
    private void rotateTowards(Vector target){
        Vector dir = Vector.sub(target, pos);
        
        double degTarget = Math.toDegrees(dir.heading()) + 90;
        
        if(degTarget >= 360){
            degTarget -= 360;
        }
        
        image.rotate((int)degTarget - degRot);
        degRot += (int)degTarget;
    }
}
