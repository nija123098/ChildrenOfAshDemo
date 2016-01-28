package um.nija123098.game.elements.living;

import um.nija123098.game.elements.Tickable;
import um.nija123098.game.elements.living.body.Body;
import um.nija123098.game.elements.living.damage.DamageSystem;
import um.nija123098.game.elements.living.inventory.Inventory;
import um.nija123098.game.elements.locationed.DungeonObject;
import um.nija123098.game.elements.locationed.Location;
import um.nija123098.game.elements.locationed.packages.subs.ActionMethodContactPackage;
import um.nija123098.game.elements.locationed.packages.subs.ItemContactPackage;
import um.nija123098.game.elements.locationed.packages.subs.StompPackage;
import um.nija123098.resorce.Rand;
import um.nija123098.test.TestComponent;

import java.util.ArrayList;
import java.util.Collections;

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
    /*
    @Override
    public void tick(){
        super.tick();
        this.movementTick();
    }
    public void movementTick(){
        this.move();
    }
    //@Setting
    public static final float PRECISION = .5f;
    public void move(){
        this.tickPathing();
        Vec moveVec = location.vec.clone();
        for (Float i = moveVec.mag(); i < -PRECISION+.0001f; i = i-PRECISION) {
            ArrayList<DungeonObject> dungeonObjects = new ArrayList<>(4);
            Collections.addAll(dungeonObjects, this.location.objectsAt());
            if (this.itemContact(new ItemContactPackage(this.location, this, dungeonObjects))){
                this.location.move(moveVec.along(PRECISION));
            }else{
                break;
            }
        }
    }*/
    public boolean itemContact(ItemContactPackage itemContactPackage){// when this walks into that, that package requires info on if itemContacted return
        Location l = itemContactPackage.originLocation.clone();
        l.vec.add(l.vec.along(PRECISION));
        if (l.getFloor()==null){
            return false;
        }
        boolean result = true;
        for (DungeonObject dungeonObject : itemContactPackage.affected){
            if (!dungeonObject.itemContacted(itemContactPackage)){
                result = false;
            }
        }
        return result;
    }
    public void methodContact(ActionMethodContactPackage actionMethodContactPackage){// when this attacks that
        actionMethodContactPackage.actionMethod.activate(actionMethodContactPackage);
    }
    public void stomp(){//public abstract void stomp();// um
        ArrayList<DungeonObject> dungeonObjects = this.location.objectsAt();
        dungeonObjects.add(this.location.getFloor());
        for (DungeonObject dungeonObject : dungeonObjects){
            dungeonObject.stompedOn(new StompPackage(this.location, this, dungeonObjects));
        }
    }
    public boolean isConstruct(){
        return this.construct;
    }
    public abstract void tickPathing();
}
