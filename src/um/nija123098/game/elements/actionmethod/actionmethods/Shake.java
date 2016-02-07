package um.nija123098.game.elements.actionmethod.actionmethods;

import um.nija123098.game.elements.actionmethod.ActionMethod;
import um.nija123098.game.elements.locationed.DungeonObject;
import um.nija123098.game.elements.locationed.Location;

/**
 * Made by Dev on 1/31/2016
 */
public class Shake extends ActionMethod {
    public Shake(DungeonObject origin) {
        super("Shake", origin);
    }
    @Override
    public void activate() {
        DungeonObject s = new Location(this.origin.location.level, this.origin.focused).getNearest(.1d, 1d);
        if (s != null){
            this.effect(s);
        }
    }
    @Override
    public void effect(DungeonObject dungeonObject) {
    }
}
