package um.nija123098.game.elements.item;

import um.nija123098.game.elements.living.Living;
import um.nija123098.game.elements.locationed.DungeonObject;
import um.nija123098.game.elements.locationed.Location;

/**
 * Made by Dev on 12/22/2015
 */
public abstract class Item extends DungeonObject /*implements Collection<Item> -- seems to be unnecessary*/ {
    public Living owner;// if null item is on the ground
    public Item(String name, Location location) {
        super(name, location);
    }
    public void drop(Location location){
        this.location = location;
    }
    public void setOwner(Living owner){
        this.owner = owner;
    }
}
