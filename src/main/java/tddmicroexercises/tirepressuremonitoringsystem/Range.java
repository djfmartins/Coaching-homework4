package tddmicroexercises.tirepressuremonitoringsystem;

public class Range {
    private double low;
    private double high;

    public Range(double low, double high) {
        this.low = low;
        this.high = high;
    }

    public boolean contains(double value) {
        return value <= high && low <= value;
    }
}
