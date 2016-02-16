package um.nija123098.game.elements.dossier.qualities.race;

import basicjavautillibrary.um.nija123098.general.AdvancedArray;
import basicjavautillibrary.um.nija123098.math.algibra.Range;
import um.nija123098.game.elements.body.Body;
import um.nija123098.game.elements.dossier.qualities.BodyType;
import um.nija123098.game.elements.dossier.qualities.Quirk;
import um.nija123098.game.elements.dossier.qualities.Sex;
import um.nija123098.game.elements.dossier.qualities.Stats;

/**
 * Made by Dev on 2/13/2016
 */
public abstract class Race {
    private double strengthFactor;
    private double constitutionFactor;
    private double charisma;
    private double agilityFactor;
    private double intelligenceFactor;
    public Stats bonusStats;
    public Race(double strengthFactor, double constitutionFactor, double charisma, double agilityFactor, double intelligenceFactor, Stats bonusStats){
        this.strengthFactor = strengthFactor;
        this.constitutionFactor = constitutionFactor;
        this.charisma = charisma;
        this.agilityFactor = agilityFactor;
        this.intelligenceFactor = intelligenceFactor;
        this.bonusStats = bonusStats;
    }
    public double getStrengthFactor() {
        return this.strengthFactor;
    }
    public double getConstitutionFactor() {
        return this.constitutionFactor;
    }
    public double getCharismaFactor() {
        return this.charisma;
    }
    public double getAgilityFactor() {
        return this.agilityFactor;
    }
    public double getIntelligenceFactor() {
        return this.intelligenceFactor;
    }
    public Stats getStatsBonus(){
        return this.bonusStats;
    }
    public abstract Body getBody(Sex sex, BodyType bodyType);
    public abstract AdvancedArray<Quirk> getQuirks();
    public abstract Range getHeightRange(Sex sex, BodyType bodyType);
    public abstract Range getWeightRange(Sex sex, BodyType bodyType);
    public abstract AdvancedArray<Sex> getPossibleSexes();
    public abstract AdvancedArray<BodyType> getPossibleBodyTypes(Sex sex);
    // I have no idea why sex would be passed as a parameter
}
