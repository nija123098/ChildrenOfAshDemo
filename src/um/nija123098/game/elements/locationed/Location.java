package um.nija123098.game.elements.locationed;

import basicjavautillibrary.um.nija123098.math.geometry.Point;
import basicjavautillibrary.um.nija123098.math.geometry.Vec;
import um.nija123098.game.elements.floor.Floor;
import um.nija123098.game.elements.level.Level;

import java.util.ArrayList;
import java.util.Random;

/**
 * Made by Dev on 12/19/2015
 */
public class Location implements Cloneable/*DegreeComparable<Location>*/{
    public float direction = new Random().nextFloat() % 360;
    public Vec vec = new Vec(0f, 0f);
    public Level level;
    public Point location;
    public Location(Level level, double x, double y){
        this.level = level;
        this.location = new Point(x, y);
    }
    public Location(Level level, Point point){
        this(level, point.getX(), point.getY());
    }
    public boolean withinDistance(Location location, double distance){
        return this.getDistance(location) < distance;
    }
    public float getDistance(Location location){
        return (float) Math.pow(Math.pow(location.location.getX() - this.location.getY(), 2) + Math.pow(location.location.getX() - this.location.getY(), 2), .5);
    }
    public ArrayList<DungeonObject> objectsAt(){
        return this.level.objectsAt(this);
    }
    public void move(Vec vec){
        this.location.translate(vec);
    }
    public void move(){
        this.move(this.vec);
    }
    public Floor getFloor(){
        return this.level.getFloor(this);
    }
    public Location clone(){
        try {
            return (Location) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
    public float getDirection(){
        float d = (int) this.vec.getAngle().getValue();
        if (d == 0){
            d = this.direction;
        }
        return d;
    }
    public ArrayList<DungeonObject> getNearObjects(double distance, boolean floors){
        return this.level.getNearObjects(this, distance, floors);
    }
    public DungeonObject getNearest(double precision, double limit, boolean floors){
        double l = limit;
        for (double i = 0; i < (l += (limit < 0 ? precision : 0)); i += precision) {
            ArrayList<DungeonObject> dos = this.getNearObjects(i, floors);
            if (dos.size() > 1){
                return dos.get(1);
            }
        }
        return null;
    }
    public DungeonObject getNearest(double precision, double limit){
        return this.getNearest(precision, limit, false);
    }
    /*@Override
    public boolean isEqual(Location location) {
        return this.x == location.x && this.y == location.y && this.level.isEqual(location.level);
    }*/
}
