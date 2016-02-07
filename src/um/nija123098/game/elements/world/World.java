package um.nija123098.game.elements.world;

import basicjavautillibrary.um.nija123098.general.AdvancedArray;
import um.nija123098.game.elements.level.Level;

/**
 * Made by Dev on 2/7/2016
 */
public class World {
    public Time time;
    public AdvancedArray<Level> levels;
    public World(Time time, Level...levels){
        this.time = time;
        this.levels = new AdvancedArray<Level>(levels);
    }
}
