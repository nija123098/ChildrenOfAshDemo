package um.nija123098.game.elements.actionmethod;

import um.nija123098.game.elements.NamedObject;
import um.nija123098.game.elements.locationed.DungeonObject;

/**
 * Made by Dev on 1/21/2016
 */
public abstract class ActionMethod extends NamedObject{// may want to use package data again, could get complicated
    public DungeonObject origin;
    public ActionMethod(String name, DungeonObject origin) {
        super(name);
        this.origin = origin;
    }
    public boolean isUsable(){
        return true;
    }
    public abstract void activate();
    //public abstract ArrayList<DungeonObject> getAffected(DungeonObject origin);
    public abstract void effect(DungeonObject dungeonObject);
}
