package um.nija123098.game.elements;

import java.util.ArrayList;

/**
 * Made by Dev on 1/23/2016
 */
public class TrackedObject {
    public TrackedObject(){
        trackedObjects.add(this);
    }
    private static ArrayList<TrackedObject> trackedObjects = new ArrayList<TrackedObject>(50);
    public static void tickAll(){
        for (TrackedObject trackedObject : trackedObjects){
            if (trackedObject instanceof Tickable){
                ((Tickable) trackedObject).tick();
            }
        }
    }
}