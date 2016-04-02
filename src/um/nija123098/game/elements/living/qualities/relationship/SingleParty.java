package um.nija123098.game.elements.living.qualities.relationship;

import um.nija123098.game.elements.locationed.DungeonObject;

/**
 * Created by Student on 2/17/2016.
 */
public class SingleParty implements Party{
    public DungeonObject dungeonObject;
    public SingleParty(DungeonObject dungeonObject){
        this.dungeonObject = dungeonObject;
    }
    @Override
    public boolean isFaction() {
        return false;
    }
    @Override
    public boolean isMember(DungeonObject object) {
        return object.equals(this.dungeonObject);
    }
    @Override
    public boolean isRepresentative(DungeonObject object) {
        return true;
    }
}
