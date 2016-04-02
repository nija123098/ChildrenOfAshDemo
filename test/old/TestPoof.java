package old;

import basicjavautillibrary.um.nija123098.math.geometry.Vec;
import um.nija123098.game.elements.body.position.Position;
import um.nija123098.game.elements.body.Body;
import um.nija123098.game.elements.dossier.qualities.Stats;
import um.nija123098.game.elements.living.Living;
import um.nija123098.game.elements.living.inventory.Inventory;
import um.nija123098.game.elements.locationed.Location;
import um.nija123098.game.elements.structure.Structure;

import java.util.Random;

/**
 * Made by Dev on 1/18/2016
 */
public class TestPoof extends Living {
    int flat = 0;
    public TestPoof(Location location) {
        super("old.Test Poof", location, new Structure(), new Stats(), new Inventory(1), new Body("A PUFF BODY", new Position[]{}));
        this.getBody().living = this;
    }
    @Override
    public void tickPathing() {
        Random random = new Random();
        if (this.flat != 0){
            this.getLocation().vec = new Vec(random.nextFloat()*2-.5f, random.nextFloat()*2-.5f);
        }else{
            this.getLocation().vec = new Vec(0, 0);
        }
    }
}
