package um.nija123098.game.elements.living.body;

import um.nija123098.game.elements.item.equipable.Equipable;
import um.nija123098.game.elements.item.equipable.equipmentsystem.position.Position;
import um.nija123098.game.elements.living.Living;

/**
 * Made by Dev on 12/27/2015
 */
public class Body {
    public Living living;
    public Position[] positions;
    public Body(Living living, Position[] positions){
        this.living = living;
        this.positions = positions;
    }
    public boolean canEquip(Equipable equipable){
        for (Position position : equipable.placement.currentPositionRig().positions){
            boolean hasPosition = false;
            for (Position bodyPosition : this.positions){
                if (position.isType(bodyPosition)){
                    hasPosition = true;
                    break;
                }
            }
            if (!hasPosition){
                return false;
            }
        }
        return true;
    }
}
