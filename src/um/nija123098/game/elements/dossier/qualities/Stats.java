package um.nija123098.game.elements.dossier.qualities;

import um.nija123098.game.elements.Setting;
import um.nija123098.test.TestComponent;

/**
 * Made by Dev on 12/19/2015
 */
public class Stats {
    public int[] strength;
    public int[] constitution;
    public int[] charisma;
    public int[] agility;
    public int[] intelligence;
    public Stats(int[] strength, int[] constitution, int[] charisma, int[] agility, int[] intelligence){
        this.strength = strength;
        this.constitution = constitution;
        this.charisma = charisma;
        this.agility = agility;
        this.intelligence = intelligence;
    }
    @TestComponent
    public Stats(){
        this(1f, 1f, 1f, 1f, 1f);
    }
    @Setting
    public static final int MAX_LEVEL = 16;
    public Stats(float strengthFactor, float constitutionFactor, float charismaFactor, float agilityFactor, float intelligenceFactor){
        this.strength = new int[MAX_LEVEL];
        this.constitution = new int[MAX_LEVEL];
        this.charisma = new int[MAX_LEVEL];
        this.agility = new int[MAX_LEVEL];
        this.intelligence = new int[MAX_LEVEL];
        float strength = strengthFactor;
        float constitution = constitutionFactor;
        float charisma = charismaFactor;
        float agility = agilityFactor;
        float intelligence = intelligenceFactor;
        for (int lev = 0; lev < MAX_LEVEL; lev++) {
            this.strength[lev] = (int) (strength += strengthFactor);
            this.constitution[lev] = (int) (constitution += constitutionFactor);
            this.charisma[lev] = (int) (charisma += charismaFactor);
            this.agility[lev] = (int) (agility += agilityFactor);
            this.intelligence[lev] = (int) (intelligence += intelligenceFactor);
        }
    }
    public int getStrength(int level){
        return this.strength[level > this.strength.length-1 ? this.strength.length-1 : level];
    }
    public int getConstitution(int level){
        return this.constitution[level > this.constitution.length-1 ? this.constitution.length-1 : level];
    }
    public int getCharisma(int level){
        return this.charisma[level > this.charisma.length-1 ? this.charisma.length-1 : level];
    }
    public int getAgility(int level){
        return this.agility[level > this.agility.length-1 ? this.agility.length-1 : level];
    }
    public int getIntelligence(int level){
        return this.intelligence[level > this.charisma.length-1 ? this.charisma.length-1 : level];
    }
}
