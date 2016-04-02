package um.nija123098.game.elements.living;

import basicjavautillibrary.um.nija123098.general.AdvancedArray;
import um.nija123098.game.elements.body.Body;
import um.nija123098.game.elements.damage.DamageSystem;
import um.nija123098.game.elements.effect.EffectHandler;
import um.nija123098.game.elements.living.inventory.Inventory;
import um.nija123098.game.elements.living.qualities.BodyType;
import um.nija123098.game.elements.living.qualities.Quirk;
import um.nija123098.game.elements.living.qualities.Sex;
import um.nija123098.game.elements.living.qualities.Stats;
import um.nija123098.game.elements.living.qualities.race.Race;
import um.nija123098.game.elements.locationed.DungeonObject;
import um.nija123098.game.elements.locationed.Location;

/**
 * Made by Dev on 12/19/2015
 */
public abstract class Living extends DungeonObject {
    private int xp;
    private double height;
    private double weight;
    private boolean construct = false;
    private Sex sex;
    private Race race;
    private Body body;
    private Stats stats;
    private BodyType bodyType;
    private Inventory inventory;
    private AdvancedArray<Quirk> quirks;
    public Living(String name, Location location, int xp, double height, double weight, Sex sex, Race race, Body body, Stats stats, BodyType bodyType, Inventory inventory, AdvancedArray<Quirk> quirks) {
        super(name, location);
        this.xp = xp;
        this.height = height;
        this.weight = weight;
        this.construct = race.isConstruct();
        this.sex = sex;
        this.race = race;
        this.body = body;
        this.stats = stats;
        this.bodyType = bodyType;
        this.inventory = inventory;
        this.quirks = quirks;
    }
    public Living(String name, Location location, int xp, Race race, Stats stats, Inventory inventory, AdvancedArray<Quirk> quirks){
        super(name + "Living", location);// sex, race, and body type should determine more stats
        this.xp = xp;
        this.race = race;
        this.sex = this.race.getPossibleSexes().getRandom();
        this.bodyType = this.race.getPossibleBodyTypes(this.sex).getRandom();
        this.height = this.race.getHeightRange(this.sex, this.bodyType).getRandom();
        this.weight = this.race.getWeightRange(this.sex, this.bodyType).getRandom();
        this.construct = this.race.isConstruct();
        this.body = this.race.getBody(this.sex, this.bodyType);
        this.stats = stats;
        this.inventory = inventory;
        this.quirks = quirks;
    }
    /*
    public Living(String name, Location location, Stats stats, Inventory inventory, Body body){
            super(name + " Living", location);
            this.stats = stats;
            this.inventory = inventory;
            this.body = body;
            //this.setDamageSystem(new DamageSystem(this.stats));
        }
        @TestComponent
        public Living(Location location){
            this("LIVING TEST COMPONENT", location, new Stats(), new Inventory(20), new Body("GENERIC BODY", new PoofPosition()));
            this.body.living = this;
        }*/
    public boolean isConstruct(){
        return this.construct;
    }
    public Body getBody(){
        return this.body;
    }
    public Inventory getInventory() {
        return this.inventory;
    }
    public void addXp(int xp){
        this.xp += xp;
    }
    public int getLevel(){
        return (int) Math.pow(this.xp, -1/3);
    }
    public double getHeight(){
        return this.height;
    }
    public double getWeight(){
        return this.weight;
    }
    public Sex getSex(){
        return this.sex;
    }
    public Race getRace(){
        return this.race;
    }
    public AdvancedArray<Quirk> getQuirks(){
        return this.quirks;
    }
    public void addQuerck(Quirk quirk){
        this.quirks.add(quirk);
    }
    public int getStrength(){
        return (int) ((this.stats.getStrength(this.getLevel()) + this.race.getStatsBonus().getStrength(this.getLevel())) *
                (this.sex.getStrengthFactor() + this.race.getStrengthFactor() + this.bodyType.getStrengthFactor() + 1.d));
    }
    public int getConstitution(){
        return (int) (this.stats.getConstitution(this.getLevel()) + this.race.getStatsBonus().getConstitution(this.getLevel()) *
                (this.sex.getConstitutionFactor() + this.race.getConstitutionFactor() + this.bodyType.getConstitutionFactor() + 1.d));
    }
    public int getCharisma(){
        return (int) (this.stats.getCharisma(this.getLevel()) + this.race.getStatsBonus().getCharisma(this.getLevel()) *
                (this.sex.getCharismaFactor() + this.race.getCharismaFactor() + this.bodyType.getCharismaFactor() + 1.d));
    }
    public int getAgility(){
        return (int) (this.stats.getAgility(this.getLevel()) + this.race.getStatsBonus().getAgility(this.getLevel()) *
                (this.sex.getAgilityFactor() + this.race.getAgilityFactor() + this.bodyType.getAgilityFactor() + 1.d));
    }
    public int getIntelligence(){
        return (int) (this.stats.getIntelligence(this.getLevel()) + this.race.getStatsBonus().getIntelligence(this.getLevel()) *
                (this.sex.getIntelligenceFactor() + this.race.getIntelligenceFactor() + this.bodyType.getIntelligenceFactor() + 1.d));
    }
    @Override
    public int getLife(){
        return (int) (this.getStrength() * .5 + this.getCharisma() * .2 + this.getConstitution() * .2 + this.getAgility() * .1);
    }
    public int getDodge(){
        return (int) (this.getAgility() * .7 + this.getIntelligence() * .2 + this.getStrength() * .1);
    }
    public int getSkill(){
        return (int) (this.getIntelligence() * .7 + this.getAgility() * .2 + this.getStrength() * .1);
    }
    public int getDefense(){
        return (int) (this.getStrength() * .4 + this.getAgility() * .3 + this.getConstitution() * .3);
    }
    public int getResistance(){
        return (int) (this.getConstitution() * .8 + this.getCharisma() * .2);
    }
    public abstract void tickPathing();
}
