package um.nija123098.game.elements.floor.floors;

import um.nija123098.game.elements.floor.Floor;
import um.nija123098.game.elements.locationed.Location;
import um.nija123098.game.elements.locationed.packages.subs.StompPackage;

/**
 * Made by Dev on 12/29/2015
 */
public class StoneFloor extends Floor{
    public StoneFloor(Location location) {
        super("StoneFloor", location);
    }
    @Override
    public void stompedOn(StompPackage stompPackage) {
    }
}
