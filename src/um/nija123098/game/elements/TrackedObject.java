package um.nija123098.game.elements;

import um.nija123098.game.elements.locationed.DungeonObject;

import java.util.ArrayList;

/**
 * Made by Dev on 1/23/2016
 */
public class TrackedObject {
    public TrackedObject(){
        trackedObjects.add(this);
    }
    private static ArrayList<TrackedObject> trackedObjects = new ArrayList<TrackedObject>(50);
    public static void tickAll(){//may not tick in a desired pattern
        trackedObjects.stream().filter(trackedObject -> trackedObject instanceof Tickable).forEach(trackedObject -> ((Tickable) trackedObject).tick());
    }
    public static void commonTickAll(){
        trackedObjects.stream().filter(trackedObject -> trackedObject instanceof DungeonObject).forEach(trackedObject -> ((DungeonObject) trackedObject).commonTick());
    }
}
