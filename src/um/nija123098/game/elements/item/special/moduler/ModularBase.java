package um.nija123098.game.elements.item.special.moduler;

import um.nija123098.game.elements.item.special.State;
import um.nija123098.game.elements.locationed.DungeonObject;
import um.nija123098.game.elements.locationed.Location;
import um.nija123098.game.elements.structure.Structure;

import java.util.ArrayList;

/**
 * Made by Dev on 1/24/2016
 */
public abstract class ModularBase extends DungeonObject{// all extensions of this should be discontinued until system completion
    public ModularBase[] nearBases;
    public ArrayList<State> states;
    public ModularBase(String name, Location location, Structure structure, ModularBase...nearBases) {
        super(name + " Modular Base", location, structure);
        this.nearBases = nearBases;
    }//---------------------------!
    public void addState(State state){
        if (!this.states.contains(state)){
            this.states.add(state);
        }
    }
    public boolean removeState(State state){
        return this.states.remove(state);
    }
    public void addStateAround(State state){
        for (ModularBase modularBase : this.nearBases){
            modularBase.addState(state);
        }
    }
    public boolean hasState(State state){
        for (State s : this.states){
            if (s == state){
                return true;
            }
        }
        return false;
    }
}
