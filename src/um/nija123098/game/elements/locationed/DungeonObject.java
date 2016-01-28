package um.nija123098.game.elements.locationed;

import um.nija123098.game.elements.NamedObject;
import um.nija123098.game.elements.Tickable;
import um.nija123098.game.elements.actionmethod.ActionMethodActivationPackage;
import um.nija123098.game.elements.locationed.packages.subs.ActionMethodContactPackage;
import um.nija123098.game.elements.locationed.packages.subs.ItemContactPackage;
import um.nija123098.game.elements.locationed.packages.subs.StompPackage;
import um.nija123098.resorce.Vec;

import java.util.ArrayList;

/**
 * Made by Dev on 12/19/2015
 */
public abstract class DungeonObject extends NamedObject implements Tickable/*DegreeComparable<DungeonObject>*/{
    public float slideFactor = .9f;// todo get slide factor based on objects around it, could return 0f instead of bool to indicate stop, would require this variable still though
    public float size = 1;// diameter? radius? possibly to shape?
    public Location location;
    public DungeonObject(String name, Location location){
        super(name);
        this.location = location;
    }
    public void stompedOn(StompPackage stompPackage){// um
    }
    public boolean itemContacted(ItemContactPackage itemContactPackage){// when this is walked into
        return true;
    }
    public void methodContacted(ActionMethodContactPackage actionMethodContactPackage){// when this is attacked by that
        actionMethodContactPackage.actionMethod.effect(new ActionMethodActivationPackage(actionMethodContactPackage));
    }
    //@Setting
    public static final float PRECISION = .5f;
    /**
     * This is where all collision takes place.
     * There is no other location where
     * processing collision is acceptable.
     */
    @Override
    public void tick(){
        ArrayList<DungeonObject> dungeonObjects = this.location.getNearObjects(this.location, this.size, false);
        boolean stoped = false;
        for (float i = this.location.vec.mag(); i < -PRECISION+.0001f; i = i-PRECISION) {
            for (DungeonObject dungeonObject : dungeonObjects){
                if (!dungeonObject.itemContacted(new ItemContactPackage(this.location, this, this.location.getNearObjects(new Location(this.location.level, (this.location.x + dungeonObject.location.x)/2, (this.location.y + dungeonObject.location.y)/2), this.size, false)))){
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
