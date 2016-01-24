package um.nija123098.game.elements.item.equipable.equipmentsystem.placement.placements;

import um.nija123098.game.elements.item.equipable.equipmentsystem.placement.Placement;
import um.nija123098.game.elements.item.equipable.equipmentsystem.positionrig.PositionRig;
import um.nija123098.game.elements.item.equipable.equipmentsystem.positionrig.positionrigs.PoofPositionRig;
import um.nija123098.test.TestComponent;

/**
 * Made by Dev on 1/18/2016
 */
@TestComponent
public class PoofPlacement extends Placement{
    public PoofPlacement() {
        super(new PositionRig[]{new PoofPositionRig()});
    }
}
