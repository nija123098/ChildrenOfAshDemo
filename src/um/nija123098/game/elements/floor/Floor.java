package um.nija123098.game.elements.floor;

import um.nija123098.game.elements.locationed.DungeonObject;
import um.nija123098.game.elements.locationed.Location;

/**
 * Made by Dev on 12/19/2015
 */
public abstract class Floor extends DungeonObject{
    public Location location;
    public Floor(String name, Location location){
        super(name + " Floor", location);
        this.location = location;
    }
}
