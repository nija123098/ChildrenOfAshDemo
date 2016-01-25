package um.nija123098.game.elements.item.equipable.equipablebases.moduler.items;

import um.nija123098.game.elements.item.equipable.equipablebases.moduler.ModularBase;
import um.nija123098.game.elements.locationed.Location;

/**
 * Made by Dev on 1/24/2016
 */
public class InsilatedWire extends Wire{
    public InsilatedWire(Location location, ModularBase... nearBases) {
        super(location, nearBases);
    }
    @Override// this serves to not heat the wire, DO NOT REMOVE
    public void tick(){}
}
