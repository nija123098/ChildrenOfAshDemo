package um.nija123098.game;

import um.nija123098.game.elements.Setting;
import um.nija123098.game.elements.living.Living;
import um.nija123098.game.elements.locationed.DungeonObject;

/**
 * Made by Dev on 1/31/2016
 */
public class Interface{
    public static DungeonObject getClosest(boolean floorsCount){
        return null;
    }
    public static DungeonObject getInventorySelected(){
        return null;
    }
    public static boolean isInterfacingWorld(){
        return true;
    }
    @Setting
    public static final float RANGE = 1f;
    public static DungeonObject getSelected(boolean floorsCount){
        DungeonObject d = getClosest(floorsCount);
        if (d.getDistance(getPlayer().location) <= RANGE){
            return isInterfacingWorld() ? getClosest(floorsCount) : getInventorySelected();
        }
        return null;
    }
    public static DungeonObject getSelected(){
        return getSelected(false);
    }
    public static Living getPlayer(){
        return null;
    }
}
