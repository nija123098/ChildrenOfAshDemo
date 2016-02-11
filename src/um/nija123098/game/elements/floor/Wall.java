package um.nija123098.game.elements.floor;

import um.nija123098.game.elements.locationed.Location;

/**
 * Made by Dev on 1/18/2016
 */
public abstract class Wall extends Floor{
    public Wall(String name, Location location) {
        super(name + " Wall", location);
    }
}
