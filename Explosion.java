import greenfoot.*;

public class Explosion extends SmoothMover
{
    GreenfootSound sound;
    int size;
    GifImage image;
    AncestorGame game;
    
    public Explosion(){
    }
    
    
    public Explosion (Actor a){
        this(a, false);
    }
    
    public Explosion(Actor a, boolean large){
        if(large){
            image = new GifImage("bigExplosion.gif");
            sound = new GreenfootSound("bigExplode.wav");
        } else{
            image = new GifImage("explosion.gif");
            sound = new GreenfootSound("explode.wav");
        }
        
        setImage(image.getCurrentImage());
        size = (int)(a.getImage().getWidth()*3);
        getImage().scale(size, size);
        
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
        
        game = (AncestorGame)a.getWorld();
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
            game.removeObject(this);
        }
        
        setLocation(getExactX(), getExactY() + game.getGlobalSpeed());
    }    
}