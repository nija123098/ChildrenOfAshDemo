package um.nija123098.game.elements.item.special.chemical;

import um.nija123098.game.elements.item.special.State;
import um.nija123098.game.elements.locationed.DungeonObject;

/**
 * Made by Dev on 1/31/2016
 */
public interface Chemical {// may want to add State to all items, may want to make this a class and have these as ActionMethod Possibilities
    void add(Chemical chemical, DungeonObject chemist);
    void mix(DungeonObject mixer);
    void setState(State state);// perhaps make a state handler
}
