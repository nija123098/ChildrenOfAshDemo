package um.nija123098.game.elements.dungeon;

import um.nija123098.game.elements.level.Level;
import um.nija123098.test.TestComponent;

/**
 * Made by Dev on 12/19/2015
 */
public class Dungeon {
    public Level[] floors;
    public Dungeon(Level[] floors){
        this.floors = floors;
    }
    @TestComponent
    public Dungeon(){
        this.floors = new Level[]{new Level()};
    }
}
