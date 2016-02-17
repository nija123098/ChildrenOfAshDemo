package um.nija123098.game.elements.faction;

import basicjavautillibrary.um.nija123098.general.AdvancedArray;
import um.nija123098.game.elements.NamedObject;
import um.nija123098.game.elements.dungeon.Dungeon;
import um.nija123098.game.elements.locationed.DungeonObject;

import java.util.ArrayList;

/**
 * Made by Dev on 2/13/2016
 */
public class Faction extends NamedObject{
    private ArrayList<DungeonObject> members;
    public Faction(String name, DungeonObject...members) {
        super(name + " Faction");
        this.members = new AdvancedArray<DungeonObject>(members);
    }
    public void addMember(DungeonObject dungeonObject){
        this.members.add(dungeonObject);
    }
    public boolean isMember(DungeonObject dungeonObject){
        return this.members.contains(dungeonObject);
    }
    public boolean isRepresentative(DungeonObject dungeonObject){
        return false;// todo
    }
}
