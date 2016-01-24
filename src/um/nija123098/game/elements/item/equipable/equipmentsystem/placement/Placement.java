package um.nija123098.game.elements.item.equipable.equipmentsystem.placement;

import um.nija123098.game.elements.item.equipable.AdditionalMethodVerificationElement;
import um.nija123098.game.elements.item.equipable.equipmentsystem.positionrig.PositionRig;
import um.nija123098.game.elements.living.Living;
import um.nija123098.resorce.Rand;

/**
 * Made by Dev on 1/18/2016
 */
public class Placement {// todo make compatable with AdditionalMethodVerificationElement
    public int currentPlacement;
    public PositionRig[] positionRigs;
    public Placement(PositionRig[] positionRigs){
        this.positionRigs = positionRigs;
        this.currentPlacement = Rand.getRand(positionRigs.length-1);
    }
    public boolean canEquip(Living living){
        return !(this instanceof AdditionalMethodVerificationElement) || ((AdditionalMethodVerificationElement) this).additionalVerification(living);
    }
    public PositionRig currentPositionRig(){
        return this.positionRigs[this.currentPlacement];
    }
}
