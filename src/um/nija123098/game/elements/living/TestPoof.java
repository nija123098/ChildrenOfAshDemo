package um.nija123098.game.elements.living;

import um.nija123098.game.elements.item.equipable.equipmentsystem.position.Position;
import um.nija123098.game.elements.living.body.Body;
import um.nija123098.game.elements.living.inventory.Inventory;
import um.nija123098.game.elements.locationed.DungeonObject;
import um.nija123098.game.elements.locationed.Location;
import um.nija123098.resorce.Vec;

import java.util.Random;

/**
 * Made by Dev on 1/18/2016
 */
public class TestPoof extends Living{
    int flat = 0;
    public TestPoof(Location location) {
        super("Test Poof", location, new Stats(), new Inventory(1), new Body(null, new Position[]{}));
        this.body.living = this;
    }
    @Override
    public Vec getPath() {
        Random random = new Random();
        if (this.flat != 0){
            return new Vec(random.nextFloat()*2-.5f, random.nextFloat()*2-.5f);
        }else{
            return new Vec(0, 0);
        }
    }
}
