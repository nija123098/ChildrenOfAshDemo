package um.nija123098.game.elements.living;

import um.nija123098.game.elements.body.position.positions.PoofPosition;
import um.nija123098.game.elements.damage.DamageSystem;
import um.nija123098.game.elements.body.Body;
import um.nija123098.game.elements.dossier.qualities.Stats;
import um.nija123098.game.elements.living.inventory.Inventory;
import um.nija123098.game.elements.locationed.DungeonObject;
import um.nija123098.game.elements.locationed.Location;
import um.nija123098.game.elements.structure.Structure;
import um.nija123098.test.TestComponent;

/**
 * Made by Dev on 12/19/2015
 */
public abstract class Living extends DungeonObject {
    public boolean construct = false;
    public Body body;
    public Stats stats;
    public Inventory inventory;
    public Living(String name, Location location, Structure structure, Stats stats, Inventory inventory, Body body){
        super(name + " Living", location, structure);
        this.stats = stats;
        this.inventory = inventory;
        this.body = body;
        this.damageSystem = new DamageSystem(this.stats);
    }
    @TestComponent
    public Living(Location location){
        this("LIVING TEST COMPONENT", location, new Structure(), new Stats(), new Inventory(20), new Body("GENERIC BODY", new PoofPosition()));
        this.body.living = this;
    }
    public boolean isConstruct(){
        return this.construct;
    }
    public abstract void tickPathing();
}
