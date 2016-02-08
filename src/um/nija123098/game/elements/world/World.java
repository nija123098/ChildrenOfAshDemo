package um.nija123098.game.elements.world;

import basicjavautillibrary.um.nija123098.general.AdvancedArray;
import um.nija123098.game.elements.NamedObject;
import um.nija123098.game.elements.level.Level;

/**
 * Made by Dev on 2/7/2016
 */
public class World extends NamedObject{
    public Time time;
    public AdvancedArray<Level> levels;
    public World(String name, Time time, Level...levels){
        super(name);
        this.time = time;
        this.levels = new AdvancedArray<Level>(levels);
    }
}
