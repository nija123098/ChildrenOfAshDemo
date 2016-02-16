package um.nija123098.game.elements.faction;

import um.nija123098.game.elements.NamedObject;
import um.nija123098.game.elements.locationed.DungeonObject;

import java.util.ArrayList;

/**
 * Made by Dev on 2/13/2016
 */
public class Faction extends NamedObject{
    public ArrayList<DungeonObject> members;
    public Faction(String name) {
        super(name + " Faction");
    }
}
