package um.nija123098.game.elements.dungeon;

import um.nija123098.game.elements.level.Level;
import um.nija123098.game.elements.world.Time;
import um.nija123098.game.elements.world.World;
import um.nija123098.test.TestComponent;

/**
 * Made by Dev on 12/19/2015
 */
public class Dungeon extends World {
    public Dungeon(String name, Level[] levels){
        super(name, new Time(), levels);
    }
    @TestComponent
    public Dungeon(){
        super("Dungeon", new Time(), new Level());
    }
}
