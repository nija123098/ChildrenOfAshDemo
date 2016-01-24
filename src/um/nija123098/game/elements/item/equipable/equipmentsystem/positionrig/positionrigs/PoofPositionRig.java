package um.nija123098.game.elements.item.equipable.equipmentsystem.positionrig.positionrigs;

import um.nija123098.game.elements.item.equipable.equipmentsystem.positionrig.PositionRig;
import um.nija123098.game.elements.item.equipable.equipmentsystem.position.Position;
import um.nija123098.game.elements.item.equipable.equipmentsystem.position.positions.PoofPosition;
import um.nija123098.test.TestComponent;

/**
 * Made by Dev on 1/18/2016
 */
@TestComponent
public class PoofPositionRig extends PositionRig{
    public PoofPositionRig() {
        super("Poof", new Position[]{new PoofPosition()});
    }
}
