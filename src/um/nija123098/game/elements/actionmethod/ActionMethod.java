package um.nija123098.game.elements.actionmethod;

import um.nija123098.game.elements.NamedObject;
import um.nija123098.game.elements.locationed.DungeonObject;

import java.util.ArrayList;

/**
 * Made by Dev on 1/21/2016
 */
public abstract class ActionMethod extends NamedObject{
    public ActionMethod(String name) {
        super(name);
    }
    public boolean isUsable(){
        return true;
    }
    public void activate(DungeonObject originSource){
        this.activate(originSource, originSource);
    }
    public void activate(DungeonObject origin, DungeonObject source){
        ArrayList<DungeonObject> affected = this.getAffected(origin, source);
        for (DungeonObject dungeonObject : affected){
            this.effect(dungeonObject, origin, source, affected);
        }
    }
    public abstract ArrayList<DungeonObject> getAffected(DungeonObject origin, DungeonObject source);
    public abstract void effect(DungeonObject effect, DungeonObject origin, DungeonObject source, ArrayList<DungeonObject> affected);
}
