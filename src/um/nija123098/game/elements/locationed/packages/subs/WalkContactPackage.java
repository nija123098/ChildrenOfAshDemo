package um.nija123098.game.elements.locationed.packages.subs;

import um.nija123098.game.elements.living.Living;
import um.nija123098.game.elements.locationed.DungeonObject;
import um.nija123098.game.elements.locationed.Location;
import um.nija123098.game.elements.locationed.packages.Package;
import um.nija123098.resorce.Vec;

import java.util.ArrayList;

/**
 * Created by Student on 1/19/2016.
 */
public class WalkContactPackage extends Package{
    public Vec vec;
    public WalkContactPackage(Location originLocation, Vec vec, Living origin, ArrayList<DungeonObject> affected) {
        super(originLocation, origin, affected);
        this.vec = vec;
    }
    public Location getTargetLocation(){
        Location location = this.originLocation.clone();
        location.move(this.vec);
        return location;
    }
}
