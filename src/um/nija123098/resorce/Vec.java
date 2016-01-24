package um.nija123098.resorce;

/**
 * Made by Dev on 12/19/2015
 */
public class Vec implements Cloneable/*DegreeComparable<Vec>*/{
    public float x, y;
    public Vec(float x, float y){
        this.x = x;
        this.y = y;
    }
    public Vec(float mag, double angle){
        this.x = (float) (mag * Math.cos(Math.toRadians(angle)));
        this.y = (float) (mag * Math.sin(Math.toRadians(angle)));
    }
    public Vec(float xMag, float yAng, boolean xy){
        if (xy){
            this.x = xMag;
            this.y = yAng;
            return;
        }
        this.x = (float) (xMag * Math.cos(Math.toRadians(yAng)));
        this.y = (float) (xMag * Math.sin(Math.toRadians(yAng)));
    }
    public float mag(){
        return (float) Math.pow(Math.pow(this.x, 2) + Math.pow(this.y, 2), .5);
    }
    public float angle(){
        return (float) Math.toDegrees(Math.atan(this.y / this.x));
    }
    public void add(Vec vec){
        this.x += vec.x;
        this.y += vec.y;
    }
    public Vec clone(){
        try {
            return (Vec) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
    public Vec along(float length){
        return new Vec(length, (double) this.mag());
    }
    /*@Override
    public boolean isEqual(Vec vec) {
        return this.x == vec.x && this.y == vec.y;
    }*/
}
