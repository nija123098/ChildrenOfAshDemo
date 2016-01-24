package um.nija123098.game.elements.locationed.packages.subs;

import um.nija123098.game.elements.living.Living;
import um.nija123098.game.elements.locationed.DungeonObject;
import um.nija123098.game.elements.locationed.Location;
import um.nija123098.game.elements.locationed.packages.Package;

import java.util.ArrayList;

/**
 * Created by Student on 1/19/2016.
 */
public class StompPackage extends Package {
    public StompPackage(Location originLocation, Living origin, ArrayList<DungeonObject> affected) {
        super(originLocation, origin, affected);
    }
}
