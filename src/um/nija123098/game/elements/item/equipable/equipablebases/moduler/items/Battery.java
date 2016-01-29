package um.nija123098.game.elements.item.equipable.equipablebases.moduler.items;

import um.nija123098.game.elements.Tickable;
import um.nija123098.game.elements.item.equipable.equipablebases.moduler.ModularBase;
import um.nija123098.game.elements.item.equipable.equipablebases.moduler.State;
import um.nija123098.game.elements.locationed.Location;

/**
 * Made by Dev on 1/24/2016
 */
public class Battery extends ModularBase implements Tickable{
    public Battery(Location location, ModularBase... nearBases) {
        super("Battery", location, nearBases);
        this.addState(State.ELECTRIFIED);
    }
    @Override
    public void tick() {
        super.tick();
        this.addStateAround(State.ELECTRIFIED);
    }
}
