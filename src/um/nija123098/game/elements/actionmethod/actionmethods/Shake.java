package um.nija123098.game.elements.actionmethod.actionmethods;

import um.nija123098.game.elements.actionmethod.ActionMethod;
import um.nija123098.game.elements.locationed.DungeonObject;

/**
 * Made by Dev on 1/31/2016
 */
public class Shake extends ActionMethod {
    public Shake(DungeonObject origin) {
        super("Shake", origin);
    }
    @Override
    public void activate() {
        DungeonObject s = this.origin.getFocused(.1d, .5d);
        if (s != null){
            this.effect(s);
        }
    }
    @Override
    public void effect(DungeonObject dungeonObject) {
    }
}
