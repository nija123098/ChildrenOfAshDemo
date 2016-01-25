package um.nija123098.game.elements.level;

import um.nija123098.game.elements.Tickable;
import um.nija123098.game.elements.floor.Floor;
import um.nija123098.game.elements.floor.floors.StoneFloor;
import um.nija123098.game.elements.floor.walls.StoneWall;
import um.nija123098.game.elements.item.equipable.equipables.PoofArmor;
import um.nija123098.game.elements.living.Living;
import um.nija123098.game.elements.living.TestPoof;
import um.nija123098.game.elements.locationed.DungeonObject;
import um.nija123098.game.elements.locationed.Location;
import um.nija123098.game.elements.projectile.Projectile;
import um.nija123098.resorce.Vec;
import um.nija123098.test.TestComponent;

import java.util.ArrayList;

/**
 * Made by Dev on 12/19/2015
 */
public class Level implements Tickable/*,DegreeComparable<Level>*/{
    public ArrayList<DungeonObject> looseObjects;
    public ArrayList<Living> livings;
    public Floor[][] floor;
    public Level(Floor[][] floor, ArrayList<DungeonObject> looseObjects, ArrayList<Living> livings){
        this.floor = floor;
        this.looseObjects = looseObjects;
        this.livings = livings;
    }
    @TestComponent
    public Level(){
        this(new Floor[10][10], new ArrayList<DungeonObject>(1), new ArrayList<Living>(1));
        for (int x = 0; x < this.floor.length; x++){
            for (int y = 0; y < this.floor[0].length; y++){
                if (x == 0 || y == 0 || x == this.floor.length-1 || y == this.floor[0].length-1){
                    this.floor[x][y] = new StoneWall(new Location(this, x, y));
                }else{
                    this.floor[x][y] = new StoneFloor(new Location(this, x, y));
                }
            }
        }
        this.livings.add(new TestPoof(new Location(this, 5, 5)));
        this.looseObjects.add(new Projectile(new PoofArmor(null), new Vec(1f, 1f), 1f));
    }
    @Override
    public void tick() {
        for (DungeonObject dungeonObject : this.looseObjects){
            if (dungeonObject instanceof Tickable){
                ((Tickable) dungeonObject).tick();
            }
        }
        for (Living living : this.livings){
            living.tick();
        }
        for (Floor[] floorX : this.floor){
            for (Floor floor : floorX){
                if (floor instanceof Tickable){
                    ((Tickable) floor).tick();
                }
            }
        }
    }
    public DungeonObject[] objectsAt(Location location){
        return this.objectsAt(location.x, location.y);
    }
    public DungeonObject[] objectsAt(float x, float y){
        ArrayList<DungeonObject> objectsAt = new ArrayList<DungeonObject>(2);
        for (DungeonObject dungeonObject : this.looseObjects){
            if (dungeonObject.location.pickupDistanceAcceptable(new Location(this, x, y))){
                objectsAt.add(dungeonObject);
            }
        }
        return objectsAt.toArray(new DungeonObject[objectsAt.size()]);
    }
    public Floor getFloor(Location location){
        return this.floor[((int) location.x)][((int) location.y)];
    }
    public Location getSpawn(){
        return new Location(this, this.floor.length/2, this.floor.length/2);// temp
    }
    /*@Override
    public boolean isEqual(Level level) {
        return false;
    }*/
}
