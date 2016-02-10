package um.nija123098.game.elements.damage.damagetypes;

import um.nija123098.game.elements.damage.HealthModifier;

/**
 * Made by Dev on 1/21/2016
 */
public class Damage extends HealthModifier{
    public Damage(String name, int damage){
        super(name + " Damage", damage);
    }
    public Damage(int damage){
        super("Damage", damage);
    }
    public int getRealDamage(){
        return this.mod;
    }
}
