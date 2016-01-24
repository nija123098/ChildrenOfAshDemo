package um.nija123098.game.elements.locationed.packages.subs;

import um.nija123098.game.elements.actionmethod.ActionMethod;
import um.nija123098.game.elements.living.Living;
import um.nija123098.game.elements.locationed.DungeonObject;
import um.nija123098.game.elements.locationed.Location;
import um.nija123098.game.elements.locationed.packages.Package;
import um.nija123098.resorce.Vec;

import java.util.ArrayList;

/**
 * Created by Student on 1/19/2016.
 */
public class ActionMethodContactPackage extends Package {
    public ActionMethod actionMethod;
    public Vec attackDirection;
    public ActionMethodContactPackage(Location originLocation, ActionMethod actionMethod, Vec attackDirection, Living origin, ArrayList<DungeonObject> affected) {
        super(originLocation, origin, affected);
        this.actionMethod = actionMethod;
        this.attackDirection = attackDirection;
    }
}
