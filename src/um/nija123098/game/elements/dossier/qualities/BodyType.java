package um.nija123098.game.elements.dossier.qualities;

/**
 * Made by Dev on 2/14/2016
 */
public enum BodyType {
    ATHLETIC(.1d, 0.d, -.05d, .2d, 0.d),
    BURLY(.2d, .1d, 0.d, -.05d, 0.d),// note same as male factors
    THICK(.1d, 0.d, 0.d, -.05d, .2d),
    NORMAL(.05d, .05d, .05d, .05d, .05d);
    private double strengthFactor, constitutionFactor, charismaFactor, agilityFactor, intelligenceFactor;
    BodyType(double strengthFactor, double constitutionFactor, double charismaFactor, double agilityFactor, double intelligenceFactor){
        this.strengthFactor = strengthFactor;
        this.constitutionFactor = constitutionFactor;
        this.charismaFactor = charismaFactor;
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
        return this.charismaFactor;
    }
    public double getAgilityFactor() {
        return this.agilityFactor;
    }
    public double getIntelligenceFactor() {
        return this.intelligenceFactor;
    }
}
