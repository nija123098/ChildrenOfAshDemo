package um.nija123098.game.elements.actionmethod.actionmethods;

import um.nija123098.game.elements.actionmethod.ActionMethod;
import um.nija123098.game.elements.locationed.DungeonObject;

import java.util.ArrayList;

/**
 * Made by Dev on 1/28/2016
 */
public class Stomp extends ActionMethod{
    public Stomp(DungeonObject origin) {
        super("Stomp", origin);
    }
    @Override
    public void activate() {
        ArrayList<DungeonObject> dungeonObjects = this.origin.getLocation().objectsAt();
        dungeonObjects.add(this.origin.getLocation().getFloor());
        dungeonObjects.addAll(this.origin.getLocation().objectsAt());
        for (DungeonObject dungeonObject : dungeonObjects){
            this.effect(dungeonObject);
        }
    }
    @Override
    public void effect(DungeonObject dungeonObject) {
    }
}
