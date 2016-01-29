package um.nija123098.game.elements.item;

import um.nija123098.game.elements.locationed.Location;
import um.nija123098.test.TestComponent;

/**
 * Made by Dev on 1/18/2016
 */
@TestComponent
public class TestItem extends Item{// todo re apply override methods
    public int life = 10;
    public TestItem(Location location) {
        super("Test", location);
    }
}
