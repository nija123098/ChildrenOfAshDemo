package um.nija123098.game.elements.locationed;

import basicjavautillibrary.um.nija123098.math.geometry.Point;
import basicjavautillibrary.um.nija123098.math.geometry.Vec;
import um.nija123098.game.elements.NamedObject;
import um.nija123098.game.elements.Setting;
import um.nija123098.game.elements.actionmethod.ActionMethod;
import um.nija123098.game.elements.damage.DamageSystem;
import um.nija123098.game.elements.effect.EffectHandler;
import um.nija123098.game.elements.item.Item;
import um.nija123098.game.elements.structure.Structure;

import java.util.ArrayList;

/**
 * Made by Dev on 12/19/2015
 */
public abstract class DungeonObject extends NamedObject/*, DegreeComparable<DungeonObject>*/{
    public float slideFactor = .9f;// todo get slide factor based on objects around it, could return 0f instead of bool to indicate stop, would require this variable still though
    public Point focused = new Point(0d, 0d);
    public Location location;
    public Structure structure;
    public EffectHandler effectHandler;
    public DamageSystem damageSystem;
    public DungeonObject(String name, Location location, Structure structure){
        super(name);
        this.location = location;
        this.structure = structure;
        this.structure.object = this;
        this.effectHandler = new EffectHandler(this);
    }
    public boolean objectContact(DungeonObject origin){
        Location l = origin.location.clone();// todo fix, pending library update
        Point point = new Point(l.location.getX(), l.location.getY());
        Vec v = new Vec(l.vec.getX(), l.vec.getY());
        v.setMag(PRECISION);
        point.translate(v);
        if (l.getFloor()==null){
            return false;
        }
        ArrayList<DungeonObject> affected = l.objectsAt();
        affected.add(l.getFloor());
        boolean result = true;
        for (DungeonObject dungeonObject : affected){
            if (!dungeonObject.objectContacted(origin, affected)){
                result = false;
            }
        }
        return result;
    }
    public boolean objectContacted(DungeonObject origin, ArrayList<DungeonObject> affected){
        return origin instanceof Item;
    }
    public void methodContact(ActionMethod actionMethod){// when this attacks that
        actionMethod.activate();
    }
    public void methodContacted(ActionMethod actionMethod){
    }// for immunity to certain AMs
    @Setting
    public static final float PRECISION = .5f;
    /**
     * This is where all collision takes place.
     * There is no other location where
     * processing collision is acceptable.
     */
    public void commonTick(){// todo apply this.objectContact(), likely requires rewrite of that method
        ArrayList<DungeonObject> dungeonObjects = this.location.getNearObjects(this.structure.getSize(), false);
        boolean stopped = false;
        for (double i = this.location.vec.getMag(); i < -PRECISION+.0001f; i = i-PRECISION) {
            for (DungeonObject dungeonObject : dungeonObjects){
                if (!dungeonObject.objectContacted(this, dungeonObjects)){
                    stopped = true;
                }
            }
            Vec v = new Vec(this.location.location.getX(), this.location.location.getY());
            v.setMag(PRECISION);
            this.location.move(v);
            if (!stopped){
                break;
            }
        }
        this.location.vec.setMag(this.slideFactor);
    }
    public float getDistance(Location location) {
        return (float) Math.pow(Math.pow(location.location.getX() - this.location.location.getX(), 2) + Math.pow(location.location.getY() - this.location.location.getY(), 2) ,.5);
    }
    public void throwObject(Vec vec){
        this.location.level.objects.add(this);
        this.location = this.location.clone();
        this.location.vec = new Vec(vec.getX() + this.location.vec.getX(), vec.getY() + this.location.vec.getY());
    }
    public ArrayList<ActionMethod> getActionMethods(boolean selected){// may want interface for this
        return null;// todo
    }
    public boolean colides(DungeonObject dungeonObject){
        return this.structure.shape.union(dungeonObject.structure.shape).hasContent();
    }
    public DungeonObject getFocused(double precision, double limit){
        return new Location(this.location.level, this.focused).getNearest(precision, limit);
    }
}
