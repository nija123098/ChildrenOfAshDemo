package um.nija123098.resorce;

import basicjavautillibrary.um.nija123098.math.algibra.Range;

/**
 * Made by Dev on 2/15/2016
 */
public class NotARangeRange implements Range {
    private double value;
    public NotARangeRange(double value){
        this.value = value;
    }
    @Override
    public double getMin() {
        return this.value;
    }
    @Override
    public double getMax() {
        return this.value;
    }
    @Override
    public double probability(double v) {
        return 100;
    }
    @Override
    public double getValueAt(double v) {
        return this.value;
    }
    @Override
    public double getRandom() {
        return this.value;
    }
}
