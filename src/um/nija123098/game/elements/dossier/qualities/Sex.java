package um.nija123098.game.elements.dossier.qualities;

/**
 * Made by Dev on 2/13/2016
 */
public enum Sex {
    FEMALE(-.05d, 0.d, .1d, .2d, 0.d),
    MALE(.2d, .1d, 0.d, -.05, 0.d),
    NUTER(.05d, .05d, .05d, .05d, .05d);
    private double strengthFactor;
    private double constitutionFactor;
    private double charisma;
    private double agilityFactor;
    private double intelligenceFactor;
    Sex(double strengthFactor, double constitutionFactor, double charisma, double agilityFactor, double intelligenceFactor){
        this.strengthFactor = strengthFactor;
        this.constitutionFactor = constitutionFactor;
        this.charisma = charisma;
        this.agilityFactor = agilityFactor;
        this.intelligenceFactor = intelligenceFactor;
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
}