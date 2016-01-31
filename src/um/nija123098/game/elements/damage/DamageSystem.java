package um.nija123098.game.elements.damage;

import um.nija123098.game.elements.Tickable;
import um.nija123098.game.elements.damage.damagetypes.Damage;
import um.nija123098.game.elements.living.Stats;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Made by Dev on 1/22/2016
 */
public class DamageSystem implements Tickable {// should make healing easy, may want to
    public Stats stats;
    public ArrayList<Damage> damage;
    public DamageSystem(Stats stats){
        this.damage = new ArrayList<Damage>();
        this.stats = stats;
    }
    public int getRealDamage(){
        int damage = 0;
        for (Damage d : this.damage){
            damage += d.getRealDamage();
        }
        return damage;
    }
    public boolean isAlive(){
        return this.stats.getLife() > this.getRealDamage();
    }
    public void add(Damage damage){
        this.damage.add(damage);
        damage.damageSystem = this;
    }
    public ArrayList<Damage> getTypes(Damage damage){
        ArrayList<Damage> list = new ArrayList<Damage>();
        for (Damage d : this.damage){
            if (d.getClass() == damage.getClass()){
                list.add(d);
            }
        }
        return list;
    }
    public ArrayList getTypes(String className){
        ArrayList<Damage> list = new ArrayList<Damage>();
        for (Damage d : this.damage){
            if (d.getClass().getName().equals(className)){
                list.add(d);
            }
        }
        return list;
    }
    @Override
    public void tick(){
        Iterator<Damage> i = this.damage.iterator();
        while (i.hasNext()){
            if (!i.next().isValid()){// perhaps make
                i.remove();
            }
        }
    }
}
