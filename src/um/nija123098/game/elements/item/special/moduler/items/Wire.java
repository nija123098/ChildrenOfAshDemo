package um.nija123098.game.elements.item.special.moduler.items;

import basicjavautillibrary.um.nija123098.math.geometry.Shapes.Rectangle;
import um.nija123098.game.elements.Tickable;
import um.nija123098.game.elements.item.special.moduler.ModularBase;
import um.nija123098.game.elements.item.special.State;
import um.nija123098.game.elements.locationed.Location;
import um.nija123098.game.elements.structure.Structure;

/**
 * Made by Dev on 1/24/2016
 */
public class Wire extends ModularBase implements Tickable{
    public int heat = 0;// perhaps all objects should have heat, that would make this far better
    public Wire(Location location, ModularBase... nearBases) {
        super("Wire", location, new Structure(2d, 2d, 2d, new Rectangle(1, .1d)), nearBases);// structure here temp
    }
    @Override
    public void addState(State state){
        super.addState(state);
        if (state == State.ELECTRIFIED){
            this.addStateAround(State.ELECTRIFIED);
        }
    }
    @Override
    public void tick() {
        if (this.hasState(State.ELECTRIFIED) && this.heat < 100){
            ++this.heat;
        }else if (this.heat > 0){
            --this.heat;
        }
        if (this.heat > 75){
            this.addState(State.HEATED);
        }else{
            this.removeState(State.HEATED);
        }
    }
}
