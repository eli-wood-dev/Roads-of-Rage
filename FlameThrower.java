import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class FlameThrower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlameThrower extends Weapon{
    protected GifImage bulletGif;
    protected GifImage groundFire;
    protected double maxDeviation;
    protected double turnAmount;
    protected boolean shooting;
    protected double turnOffset = 0;
    
    /**
     * Constructor
     * 
     * @param target what to shoot at
     * @param image the image for the gun
     */
    public FlameThrower(Vector target, GifImage gif, double maxDeviation, Car owner, int attackSpeed, int damage, double bulletSpeed, double turnAmount){
        super(target, gif, owner, attackSpeed, damage, bulletSpeed);
        this.gif.resume();
        this.maxDeviation = maxDeviation;
        this.turnAmount = turnAmount;
        bulletGif = new GifImage("fireBall.gif");
        groundFire = new GifImage("fire.gif");
        groundFire.pause();
        for(GreenfootImage g : groundFire.getImages()){
            g.scale(25, 25);
        }
        bulletGif.pause();
        damage = 5;
    }
    
    public void act(){
        super.act();
        if(shooting){
            shooting = false;
            if((turnOffset + turnAmount > maxDeviation/2 && turnAmount > 0) || (turnOffset + turnAmount < -maxDeviation/2 && turnAmount < 0)){
                turnAmount *= -1;
            }
            turnOffset += turnAmount;
        }
        turn((int)turnOffset);
    }
    
    public void shoot(){
        if(game != null && game.getFrameCount() - lastAttack > attackSpeed){
            shooting = true;
            lastAttack = game.getFrameCount();
            
            Vector vel = Vector.sub(target, pos);
            vel.setRotation(Math.toRadians(getRotation()));
            Vector posOffset = vel.copy();
            
            //vel.rotate(Math.toRadians((r.nextDouble() * maxShotDeviance) - maxShotDeviance/2));//rotate in a fixed pattern
            
            
            
            vel.setMag(bulletSpeed);
            
            posOffset.setMag(getImage().getHeight()/2);
            posOffset.add(pos);
            
            bullets.add(new Flame(vel, damage, new GifImage(bulletGif), bullets, owner, new GifImage(groundFire)));
            game.addObject(bullets.get(bullets.size()-1), (int)posOffset.getX(), (int)posOffset.getY());
        }
    }
}
