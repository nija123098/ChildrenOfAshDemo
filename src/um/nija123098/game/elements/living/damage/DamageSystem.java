package um.nija123098.game.elements.living.damage;

import um.nija123098.game.elements.living.Stats;
import um.nija123098.game.elements.living.damage.damagetypes.Damage;

import java.util.ArrayList;

/**
 * Made by Dev on 1/22/2016
 */
public class DamageSystem {// should make healing easy
    public Stats stats;
    public ArrayList<Damage> damages;
    public DamageSystem(Stats stats){
        this.damages = new ArrayList<Damage>();
        this.stats = stats;
    }
    public int getRealDamage(){
        int damage = 0;
        for (Damage d : this.damages){
            damage += d.getRealDamage();
        }
        return damage;
    }
    public boolean isAlive(){
        return this.stats.getLife() > this.getRealDamage();
    }
    public void add(Damage damage){
        this.damages.add(damage);
        damage.damageSystem = this;
    }
    public ArrayList<Damage> getTypes(Damage damage){
        ArrayList<Damage> list = new ArrayList<Damage>();
        for (Damage d : this.damages){
            if (d.getClass() == damage.getClass()){
                list.add(d);
            }
        }
        return list;
    }
    public ArrayList getTypes(String className){
        ArrayList<Damage> list = new ArrayList<Damage>();
        for (Damage d : this.damages){
            if (d.getClass().getName().equals(className)){
                list.add(d);
            }
        }
        return list;
    }
}
