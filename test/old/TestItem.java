package old;

import basicjavautillibrary.um.nija123098.math.geometry.Shapes.Rectangle;
import um.nija123098.game.elements.item.Item;
import um.nija123098.game.elements.locationed.Location;
import um.nija123098.game.elements.structure.Structure;
import um.nija123098.test.TestComponent;

/**
 * Made by Dev on 1/18/2016
 */
@TestComponent
public class TestItem extends Item {
    public int life = 10;
    public TestItem(Location location) {
        super("old.Test", location, new Structure(2, 2, 2, new Rectangle(.3d, .3d)));
    }
}
