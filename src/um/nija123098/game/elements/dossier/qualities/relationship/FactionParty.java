package um.nija123098.game.elements.dossier.qualities.relationship;

import um.nija123098.game.elements.faction.Faction;
import um.nija123098.game.elements.locationed.DungeonObject;

/**
 * Created by Student on 2/17/2016.
 */
public class FactionParty implements Party {
    public Faction faction;
    public FactionParty(Faction faction){
        this.faction = faction;
    }
    @Override
    public boolean isFaction() {
        return true;
    }
    @Override
    public boolean isMember(DungeonObject object) {
        return this.faction.isMember(object);
    }
    @Override
    public boolean isRepresentative(DungeonObject object) {
        return this.faction.isRepresentative(object);
    }
}
