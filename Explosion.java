import greenfoot.*;

public class Explosion extends Actor
{
    World world;
    GreenfootSound sound;
    int size;
    GifImage image;
    
    public Explosion(){
    }
    
    
    public Explosion (Actor a){
        image = new GifImage("explosion.gif");
        setImage(image.getCurrentImage());
        size = (int)(a.getImage().getWidth()*3);
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
        int volume = 30+size;
        if (volume>90){
            volume = 90;
        }
        sound.setVolume(volume);
        
        sound.play();
        
        world = a.getWorld();
    }
    
    
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
       
    public void act() 
    {
        setImage(image.getCurrentImage());
        getImage().scale(size, size);
        if(getImage() == image.getImages().get(image.getImages().size()-1)){
            world.removeObject(this);
        }
    }    
}