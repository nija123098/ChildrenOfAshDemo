package um.nija123098.game.elements.item.equipable.equipablebases.moduler.items;

import um.nija123098.game.elements.Tickable;
import um.nija123098.game.elements.item.equipable.equipablebases.moduler.ModularBase;
import um.nija123098.game.elements.item.equipable.equipablebases.moduler.State;
import um.nija123098.game.elements.locationed.Location;

/**
 * Made by Dev on 1/24/2016
 */
public class Wire extends ModularBase implements Tickable{
    public int heat = 0;// perhaps all objects should have heat, that would make this far better
    public Wire(Location location, ModularBase... nearBases) {
        super("Wire", location, nearBases);
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
