package um.nija123098.game.elements.living.damage;

import java.util.ArrayList;

/**
 * Made by Dev on 1/22/2016
 */
public class DamageSystem {
    public int lifePoints;
    public ArrayList<Damage> damages;
    public DamageSystem(int lifePoints){
        this.damages = new ArrayList<Damage>();
        this.lifePoints = lifePoints;
    }
    public int getRealDamage(){
        int damage = 0;
        for (Damage d : this.damages){
            damage += d.getRealDamage();
        }
        return damage;
    }
    public boolean isAlive(){
        return this.lifePoints > this.getRealDamage();
    }
}
