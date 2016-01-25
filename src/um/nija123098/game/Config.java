package um.nija123098.game;

import um.nija123098.game.elements.Setting;

/**
 * Made by Dev on 12/29/2015
 */
@Setting// obviously everything in here is a setting
public class Config {// temp, hopefully
    private static final float OBJECT_INTERACTION_ACCEPTABLE_DISTANCE_TOLERANCE = 1f;
    public static float getObjectInteractionAcceptableDistanceTolerance(){
        return OBJECT_INTERACTION_ACCEPTABLE_DISTANCE_TOLERANCE;
    }
    public static float gOIADT(){
        return getObjectInteractionAcceptableDistanceTolerance();
    }
}
