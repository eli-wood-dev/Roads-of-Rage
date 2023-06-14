import greenfoot.*;

public class Explosion extends Actor
{
    World world;
    SimpleTimer timer;
    GreenfootSound sound;
    int duration = 1000;
    int size;
    //int imageCtr;
    GifImage image;
    
    public Explosion(){
    }
    
    
    public Explosion (Actor a){
        //        setLocation(a.getX(), a.getY());
        image = new GifImage("explosion.gif");
        setImage(image.getCurrentImage());
        size = (int)(a.getImage().getWidth()*0.9);
        getImage().scale(size, size);
        sound = new GreenfootSound("explode.wav");
        /*
        if (size > 60){
            //home explosion
            sound = new GreenfootSound("explosion_large.mp3");
        }
        else if (size > 40){
            sound = new GreenfootSound("explosion_medium.mp3");
        }
        else if (size > 10){
            sound = new GreenfootSound("explosion_small.mp3");
        }
        else {
            sound = new GreenfootSound("little_pop.mp3");
        }
        */
        int volume = 30+size/2;
        if (volume>90){
            volume = 90;
        }
        sound.setVolume(volume);
        sound.play();
        
        world = a.getWorld();
        timer = new SimpleTimer();
        //imageCtr = 0;
    }
    
    
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
       
    public void act() 
    {
         setImage(image.getCurrentImage());
         getImage().scale(size, size);
        if (timer.millisElapsed()>duration){
            world.removeObject(this);
        }        
    }    
}