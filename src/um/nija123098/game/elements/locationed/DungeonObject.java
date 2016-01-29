package um.nija123098.game.elements.locationed;

import um.nija123098.game.elements.NamedObject;
import um.nija123098.game.elements.Tickable;
import um.nija123098.game.elements.actionmethod.ActionMethod;
import um.nija123098.resorce.Vec;

import java.util.ArrayList;

/**
 * Made by Dev on 12/19/2015
 */
public abstract class DungeonObject extends NamedObject implements Tickable/*DegreeComparable<DungeonObject>*/{// todo re apply override methods to various objects
    public float slideFactor = .9f;// todo get slide factor based on objects around it, could return 0f instead of bool to indicate stop, would require this variable still though
    public float size = 1;// diameter? radius? possibly to shape?
    public Location location;
    public DungeonObject(String name, Location location){
        super(name);
        this.location = location;
    }
    public boolean objectContact(DungeonObject origin){// when this walks into that, that package requires info on if objectContacted return
        Location l = origin.location.clone();
        l.vec.add(l.vec.along(PRECISION));
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
    public boolean objectContacted(DungeonObject origin, ArrayList<DungeonObject> affected){// when this is walked into
        return true;
    }
    public void methodContact(DungeonObject origin, DungeonObject sorce, ActionMethod actionMethod){// when this attacks that
        actionMethod.activate(origin, sorce);
    }
    /* temporarily disabled due to possible rewrite, for immunity to certain AMs
    public void methodContacted(DungeonObject origin, DungeonObject source, ArrayList<DungeonObject> affected, ActionMethod actionMethod){// when this is attacked by that
        actionMethod.effect(origin, affected);
    }*/
    //@Setting
    public static final float PRECISION = .5f;
    /**
     * This is where all collision takes place.
     * There is no other location where
     * processing collision is acceptable.
     */
    @Override
    public void tick(){// todo apply this.objectContact(), likely requires rewrite of that method
        ArrayList<DungeonObject> dungeonObjects = this.location.getNearObjects(this.location, this.size, false);
        boolean stoped = false;
        for (float i = this.location.vec.mag(); i < -PRECISION+.0001f; i = i-PRECISION) {
            for (DungeonObject dungeonObject : dungeonObjects){
                if (!dungeonObject.objectContacted(this, dungeonObjects)){
                    stoped = true;
                }
            }
            this.location.move(this.location.vec.along(PRECISION));
            if (!stoped){
                break;
            }
        }
        this.location.vec.change(this.slideFactor);
    }
    public float getDistance(Location location) {
        return (float) Math.pow(Math.pow(location.x - this.location.x, 2) + Math.pow(location.y - this.location.y, 2) ,.5);
    }
    public void throwObject(Vec vec){
        this.location.level.objects.add(this);
        this.location = this.location.clone();
        this.location.vec.add(vec);
    }
}
