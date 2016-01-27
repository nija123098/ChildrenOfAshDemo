package um.nija123098.game.elements.locationed;

import um.nija123098.game.Config;
import um.nija123098.game.elements.floor.Floor;
import um.nija123098.game.elements.level.Level;
import um.nija123098.resorce.Vec;

import java.util.ArrayList;
import java.util.Random;

/**
 * Made by Dev on 12/19/2015
 */
public class Location implements Cloneable/*DegreeComparable<Location>*/{
    public float direction = new Random().nextFloat() % 360;
    public Vec vec = new Vec(0f, 0f);
    public Level level;
    public float x, y;
    public Location(Level level, float x, float y){
        this.level = level;
        this.x = x;
        this.y = y;
    }
    public boolean pickupDistanceAcceptable(Location location){
        return this.level.equals(location.level) && Math.pow(Math.pow(this.x + location.x, 2) + Math.pow(this.y + location.y, 2), .5) <= Config.gOIADT();
    }
    public DungeonObject[] objectsAt(){
        return this.level.objectsAt(this);
    }
    public void move(Vec vec){
        this.x += vec.x;
        this.y += vec.y;
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
        float d = (int) this.vec.angle();
        if (d == 0){
            d = this.direction;
        }
        return d;
    }
    public ArrayList<DungeonObject> getNearObjects(Location location, float distance, boolean floors){
        return this.level.getNearObjects(location ,distance, floors);
    }
    /*@Override
    public boolean isEqual(Location location) {
        return this.x == location.x && this.y == location.y && this.level.isEqual(location.level);
    }*/
}
