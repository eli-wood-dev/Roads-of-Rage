import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Drivable Car.
 * This is some of the worst code I've ever written.
 * 
 * @author      Zachary Sousa
 * @version     1.00
 */
public class Player extends Car
{
    protected double goalGlobalSpeed;
    protected Vector goalLocalVelocity;
    private GreenfootSound bump = new GreenfootSound("bump.wav");
    public Player(AncestorGame game, GifImage gif, int maxHp) {
        super(game, null, gif, maxHp);
        this.moveWithRoad = false;
        this.localSpeed = 5;
        goalGlobalSpeed = 5;
    }
    
    public void act() {
        if(game != null) {
            
            game.setGlobalSpeed(globalSpeed);
            
            super.act();
            goalLocalVelocity = new Vector(0, 0);
            if(Greenfoot.isKeyDown("w") && pos.getY() - localSpeed > 0 && checkAbove() == false){
                goalLocalVelocity.setY(goalLocalVelocity.getY() - 1); //subtract 1
            }
            if(Greenfoot.isKeyDown("s") && pos.getY() + localSpeed < game.getHeight() && checkBelow() == false){
                goalLocalVelocity.setY(goalLocalVelocity.getY() + 1); //add 1
            }
            if(Greenfoot.isKeyDown("a") && pos.getX() - localSpeed > 0 && checkLeft() == false){
                goalLocalVelocity.setX(goalLocalVelocity.getX() - 1); //subtract 1
            }
            if(Greenfoot.isKeyDown("d") && pos.getX() + localSpeed < game.getWidth() && checkRight() == false){
                goalLocalVelocity.setX(goalLocalVelocity.getX() + 1); //add 1
            }
            
            if(pos.getY() < 0) {
                pos.setY(0);
            }
            if(pos.getY() > game.getHeight()) {
                pos.setY(game.getHeight());
            }
            if(pos.getX() < 0) {
                pos.setX(0);
            }
            if(pos.getX() > game.getWidth()) {
                pos.setX(game.getWidth());
            }
            
            if(goalLocalVelocity.getMag() != 0){
                goalLocalVelocity.setMag(localSpeed);
            }
            setVel(new Vector(Utilities.lerp(vel.getX(), goalLocalVelocity.getX(), Constants.LOCAL_ACCEL), Utilities.lerp(vel.getY(), goalLocalVelocity.getY(), Constants.LOCAL_ACCEL)));
            
            
            
            if(getOneIntersectingObject(RoadObject.class) != null) {
                RoadObject obj = (RoadObject)getOneIntersectingObject(RoadObject.class);
                bounce((RoadObject)getOneIntersectingObject(RoadObject.class));
                boolean colAbove = false;
                boolean colBelow = false;
                boolean colLeft = false;
                boolean colRight = false;
                if(checkAbove()) {
                    colAbove = true;
                }
                if(checkBelow()) {
                    colBelow = true;
                }
                if(checkLeft()) {
                    colLeft = true;
                }
                if(checkRight()) {
                    colRight = true;
                }
                if(colAbove) {
                    fixAbove(obj);
                }
                if(colBelow) {
                    fixBelow(obj);
                }
                if(colLeft) {
                    fixLeft(obj);
                }
                if(colRight) {
                    fixRight(obj);
                }
            } else {
                globalSpeed = Utilities.lerp(globalSpeed, goalGlobalSpeed, Constants.ACCELERATION);
            }
        }
    }
    
    public void bounce(RoadObject obj) {
        if(obj.getPos().getY() < this.getPos().getY()) {
            globalSpeed = Math.abs(globalSpeed) + localSpeed * -0.5;
            vel.setY(Math.abs(vel.getY()));
            //globalSpeed = 0;
        } else if(obj.getPos().getY() > this.getPos().getY()) {
            //globalSpeed = Math.abs(globalSpeed) + localSpeed * 0.5;
            //globalSpeed = 0;
        }
    }
    
    public boolean checkAbove() {
        RoadObject obj = (RoadObject)getOneIntersectingObject(RoadObject.class);
        if( obj != null) {
            if(obj.getPos().getY() < this.getPos().getY()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public boolean checkBelow() {
        RoadObject obj = (RoadObject)getOneIntersectingObject(RoadObject.class);
        if( obj != null) {
            if(obj.getPos().getY() > this.getPos().getY()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public boolean checkRight() {
        RoadObject obj = (RoadObject)getOneIntersectingObject(RoadObject.class);
        if( obj != null) {
            if(obj.getPos().getX() > this.getPos().getX()/* && Math.abs(obj.getPos().getY() - this.getPos().getY()) <= this.getWidth()*/) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public boolean checkLeft() {
        RoadObject obj = (RoadObject)getOneIntersectingObject(RoadObject.class);
        if( obj != null) {
            if(obj.getPos().getX() < this.getPos().getX()/* && Math.abs(obj.getPos().getY() - this.getPos().getY()) <= this.getWidth()*/) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public void fixAbove(RoadObject obj) {
        this.pos.setY(pos.getY() + Math.abs(vel.getY()));
        bump.play();
    }
    
    public void fixBelow(RoadObject obj) {
        //this.pos.setY(obj.getPos().getY() - obj.getHeight()/2 - this.getHeight()/2);
        this.pos.setY(pos.getY() - (Math.abs(vel.getY() * -1)));
        if(globalSpeed < 0) {
            //globalSpeed = 0;
        }
    }
    
    public void fixLeft(RoadObject obj) {
        this.pos.setX(pos.getX() + (Math.abs(vel.getX() * 1.5)));
    }
    
    public void fixRight(RoadObject obj) {
        this.pos.setX(pos.getX() + (Math.abs(vel.getX()) * -1.5) );
    }
    
    
    /**
     * setGlobalSpeed
     * @param globalSpeed
     * 
     * @author  Zachary Sousa
     * @version 1.00
     */
    public void setGlobalSpeed(double globalSpeed) {
        this.globalSpeed = globalSpeed;
    }
    
    /**
     * getGoalGlobalSpeed
     * @return goalGlobalSpeed
     * 
     * @author  Zachary Sousa
     * @version 1.00
     */
    public double getGoalGlobalSpeed() {
        return goalGlobalSpeed;
    }
    
    /**
     * setGoalGlobalSpeed
     * @param goalGlobalSpeed
     * 
     * @author  Zachary Sousa
     * @version 1.00
     */
    public void setGoalGlobalSpeed(double goalGlobalSpeed) {
        this.goalGlobalSpeed = goalGlobalSpeed;
    }
}
