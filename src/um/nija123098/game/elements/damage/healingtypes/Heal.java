package um.nija123098.game.elements.damage.healingtypes;

import um.nija123098.game.elements.damage.HealthModifier;
import um.nija123098.game.elements.damage.damagetypes.Damage;

import java.util.ArrayList;

/**
 * Created by Student on 2/8/2016.
 */
public class Heal extends HealthModifier{
    public Heal(String name, int heal){
        super(name + " Heal", heal);
    }
    @Override
    public int getRealDamage() {
        return -this.getMod()/16;
    }
    public Heal(int heal){
        super("Heal", heal);
    }
    public void apply(ArrayList<HealthModifier> modifiers) {
        for (HealthModifier modifier : modifiers) {
            modifier.addMod(-this.getMod());
            if (modifier.getMod() < 0){
                this.setMod(-modifier.getMod());
            }
        }
    }
}
