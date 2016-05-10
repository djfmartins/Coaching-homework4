package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {

    private Range range;
    private Sensor sensor;

    private boolean alarmOn = false;

    public static Alarm createPressureAlarm() {
        final double LowPressureThreshold = 17;
        final double HighPressureThreshold = 21;

        return new Alarm(
            new PressureSensor(),
            LowPressureThreshold,
            HighPressureThreshold
        );
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

    private double probeValue() {
        return sensor.probeValue();
    }
}
