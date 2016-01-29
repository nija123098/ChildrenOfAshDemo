package um.nija123098.game.elements.actionmethod.actionmethods;

import um.nija123098.game.elements.actionmethod.ActionMethod;
import um.nija123098.game.elements.locationed.DungeonObject;

import java.util.ArrayList;

/**
 * Made by Dev on 1/28/2016
 */
public class Stomp extends ActionMethod{
    public Stomp() {
        super("Stomp");
    }
    @Override
    public ArrayList<DungeonObject> getAffected(DungeonObject origin, DungeonObject source) {
        ArrayList<DungeonObject> dungeonObjects = origin.location.objectsAt();
        dungeonObjects.add(origin.location.getFloor());
        dungeonObjects.addAll(origin.location.objectsAt());
        return dungeonObjects;
    }
    @Override
    public void effect(DungeonObject effect, DungeonObject origin, DungeonObject source, ArrayList<DungeonObject> affected) {
        // todo
    }
}
