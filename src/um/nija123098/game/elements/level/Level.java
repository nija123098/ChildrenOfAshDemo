package um.nija123098.game.elements.level;

import um.nija123098.game.elements.NamedObject;
import um.nija123098.game.elements.floor.Floor;
import um.nija123098.game.elements.floor.floors.StoneFloor;
import um.nija123098.game.elements.floor.walls.StoneWall;
import um.nija123098.game.elements.item.equipable.equipables.PoofArmor;
import um.nija123098.game.elements.living.TestPoof;
import um.nija123098.game.elements.locationed.DungeonObject;
import um.nija123098.game.elements.locationed.Location;
import um.nija123098.resorce.Vec;
import um.nija123098.test.TestComponent;

import java.util.ArrayList;

/**
 * Made by Dev on 12/19/2015
 */
public class Level extends NamedObject /*implements Tickable, DegreeComparable<Level>*/{
    public ArrayList<DungeonObject> objects;
    public Floor[][] floor;
    public Level(String name,Floor[][] floor, ArrayList<DungeonObject> objects){
        super(name);
        this.floor = floor;
        this.objects = objects;
    }
    @TestComponent
    public Level(){
        this("Some non uniquely named level", new Floor[10][10], new ArrayList<DungeonObject>(2));
        for (int x = 0; x < this.floor.length; x++){
            for (int y = 0; y < this.floor[0].length; y++){
                if (x == 0 || y == 0 || x == this.floor.length-1 || y == this.floor[0].length-1){
                    this.floor[x][y] = new StoneWall(new Location(this, x, y));
                }else{
                    this.floor[x][y] = new StoneFloor(new Location(this, x, y));
                }
            }
        }
        this.objects.add(new TestPoof(new Location(this, 5, 5)));
        PoofArmor poofArmor = new PoofArmor(new Location(this, 5, 5));
        poofArmor.throwObject(new Vec(1f, 1f));
        this.objects.add(poofArmor);
    }
    public ArrayList<DungeonObject> objectsAt(Location location){
        ArrayList<DungeonObject> objectsAt = new ArrayList<DungeonObject>(2);
        for (DungeonObject dungeonObject : this.objects){
            if (dungeonObject.location.withinDistance(location, dungeonObject.size)){
                objectsAt.add(dungeonObject);
            }
        }
        return objectsAt;
    }
    public Floor getFloor(Location location){
        return this.floor[((int) location.x)][((int) location.y)];
    }
    public Location getSpawn(){
        return new Location(this, this.floor.length/2, this.floor.length/2);// temp
    }
    /*
     * may want to either merge loose objects
     * and livings or add an option to disclude
     * livings in this search
     */
    public ArrayList<DungeonObject> getNearObjects(Location location, float distance, boolean floors) {
        ArrayList<DungeonObject> dungeonObjects = new ArrayList<>();
        if (floors){
            for (Floor[] yFloor : this.floor){
                for (Floor floor : yFloor) {
                    if (floor.getDistance(location) <= distance){
                        dungeonObjects.add(floor);
                    }
                }
            }
        }
        for (DungeonObject dungeonObject : this.objects) {
            if (dungeonObject.getDistance(location) <= distance){
                dungeonObjects.add(dungeonObject);
            }
        }
        for (DungeonObject dungeonObject : this.objects) {
            if (dungeonObject.getDistance(location) <= distance){
                dungeonObjects.add(dungeonObject);
            }
        }
        return dungeonObjects;
    }
    /*@Override
    public boolean isEqual(Level level) {
        return false;
    }*/
}
