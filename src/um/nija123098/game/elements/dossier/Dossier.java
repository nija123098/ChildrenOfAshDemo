package um.nija123098.game.elements.dossier;

import basicjavautillibrary.um.nija123098.general.AdvancedArray;
import um.nija123098.game.elements.NamedObject;
import um.nija123098.game.elements.dossier.qualities.BodyType;
import um.nija123098.game.elements.dossier.qualities.Quirk;
import um.nija123098.game.elements.dossier.qualities.Sex;
import um.nija123098.game.elements.dossier.qualities.Stats;
import um.nija123098.game.elements.dossier.qualities.race.Race;
import um.nija123098.game.elements.level.Level;
import um.nija123098.resorce.Rand;

/**
 * Made by Dev on 2/13/2016
 */
public class Dossier extends NamedObject {
    private int level;
    private double height;
    private double weight;
    private Sex sex;
    private Race race;
    private Stats stats;
    private BodyType bodyType;
    private AdvancedArray<Quirk> quirks;
    public Dossier(String name, int level, int height, int weight, Sex sex, Race race, Stats stats, BodyType bodyType, Quirk...quirks){
        super(name + " Dossier");
        this.level = level;
        this.height = height;
        this.weight = weight;
        this.sex = sex;
        this.race = race;
        this.stats = stats;
        this.bodyType = bodyType;
        this.quirks = new AdvancedArray<Quirk>(quirks);
    }
    public Dossier(String name, int level, Race race, Stats stats, Quirk...quirks){
        super(name);
        this.level = level;
        this.race = race;
        this.sex = this.race.getPossibleSexes().getRandom();
        this.bodyType = this.race.getPossibleBodyTypes(this.sex).getRandom();
        this.height = this.race.getHeightRange(this.sex, this.bodyType).getRandom();
        this.weight = this.race.getWeightRange(this.sex, this.bodyType).getRandom();
        this.stats = stats;
        this.quirks = new AdvancedArray<Quirk>(quirks);
    }
    public void levelUp(){
        ++this.level;
    }
    public int getLevel() {
        return this.level;
    }
    public double getHeight() {
        return this.height;
    }
    public double getWeight() {
        return this.weight;
    }
    public Sex getSex() {
        return this.sex;
    }
    public Race getRace() {
        return this.race;
    }
    public AdvancedArray<Quirk> getQuirks() {
        return this.quirks;
    }
    public void addQuerck(Quirk quirk){
        this.quirks.add(quirk);
    }
    public int getStrength(){
        return (int) ((this.stats.getStrength(this.level) + this.race.getStatsBonus().getStrength(this.level)) *
                (this.sex.getStrengthFactor() + this.race.getStrengthFactor() + this.bodyType.getStrengthFactor() + 1.d));
    }
    public int getConstitution(){
        return (int) (this.stats.getConstitution(this.level) + this.race.getStatsBonus().getConstitution(this.level) *
                (this.sex.getConstitutionFactor() + this.race.getConstitutionFactor() + this.bodyType.getConstitutionFactor() + 1.d));
    }
    public int getCharisma(){
        return (int) (this.stats.getCharisma(this.level) + this.race.getStatsBonus().getCharisma(this.level) *
                (this.sex.getCharismaFactor() + this.race.getCharismaFactor() + this.bodyType.getCharismaFactor() + 1.d));
    }
    public int getAgility(){
        return (int) (this.stats.getAgility(this.level) + this.race.getStatsBonus().getAgility(this.level) *
                (this.sex.getAgilityFactor() + this.race.getAgilityFactor() + this.bodyType.getAgilityFactor() + 1.d));
    }
    public int getIntelligence(){
        return (int) (this.stats.getIntelligence(this.level) + this.race.getStatsBonus().getIntelligence(this.level) *
                (this.sex.getIntelligenceFactor() + this.race.getIntelligenceFactor() + this.bodyType.getIntelligenceFactor() + 1.d));
    }
    //
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
}
