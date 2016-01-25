package um.nija123098.game.elements.item;

import um.nija123098.game.elements.living.Living;
import um.nija123098.game.elements.locationed.DungeonObject;
import um.nija123098.game.elements.locationed.Location;
import um.nija123098.game.elements.projectile.Projectile;
import um.nija123098.resorce.Vec;

/**
 * Made by Dev on 12/22/2015
 */
public abstract class Item extends DungeonObject /*implements Collection<Item> -- seems to be unnecessary*/ {
    public Living owner;
    public Item(String name, Location location) {
        super(name, location);
    }
    public void drop(Location location){
        this.location = location;
    }
    public void throwObject(Vec vec){
        this.location.level.looseObjects.add(new Projectile(this, vec, 9/10));
    }
    public void setOwner(Living owner){
        this.owner = owner;
    }
}
