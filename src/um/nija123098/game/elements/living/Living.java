package um.nija123098.game.elements.living;

import um.nija123098.game.elements.Tickable;
import um.nija123098.game.elements.living.body.Body;
import um.nija123098.game.elements.living.inventory.Inventory;
import um.nija123098.game.elements.locationed.DungeonObject;
import um.nija123098.game.elements.locationed.Location;
import um.nija123098.game.elements.locationed.packages.subs.ActionMethodContactPackage;
import um.nija123098.game.elements.locationed.packages.subs.StompPackage;
import um.nija123098.game.elements.locationed.packages.subs.WalkContactPackage;
import um.nija123098.game.elements.projectile.Projectile;
import um.nija123098.resorce.Vec;
import um.nija123098.test.TestComponent;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Made by Dev on 12/19/2015
 */
public abstract class Living extends DungeonObject implements Tickable{
    public boolean male = false;
    public boolean construct = false;
    public Stats stats;
    public Inventory inventory;
    public Body body;
    public Living(String name, Location location, Stats stats, Inventory inventory, Body body){
        super(name, location);
        this.stats = stats;
        this.inventory = inventory;
        this.body = body;
    }
    @TestComponent
    public Living(Location location){
        this("LIVING TEST COMPONENT", location, new Stats(), new Inventory(20), new Body(null, null));
        this.body.living = this;
    }
    @Override
    public void tick(){
        this.movementTick();
    }
    public void movementTick(){
        this.move();
    }
    //@Setting
    public static final float PRECISION = .5f;
    public void move(){
        Vec moveVec = this.getPath();
        for (Float i = moveVec.mag(); i < -PRECISION+.0001f; i = i-PRECISION) {
            ArrayList<DungeonObject> dungeonObjects = new ArrayList<>(4);
            Collections.addAll(dungeonObjects, this.location.objectsAt());
            if (this.walkContact(new WalkContactPackage(this.location, moveVec.along(PRECISION), this, dungeonObjects))){
                this.location.move(moveVec.along(PRECISION));
            }else{
                break;
            }
        }
    }
    public void throwObject(DungeonObject dungeonObject, Vec vec){
        this.location.level.looseObjects.add(new Projectile(dungeonObject, vec, 2f));
    }
    public boolean walkContact(WalkContactPackage walkContactPackage){// when this walks into that, that package requires info on if walkedContact return
        if (walkContactPackage.getTargetLocation().getFloor()==null){
            return false;
        }
        boolean result = true;
        for (DungeonObject dungeonObject : walkContactPackage.affected){
            if (!dungeonObject.walkedContact(walkContactPackage)){
                result = false;
            }
        }
        return result;
    }
    public void methodContact(ActionMethodContactPackage actionMethodContactPackage){// when this attacks that
        actionMethodContactPackage.actionMethod.activate(actionMethodContactPackage);
    }
    public void stomp(){//public abstract void stomp();// um
        ArrayList<DungeonObject> dungeonObjects = new ArrayList<DungeonObject>();
        dungeonObjects.add(this.location.getFloor());
        Collections.addAll(dungeonObjects, this.location.level.objectsAt(this.location.x, this.location.y));
        for (DungeonObject dungeonObject : dungeonObjects){
            dungeonObject.stompedOn(new StompPackage(this.location, this, dungeonObjects));
        }
    }
    public boolean isConstruct(){
        return this.construct;
    }
    public abstract Vec getPath();
}
