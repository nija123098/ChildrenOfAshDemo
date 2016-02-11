package um.nija123098.game.elements.living;

import um.nija123098.game.elements.locationed.Location;
import um.nija123098.test.TestComponent;

/**
 * Created by Student on 1/16/2016.
 */
public class Player extends Living{
    @TestComponent
    public Player(Location location) {
        super(location);
    }
    @Override
    public void tickPathing() {

    }
}
