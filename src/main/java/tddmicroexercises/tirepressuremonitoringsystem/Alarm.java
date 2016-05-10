package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;

    private Sensor sensor;

    private boolean alarmOn = false;

    public Alarm() {
        this.sensor = new Sensor();
    }

    public Alarm(Sensor sensor) {
        this.sensor = sensor;
    }

    public void check() {
        double psiPressureValue = obtainPressureValue();

        if (isPressureOutOfRange(psiPressureValue)) {
            alarmOn = true;
        }
    }

    private boolean isPressureOutOfRange(double psiPressureValue) {
        return psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue;
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }

    protected double obtainPressureValue() {
        return sensor.popNextPressurePsiValue();
    }
}
