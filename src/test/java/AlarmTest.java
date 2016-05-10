import org.junit.Test;
import tddmicroexercises.tirepressuremonitoringsystem.Alarm;
import tddmicroexercises.tirepressuremonitoringsystem.Sensor;

import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AlarmTest {
    @Test
    public void alarm_is_on_when_pressure_is_too_low() {
        Sensor sensor = sensorWithPressure(5.0);

        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertThat(alarm.isAlarmOn(), is(true));
    }

    @Test
    public void alarm_is_on_when_pressure_is_too_high() {
        Sensor sensor = sensorWithPressure(50.0);


        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertThat(alarm.isAlarmOn(), is(true));
    }

    @Test
    public void alarm_is_of_when_pressure_is_inside_range() {
        Sensor sensor = sensorWithPressure(20.0);

        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertThat(alarm.isAlarmOn(), is(false));
    }

    private Sensor sensorWithPressure(double pressure) {
        Sensor sensor = mock(Sensor.class);
        doReturn(pressure).when(sensor).popNextPressurePsiValue();
        return sensor;
    }
}
