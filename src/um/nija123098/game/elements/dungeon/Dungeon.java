package um.nija123098.game.elements.dungeon;

import um.nija123098.game.elements.Tickable;
import um.nija123098.game.elements.level.Level;
import um.nija123098.test.TestComponent;

/**
 * Made by Dev on 12/19/2015
 */
public class Dungeon implements Tickable{
    public Level[] levels;
    public Dungeon(Level[] levels){
        this.levels = levels;
    }
    @TestComponent
    public Dungeon(){
        this.levels = new Level[]{new Level()};
    }
    @Override
    public void tick() {
        for (Level level : this.levels){
            level.tick();
        }
    }
}
