package um.nija123098.game.elements.living;

import um.nija123098.test.TestComponent;

/**
 * Made by Dev on 12/19/2015
 */
public class Stats {
    public int level;
    public int[] strength;
    public int[] constitution;
    public int[] toughness;
    public int[] agility;
    public int[] intelligence;
    public Stats(int[] strength, int[] constitution, int[] toughness, int[] agility, int[] intelligence){
        this.strength = strength;
        this.constitution = constitution;
        this.toughness = toughness;
        this.agility = agility;
        this.intelligence = intelligence;
    }
    @TestComponent
    public Stats(){
        this(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
    }
    public int getStrength() {
        return this.strength[this.level > this.strength.length-1 ? this.strength.length-1 : this.level];
    }
    public int getConstitution() {
        return this.constitution[this.level > this.constitution.length-1 ? this.constitution.length-1 : this.level];
    }
    public int getToughness() {
        return this.toughness[this.level > this.toughness.length-1 ? this.toughness.length-1 : this.level];
    }
    public int getAgility() {
        return this.agility[this.level > this.agility.length-1 ? this.agility.length-1 : this.level];
    }
    public int getIntelligence() {
        return this.intelligence[this.level > this.toughness.length-1 ? this.toughness.length-1 : this.level];
    }
    public int getLife(){
        return (int) (this.getStrength() * .7 + this.getToughness() * .2 + this.getAgility() * .1);
    }
    public int getDodge(){
        return (int) (this.getAgility() * .6 + this.getIntelligence() * .3 + this.getStrength() * .1);
    }
    public int getSkill(){
        return (int) (this.getIntelligence() * .7 + this.getAgility() * .3);
    }
    public int getDefense(){
        return (int) (this.getToughness() * .6 + this.getStrength() * .2 + this.getConstitution() * .2);
    }
    public int getResistance(){
        return (int) (this.getConstitution() * .8 + this.getToughness() * .2);
    }
}
