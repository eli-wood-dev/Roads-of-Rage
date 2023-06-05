/**
 * Class for a 2d Vector
 * I'll make documentation later
 * you can use this for now
 * https://processing.org/reference/PVector.html
 *
 * @author Eli
 * @version 1
 */
public class Vector{
    private double x;
    private double y;

    public Vector(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void set(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void set(Vector v){
        x = v.getX();
        y = v.getY();
    }

    public Vector copy(){
        return new Vector(x, y);
    }

    public double getMag(){
        return Math.sqrt(x*x + y*y);
    }

    public void add(double x, double y){
        this.x += x;
        this.y += y;
    }

    public void add(Vector v){
        add(v.getX(), v.getY());
    }

    public static Vector add(Vector v1, Vector v2){
        Vector v = v1.copy();
        v.add(v2);
        return v;
    }

    public void sub(double x, double y){
        this.x -= x;
        this.y -= y;
    }

    public void sub(Vector v){
        sub(v.getX(), v.getY());
    }

    public static Vector sub(Vector v1, Vector v2){
        Vector v = v1.copy();
        v.sub(v2);
        return v;
    }

    public void mult(double d){
        x *= d;
        y *= d;
    }

    public static Vector mult(double d, Vector v){
        Vector temp = v.copy();
        v.mult(d);
        return v;
    }

    public void div(double d){
        x /= d;
        y /= d;
    }

    public static Vector div(double d, Vector v){
        Vector temp = v.copy();
        v.div(d);
        return v;
    }

    public double dist(Vector v){
        return Math.sqrt(Math.pow(v.getX() - x, 2) + Math.pow(v.getY() - y, 2));
    }

    public static double dist(Vector v1, Vector v2){
        return v1.dist(v2);
    }

    public double dot(Vector v){
        return x * v.getX() + y * v.getY();
    }

    public static double dot(Vector v1, Vector v2){
        return v1.dot(v2);
    }
    
    public void normalize(){
        x /= getMag();
        y /= getMag();
    }
    
    public void setMag(double mag){
        normalize();
        x*= mag;
        y*= mag;
    }
    
    public void limit(double mag){
        if(getMag() > mag){
            setMag(mag);
        }
    }
    
    /**
     * calculates the angle of the vector from the horizontal counter-clockwise
     * 
     * @author Eli Wood
     * 
     * @return the rotation in degrees
     */
    public double heading(){
        return Math.atan(y/x);
    }
    
    public static double angleBetween(Vector v1, Vector v2){
        return v2.heading() - v1.heading();
    }
    
    public void lerp(double x, double y, double amount){
        this.x = x * (1-amount) + (x*amount);
        this.y = y * (1-amount) + (y*amount);
    }
    
    public void lerp(Vector v, double amount){
        lerp(v.getX(), v.getY(), amount);
    }
    
    public static Vector lerp(Vector v1, Vector v2, double amount){
        Vector v = v1.copy();
        v.lerp(v2, amount);
        return v;
    }
    
    public void rotate(double theta){
        y = x * Math.sin(theta) + y * Math.cos(theta);
        x = x * Math.cos(theta) - y * Math.sin(theta);
    }
}
