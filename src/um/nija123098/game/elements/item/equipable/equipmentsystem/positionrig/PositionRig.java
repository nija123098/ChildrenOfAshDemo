package um.nija123098.game.elements.item.equipable.equipmentsystem.positionrig;

import um.nija123098.game.elements.NamedObject;
import um.nija123098.game.elements.item.equipable.AdditionalMethodVerificationElement;
import um.nija123098.game.elements.body.position.Position;
import um.nija123098.game.elements.living.Living;

/**
 * Made by Dev on 12/27/2015
 */
public class PositionRig extends NamedObject{
    public Position[] positions;
    public PositionRig(String name, Position[] positions) {
        super(name);
        this.positions = positions;
    }
    public boolean canEquip(Living living){
        for (Position position : this.positions){
            if (!position.canEquip(living)){
                return false;
            }
        }
        return !(this instanceof AdditionalMethodVerificationElement) || ((AdditionalMethodVerificationElement) this).additionalVerification(living);
    }
}
