package um.nija123098.game;

/**
 * Made by Dev on 12/29/2015
 */
public class Config {// temp, hopefully
    private static final float OBJECT_INTERACTION_ACCEPTABLE_DISTANCE_TOLERANCE = 1f;
    public static float getObjectInteractionAcceptableDistanceTolerance(){
        return OBJECT_INTERACTION_ACCEPTABLE_DISTANCE_TOLERANCE;
    }
    public static float gOIADT(){
        return getObjectInteractionAcceptableDistanceTolerance();
    }
}
