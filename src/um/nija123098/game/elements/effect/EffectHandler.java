package um.nija123098.game.elements.effect;

import um.nija123098.game.elements.Tickable;
import um.nija123098.game.elements.locationed.DungeonObject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Made by Dev on 1/23/2016
 */
public class EffectHandler implements Tickable{
    public DungeonObject object;
    public ArrayList<Effect> effects;
    public EffectHandler(DungeonObject object){
        this.object = object;
    }
    public void add(Effect effect){
        this.effects.add(effect);
        effect.effect();
    }
    @Override
    public void tick() {
        Iterator<Effect> i = this.effects.iterator();
        while (i.hasNext()){
            Effect e;
            if (!(e = i.next()).isValid()){
                e.unEffect();
                i.remove();
            }
        }
    }
}
