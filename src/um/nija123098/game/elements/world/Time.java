package um.nija123098.game.elements.world;

import basicjavautillibrary.um.nija123098.math.algibra.OverflowingDouble;
import um.nija123098.game.elements.Tickable;

/**
 * Made by Dev on 2/7/2016
 */
public class Time extends OverflowingDouble implements Tickable{
    public Time() {
        super(24d);
    }
    @Override
    public void tick() {
        this.add(.005d);
    }
    public double lightLevel(){
        return this.getValue();
    }// it works like this
}
