package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;

    private Range range;
    private Sensor sensor;

    private boolean alarmOn = false;

    public Alarm() {
        this.sensor = new PressureSensor();
        this.range = new Range(LowPressureThreshold, HighPressureThreshold);
    }

    public Alarm(Sensor sensor, double low, double high) {
        this.sensor = sensor;
        this.range = new Range(low, high);
    }

    public void check() {
        double probeValue = probeValue();

        activateAlarm(probeValue);
    }

    private void activateAlarm(double probeValue) {
        if (!range.contains(probeValue)) {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }

    protected double probeValue() {
        return sensor.probeValue();
    }
}
