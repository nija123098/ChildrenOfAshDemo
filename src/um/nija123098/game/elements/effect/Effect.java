package um.nija123098.game.elements.effect;

import um.nija123098.game.elements.NamedObject;
import um.nija123098.game.elements.locationed.DungeonObject;

/**
 * Made by Dev on 1/23/2016
 */
public abstract class Effect extends NamedObject{
    public DungeonObject source, target;
    public Effect(String name, DungeonObject source, DungeonObject target) {
        super(name + " Effect");
        this.source = source;
        this.target = target;
    }
    public abstract boolean isValid();
    public abstract void effect();
    public abstract void tick();
    public abstract void unEffect();
}
