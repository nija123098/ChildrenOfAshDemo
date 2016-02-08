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
    public Heal(int heal){
        super("Heal", heal);
    }
    public boolean isValid(){
        return true;
    }
    public void apply(ArrayList<Damage> damage) {
        for (Damage d :
                damage) {
            d.mod -= this.mod;
            if (d.mod < 0){
                this.mod = 0;
                this.mod = -d.mod;
            }
        }
    }
}
