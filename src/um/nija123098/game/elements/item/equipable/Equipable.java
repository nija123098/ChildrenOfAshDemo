package um.nija123098.game.elements.item.equipable;

import um.nija123098.game.elements.item.Item;
import um.nija123098.game.elements.item.equipable.equipmentsystem.placement.Placement;
import um.nija123098.game.elements.living.Living;
import um.nija123098.game.elements.locationed.Location;

/**
 * Made by Dev on 12/26/2015
 */
public abstract class Equipable extends Item{
    public Placement placement;
    public Equipable(String name, Location location, Placement placement) {
        super(name, location);
        this.placement = placement;
    }
    public boolean canEquip(Living living){// todo check can equip network
        return this.placement.currentPositionRig().canEquip(living) && (!(this instanceof AdditionalMethodVerificationElement) || ((AdditionalMethodVerificationElement) this).additionalVerification(living)) && living.getBody().canEquip(this) && this.placement.canEquip(living);
    }
}
