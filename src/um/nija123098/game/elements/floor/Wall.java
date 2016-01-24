package um.nija123098.game.elements.floor;

import um.nija123098.game.elements.locationed.Location;
import um.nija123098.game.elements.locationed.packages.subs.StompPackage;
import um.nija123098.game.elements.locationed.packages.subs.WalkContactPackage;

/**
 * Made by Dev on 1/18/2016
 */
public abstract class Wall extends Floor{
    public Wall(String name, Location location) {
        super(name + " Wall", location);
    }
    @Override
    public void stompedOn(StompPackage stompPackage) {
    }
    @Override
    public boolean walkedContact(WalkContactPackage walkContactPackage) {
        return false;
    }
}
