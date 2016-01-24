package um.nija123098.game.elements.effect;

import um.nija123098.game.elements.actionmethod.ActionMethod;
import um.nija123098.game.elements.locationed.DungeonObject;

/**
 * Made by Dev on 1/23/2016
 */
public abstract class ActionMethodTrackingEffect extends Effect{
    public ActionMethod actionMethod;
    public ActionMethodTrackingEffect(String name, DungeonObject source, DungeonObject target, ActionMethod actionMethod) {
        super(name, source, target);
        this.actionMethod = actionMethod;
    }
}
