package um.nija123098.game.elements.damage;

import um.nija123098.game.elements.NamedObject;

/**
 * Created by Student on 2/8/2016.
 */
public class HealthModifier extends NamedObject{
    public int mod;
    public DamageSystem damageSystem;
    public HealthModifier(String name, int mod) {
        super(name);
        this.mod = mod;
    }
}
