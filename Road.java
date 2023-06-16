import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Road here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Road extends AbstRoad
{
    RoadTest game;
    
    public Road (int s, int w, int h){
        super(s, w, h);
    }
    
    
    
    public void setSpeed(int s){
        speed = s;
    }
}
