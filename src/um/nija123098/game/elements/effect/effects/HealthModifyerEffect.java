package um.nija123098.game.elements.effect.effects;

import um.nija123098.game.elements.damage.HealthModifier;
import um.nija123098.game.elements.effect.Effect;
import um.nija123098.game.elements.locationed.DungeonObject;

/**
 * Created by Student on 2/10/2016.
 */
public class HealthModifyerEffect extends Effect{
    public HealthModifier modifier;
    public HealthModifyerEffect(DungeonObject source, DungeonObject target, HealthModifier modifier) {
        super("Health Modify " + modifier.name, source, target);
        this.modifier = modifier;
    }
    @Override
    public boolean isValid() {
        return false;
    }
    @Override
    public void effect() {
        this.target.damageSystem.add(this.modifier);
    }
    @Override
    public void unEffect() {
    }
}
