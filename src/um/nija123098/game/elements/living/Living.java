package um.nija123098.game.elements.living;

import um.nija123098.game.elements.Tickable;
import um.nija123098.game.elements.living.body.Body;
import um.nija123098.game.elements.damage.DamageSystem;
import um.nija123098.game.elements.living.inventory.Inventory;
import um.nija123098.game.elements.locationed.DungeonObject;
import um.nija123098.game.elements.locationed.Location;
import um.nija123098.resorce.Rand;
import um.nija123098.test.TestComponent;

/**
 * Made by Dev on 12/19/2015
 */
public abstract class Living extends DungeonObject implements Tickable{
    public boolean male = Rand.getRand(1) != 0;
    public boolean construct = false;
    public Body body;
    public Stats stats;
    public Inventory inventory;
    public DamageSystem damageSystem;
    public Living(String name, Location location, Stats stats, Inventory inventory, Body body){
        super(name, location);
        this.stats = stats;
        this.inventory = inventory;
        this.body = body;
        this.damageSystem = new DamageSystem(this.stats);
    }
    @TestComponent
    public Living(Location location){
        this("LIVING TEST COMPONENT", location, new Stats(), new Inventory(20), new Body(null, null));
        this.body.living = this;
    }
    public boolean isConstruct(){
        return this.construct;
    }
    public abstract void tickPathing();
}
