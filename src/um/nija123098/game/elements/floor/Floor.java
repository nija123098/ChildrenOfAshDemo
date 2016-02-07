package um.nija123098.game.elements.floor;

import basicjavautillibrary.um.nija123098.math.geometry.Shapes.Rectangle;
import um.nija123098.game.elements.locationed.DungeonObject;
import um.nija123098.game.elements.locationed.Location;
import um.nija123098.game.elements.structure.Structure;

/**
 * Made by Dev on 12/19/2015
 */
public abstract class Floor extends DungeonObject{// todo re apply override methods
    public Location location;
    public Floor(String name, Location location){
        super(name + " Floor", location, new Structure(10, 5, 5, new Rectangle(1, 1)));
        this.location = location;
    }
    @Override// should not call super.tick()
    public void tick(){
    }
}
