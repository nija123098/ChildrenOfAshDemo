package um.nija123098.game.elements.projectile;

import um.nija123098.game.elements.Tickable;
import um.nija123098.game.elements.locationed.DungeonObject;
import um.nija123098.game.elements.locationed.packages.subs.StompPackage;
import um.nija123098.game.elements.locationed.packages.subs.ThrowObjectPackage;
import um.nija123098.game.elements.locationed.packages.subs.WalkContactPackage;
import um.nija123098.resorce.Vec;

/**
 * Made by Dev on 12/23/2015
 */
public class Projectile extends DungeonObject implements Tickable/*, DegreeComparable<Projectile>*/{
    public DungeonObject dungeonObject;
    public Vec vec;
    public float tickFactor;
    public Projectile(DungeonObject dungeonObject, Vec vec, float tickFactor){
        super(dungeonObject.name + " Projectile" , dungeonObject.location);
        this.dungeonObject = dungeonObject;
        this.vec = vec;
        this.tickFactor = tickFactor;
    }
    @Override
    public void tick(){// todo see if it is necessary to tick dungeonObject
        this.dungeonObject.location.x += vec.x;
        this.dungeonObject.location.y += vec.y;
        this.vec = this.vec.along(this.vec.mag() * this.tickFactor);
    }
    @Override
    public void stompedOn(StompPackage stompPackage) {
    }
    @Override
    public void thrownContact(ThrowObjectPackage throwObjectPackage) {
        this.vec.add(throwObjectPackage.projectile.vec);
    }
    @Override
    public boolean walkedContact(WalkContactPackage walkContactPackage) {
        return this.dungeonObject.walkedContact(walkContactPackage);
    }
    /*@Override
    public boolean isEqual(Projectile projectile){
        return this.dungeonObject.isEqual(projectile) && this.vec.isEqual(projectile.vec) && this.tickFactor == projectile.tickFactor;
    }*/
}
