package um.nija123098.game.elements.item.equipable.equipmentsystem.position;

import um.nija123098.game.elements.NamedObject;
import um.nija123098.game.elements.item.equipable.AdditionalMethodVerificationElement;
import um.nija123098.game.elements.item.equipable.Equipable;
import um.nija123098.game.elements.living.Living;

/**
 * Made by Dev on 12/27/2015
 */
public class Position extends NamedObject{
    public int maxStackSize;
    public Position(String name, int maxStackSize) {
        super(name + " Position");
        this.maxStackSize = maxStackSize;
    }
    public Position(String name) {
        this(name, 1);
    }
    public boolean canEquip(Living living) {
        for (int item = 0; item < living.inventory.container.items.size(); item++) {
            if (living.inventory.equippedIndex.contains(item)){
                int positionStackCount = 0;
                for (Position position : ((Equipable) living.inventory.container.items.get(item)).placement.currentPositionRig().positions){
                    if (position.isType(this)){
                        ++positionStackCount;
                    }
                    if (positionStackCount > this.maxStackSize){
                        return false;
                    }
                }
            }
        }
        return !(this instanceof AdditionalMethodVerificationElement) || ((AdditionalMethodVerificationElement) this).additionalVerification(living);
    }
}
