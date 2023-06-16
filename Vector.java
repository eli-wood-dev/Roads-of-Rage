/**
 * Class for a 2d Vector
 *
 * @author Eli
 * @version 1
 */
public class Vector{
    private double x;
    private double y;

    /**
     * Constructor
     * 
     * @author Eli Wood
     */
    public Vector(){
        x = 0;
        y = 0;
    }
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Vector(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * gets the x
     * 
     * @author Eli Wood
     * @return the x position
     */
    public double getX() {
        return x;
    }

    /**
     * sets the x
     * 
     * @author Eli Wood
     * @param x the new x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * gets the y
     * 
     * @author Eli Wood
     * @return the y position
     */
    public double getY() {
        return y;
    }

    /**
     * sets the y
     * 
     * @author Eli Wood
     * @param y the new y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * sets the coordinates of the Vector
     * 
     * @author Eli Wood
     * @param x the new x
     * @param y the new y
     */
    public void set(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * sets the coordinates of the Vector
     * 
     * @author Eli Wood
     * @param v the Vector to copy coordinates from
     */
    public void set(Vector v){
        x = v.getX();
        y = v.getY();
    }

    /**
     * copies a Vector into a new Vector
     * 
     * @author Eli Wood
     * @return the copied Vector
     */
    public Vector copy(){
        return new Vector(x, y);
    }

    /**
     * gets the magnitude of the Vector
     * 
     * @return the magnitude of the Vector
     */
    public double getMag(){
        return Math.sqrt(x*x + y*y);
    }

    /**
     * adds to the values of the Vector
     * 
     * @author Eli Wood
     * @param x the x to add
     * @param y the y to add
     */
    public void add(double x, double y){
        this.x += x;
        this.y += y;
    }

    /**
     * adds a Vector
     * 
     * @author Eli Wood
     * @param v the vector to add
     */
    public void add(Vector v){
        add(v.getX(), v.getY());
    }

    /**
     * adds two vectors together
     * 
     * @author Eli Wood
     * @param v1 one of the Vectors to add
     * @param v2 the other Vector to add
     * 
     * @return the a Vector of the sum of the two Vectors
     */
    public static Vector add(Vector v1, Vector v2){
        Vector v = v1.copy();
        v.add(v2);
        return v;
    }

    /**
     * subtracts from the values of the Vector
     * 
     * @author Eli Wood
     * @param x the x to subtract
     * @param y the y to subtract
     */
    public void sub(double x, double y){
        this.x -= x;
        this.y -= y;
    }

    /**
     * subtracts a Vector
     * 
     * @author Eli Wood
     * @param v the vector to subtract
     */
    public void sub(Vector v){
        sub(v.getX(), v.getY());
    }

    /**
     * subtracts a Vector from another
     * 
     * @author Eli Wood
     * @param v1 the Vector to subtract from
     * @param v2 the Vector to subtract
     * 
     * @return the a Vector of the difference of the two Vectors
     */
    public static Vector sub(Vector v1, Vector v2){
        Vector v = v1.copy();
        v.sub(v2);
        return v;
    }

    /**
     * multiplies by a number to change the magnitude
     * 
     * @author Eli Wood
     * @param d the amount to multiply the Vector's magnitude by
     */
    public void mult(double d){
        x *= d;
        y *= d;
    }

    /**
     * multiplies by a number to change the magnitude
     * 
     * @author Eli Wood
     * @param d the amount to multiply the Vector's magnitude by
     * @param v the Vector to multiply
     * @return a copy of v multiplied by d
     */
    public static Vector mult(double d, Vector v){
        Vector temp = v.copy();
        v.mult(d);
        return v;
    }

    /**
     * divides by a number to change the magnitude
     * 
     * @author Eli Wood
     * @param d the amount to divide the Vector's magnitude by
     */
    public void div(double d){
        x /= d;
        y /= d;
    }

    /**
     * divides by a number to change the magnitude
     * 
     * @author Eli Wood
     * @param d the amount to divide the Vector's magnitude by
     * @param v the Vector to divide
     * @return a copy of v divided by d
     */
    public static Vector div(double d, Vector v){
        Vector temp = v.copy();
        v.div(d);
        return v;
    }

    /**
     * calculates the distance from another Vector
     * 
     * @author Eli Wood
     * @param v the Vector to measure against
     * @return the distance between the two Vectors
     */
    public double dist(Vector v){
        return Math.sqrt(Math.pow(v.getX() - x, 2) + Math.pow(v.getY() - y, 2));
    }

    /**
     * calculates the distance from one Vector to another Vector
     * 
     * @author Eli Wood
     * @param v1 the Vector to measure from
     * @param v2 the Vector to measure against
     * @return the distance between the two Vectors
     */
    public static double dist(Vector v1, Vector v2){
        return v1.dist(v2);
    }

    /**
     * gets the dot product of two Vectors
     * 
     * @author Eli Wood
     * @param v the Vector to get the dot product with
     * @return the dot product of the two Vectors
     */
    public double dot(Vector v){
        return x * v.getX() + y * v.getY();
    }

    /**
     * gets the dot product of two Vectors
     * 
     * @author Eli Wood
     * @param v1 one of the Vectors to get the dot product with
     * @param v2 the other Vector to get the dot product with
     * @return the dot product of the two Vectors
     */
    public static double dot(Vector v1, Vector v2){
        return v1.dot(v2);
    }
    
    /**
     * normalizes the Vector by setting its magnitude to 1
     * 
     * @author Eli Wood
     */
    public void normalize(){
        div(getMag());
    }
    
    /**
     * sets the magnitude while keeping the direction
     * 
     * @author Eli Wood
     * @param mag the magnitude to set
     */
    public void setMag(double mag){
        normalize();
        x*= mag;
        y*= mag;
    }
    
    /**
     * limits the magnitude to a certain number
     * 
     * @author Eli Wood
     * @param mag the max magnitude
     */
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
     * @return the rotation in radians
     */
    public double heading(){
        return Math.atan2(y, x);
    }
    
    /**
     * gets the angle between two vector
     * 
     * @author Eli Wood
     * @param v1 the first Vector
     * @param v2 the second Vector
     * @return the angle between the two Vectors
     */
    public static double angleBetween(Vector v1, Vector v2){
         // We get NaN if we pass in a zero vector which can cause problems
        // Zero seems like a reasonable angle between a (0,0,0) vector and something else
        if (v1.x == 0 && v1.y == 0) return 0.0;
        if (v2.x == 0 && v2.y == 0) return 0.0;
    
        double dot = v1.x * v2.x + v1.y * v2.y;
        double v1mag = Math.sqrt(v1.x * v1.x + v1.y * v1.y);
        double v2mag = Math.sqrt(v2.x * v2.x + v2.y * v2.y);
        // This should be a number between -1 and 1, since it's "normalized"
        double amt = dot / (v1mag * v2mag);
        // But if it's not due to rounding error, then we need to fix it
        // http://code.google.com/p/processing/issues/detail?id=340
        // Otherwise if outside the range, acos() will return NaN
        // http://www.cppreference.com/wiki/c/math/acos
        if (amt <= -1) {
          return Math.PI;
        } else if (amt >= 1) {
          // http://code.google.com/p/processing/issues/detail?id=435
          return 0;
        }
        return Math.acos(amt);
        
        /*
        double amt = v1.dot(v2)/(v1.getMag() * v2.getMag());
        
        return Math.acos(amt);
        */
        //return v2.heading() - v1.heading();
    }
    
    /**
     * lerps the Vector to the new coordinates
     * 
     * @author Eli Wood
     * @param x the x to lerp to
     * @param y the y to lerp to
     * @param amount the rate to lerp by
     */
    public void lerp(double x, double y, double amount){
        this.x = x * (1-amount) + (x*amount);
        this.y = y * (1-amount) + (y*amount);
    }
    
    /**
     * lerps the Vector to a different Vector
     * 
     * @author Eli Wood
     * @param v the Vector to lerp to
     * @param amount the rate to lerp by
     */
    public void lerp(Vector v, double amount){
        lerp(v.getX(), v.getY(), amount);
    }
    
    /**
     * lerps the Vector to a different Vector
     * 
     * @author Eli Wood
     * @param v1 the Vector to lerp
     * @param v2 the Vector to lerp to
     * @param amount the rate to lerp by
     * @return the lerped Vector
     */
    public static Vector lerp(Vector v1, Vector v2, double amount){
        Vector v = v1.copy();
        v.lerp(v2, amount);
        return v;
    }
    
    /**
     * rotates the vecor around the origin counter-clockwise
     * 
     * @author Eli Wood
     * @param theta angle in radians
     */
    public void rotate(double theta){
        y = x * Math.sin(theta) + y * Math.cos(theta);
        x = x * Math.cos(theta) - y * Math.sin(theta);
    }
    
    public void setRotation(double theta){
        rotate(theta - heading());
    }
    
    public boolean equals(Vector v){
        if(v.getX() == x && v.getY() == y){
            return true;
        }
        
        return false;
    }
}
