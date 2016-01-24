package um.nija123098.game.elements.locationed.packages.subs;

import um.nija123098.game.elements.living.Living;
import um.nija123098.game.elements.locationed.DungeonObject;
import um.nija123098.game.elements.locationed.Location;
import um.nija123098.game.elements.locationed.packages.Package;
import um.nija123098.game.elements.projectile.Projectile;

import java.util.ArrayList;

/**
 * Created by Student on 1/19/2016.
 */
public class ThrowObjectPackage extends Package{
    public Projectile projectile;
    public ThrowObjectPackage(Location originLocation, Projectile projectile, Living origin, ArrayList<DungeonObject> affected) {
        super(originLocation, origin, affected);
        this.projectile = projectile;
    }
}
