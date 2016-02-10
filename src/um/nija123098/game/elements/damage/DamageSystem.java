package um.nija123098.game.elements.damage;

import um.nija123098.game.elements.Tickable;
import um.nija123098.game.elements.damage.damagetypes.Damage;
import um.nija123098.game.elements.damage.healingtypes.Heal;
import um.nija123098.game.elements.living.Stats;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Made by Dev on 1/22/2016
 */
public class DamageSystem implements Tickable {// should make healing easy, may want to
    public Stats stats;
    public ArrayList<HealthModifier> modifiers;
    public DamageSystem(Stats stats){
        this.modifiers = new ArrayList<HealthModifier>();
        this.stats = stats;
    }
    public int getRealDamage(){
        int damage = 0;
        for (HealthModifier d : this.modifiers){
            damage += d.getRealDamage();
        }
        return damage;
    }
    public boolean isAlive(){
        return this.stats.getLife() >= this.getRealDamage();
    }
    public void add(HealthModifier healthModifier){
        this.modifiers.add(healthModifier);
        healthModifier.damageSystem = this;
        healthModifier.inital();
    }
    public ArrayList<HealthModifier> getTypes(HealthModifier modifier){
        ArrayList<HealthModifier> list = new ArrayList<HealthModifier>();
        for (HealthModifier m : this.modifiers){
            if (m.getClass() == modifier.getClass()){
                list.add(m);
            }
        }
        return list;
    }
    public ArrayList getTypes(String className){
        ArrayList<HealthModifier> list = new ArrayList<HealthModifier>();
        for (HealthModifier d : this.modifiers){
            if (d.getClass().getName().equals(className)){
                list.add(d);
            }
        }
        return list;
    }
    @Override
    public void tick(){
        Iterator<HealthModifier> i = this.modifiers.iterator();
        while (i.hasNext()){
            HealthModifier m;
            if (!(m = i.next()).isValid()){// perhaps make
                m.end();
                i.remove();
            }
        }
    }
}
