package um.nija123098.game.elements.item.equipable.equipables;

import um.nija123098.game.elements.item.equipable.Equipable;
import um.nija123098.game.elements.item.equipable.equipmentsystem.placement.Placement;
import um.nija123098.game.elements.item.equipable.equipmentsystem.positionrig.PositionRig;
import um.nija123098.game.elements.living.Living;
import um.nija123098.game.elements.locationed.DungeonObject;
import um.nija123098.game.elements.locationed.Location;
import um.nija123098.test.TestComponent;

/**
 * Made by Dev on 1/18/2016
 */
@TestComponent
public class PoofArmor extends Equipable{
    public PoofArmor(Location location) {
        super("Poof Armor", location, new Placement(new PositionRig[]{}));
    }

}
