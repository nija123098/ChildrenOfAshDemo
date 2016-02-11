package um.nija123098.game.elements.item.special.moduler.items;

import um.nija123098.game.elements.Tickable;
import um.nija123098.game.elements.item.special.moduler.ModularBase;
import um.nija123098.game.elements.item.special.State;
import um.nija123098.game.elements.locationed.Location;
import um.nija123098.game.elements.structure.Structure;

/**
 * Made by Dev on 1/24/2016
 */
public class Battery extends ModularBase implements Tickable{
    public Battery(Location location, ModularBase... nearBases) {
        super("Battery", location, new Structure(), nearBases);
        this.addState(State.ELECTRIFIED);
    }
    @Override
    public void tick() {
        this.addStateAround(State.ELECTRIFIED);
    }
}
