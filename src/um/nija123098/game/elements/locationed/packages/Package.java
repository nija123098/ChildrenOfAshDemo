package um.nija123098.game.elements.locationed.packages;

import um.nija123098.game.elements.living.Living;
import um.nija123098.game.elements.locationed.DungeonObject;
import um.nija123098.game.elements.locationed.Location;

import java.util.ArrayList;

/**
 * Created by Student on 1/19/2016.
 */
public class Package {
    public DungeonObject origin;
    public Location originLocation;
    public ArrayList<DungeonObject> affected;
    //public DungeonObject[] affected;
    public Package(Location originLocation, DungeonObject origin, ArrayList<DungeonObject> affected){
        this.originLocation = originLocation;
        this.origin = origin;
        this.affected = affected;
    }
    public Package(Package pack){
        this(pack.originLocation, pack.origin, pack.affected);
    }
    public Living[] getAffectedLiving(boolean constructCounts){
        ArrayList<Living> affectedLivings = new ArrayList<Living>();
        for (DungeonObject dungeonObject : this.affected) {
            if (dungeonObject instanceof Living && (!((Living) dungeonObject).isConstruct() || constructCounts)){
                affectedLivings.add((Living) dungeonObject);
            }
        }
        return affectedLivings.toArray(new Living[affectedLivings.size()]);
    }
    public int getNumberOfLivings(boolean constructCounts){
        int livingCount = 0;
        for (DungeonObject dungeonObject : this.affected) {
            if (dungeonObject instanceof Living && (!((Living) dungeonObject).isConstruct() || constructCounts)) {
                ++livingCount;
            }
        }
        return livingCount;
    }

}
