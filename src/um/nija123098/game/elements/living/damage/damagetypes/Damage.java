package um.nija123098.game.elements.living.damage.damagetypes;

import um.nija123098.game.elements.living.damage.DamageSystem;

/**
 * Made by Dev on 1/21/2016
 */
public class Damage {
    public int damage;
    public DamageSystem damageSystem;
    public Damage(int damage){
        this.damage = damage;
    }
    public int getRealDamage(){
        return this.damage;
    }
}