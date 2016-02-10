package um.nija123098.game.elements.damage;

import um.nija123098.game.elements.NamedObject;
import um.nija123098.game.elements.Tickable;

/**
 * Created by Student on 2/8/2016.
 */
public abstract class HealthModifier extends NamedObject implements Tickable{
    public int mod;
    public DamageSystem damageSystem;
    public HealthModifier(String name, int mod) {
        super(name);
        this.mod = mod;
    }
    public void addMod(int mod){
        this.mod += mod;
    }
    public void setMod(int mod){
        this.mod = mod;
    }
    public int getMod(){
        return this.mod;
    }
    public boolean isValid(){
        return this.getMod() > 0;
    }
    public void inital(){
    }
    @Override
    public void tick(){

    }
    public void end(){
    }
    public abstract int getRealDamage();
}
