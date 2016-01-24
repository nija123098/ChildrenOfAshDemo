package um.nija123098.game.elements.actionmethod;

import um.nija123098.game.elements.locationed.packages.Package;
import um.nija123098.game.elements.locationed.packages.subs.ActionMethodContactPackage;
import um.nija123098.resorce.Vec;

/**
 * Made by Dev on 1/23/2016
 */
public class ActionMethodActivationPackage extends Package{
    public Vec vec;
    public ActionMethodActivationPackage(ActionMethodContactPackage actionMethodContactPackage){
        super(actionMethodContactPackage);
        this.vec = actionMethodContactPackage.attackDirection;
    }
}
