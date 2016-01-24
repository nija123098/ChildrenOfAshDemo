package um.nija123098.game.elements.actionmethod;

import um.nija123098.game.elements.NamedObject;
import um.nija123098.game.elements.Tickable;
import um.nija123098.game.elements.locationed.packages.subs.ActionMethodContactPackage;

/**
 * Made by Dev on 1/21/2016
 */
public abstract class ActionMethod extends NamedObject implements Tickable{
    public ActionMethod(String name) {
        super(name);
    }
    public abstract void activate(ActionMethodContactPackage actionMethodContactPackage);
    public abstract void effect(ActionMethodActivationPackage actionMethodActivationPackage);
}
