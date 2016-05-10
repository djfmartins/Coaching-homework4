import org.junit.Test;
import tddmicroexercises.tirepressuremonitoringsystem.Alarm;
import tddmicroexercises.tirepressuremonitoringsystem.PressureSensor;

import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AlarmTest {
    @Test
    public void alarm_is_on_when_pressure_is_too_low() {
        PressureSensor pressureSensor = sensorWithPressure(5.0);


        Alarm alarm = new Alarm(pressureSensor, 10, 20);
        alarm.check();
        assertThat(alarm.isAlarmOn(), is(true));
    }

    @Test
    public void alarm_is_on_when_pressure_is_too_high() {
        PressureSensor pressureSensor = sensorWithPressure(50.0);


        Alarm alarm = new Alarm(pressureSensor, 20, 40);
        alarm.check();
        assertThat(alarm.isAlarmOn(), is(true));
    }

    @Test
    public void alarm_is_of_when_pressure_is_inside_range() {
        PressureSensor pressureSensor = sensorWithPressure(20.0);

        Alarm alarm = new Alarm(pressureSensor, 19, 21);
        alarm.check();
        assertThat(alarm.isAlarmOn(), is(false));
    }

    private PressureSensor sensorWithPressure(double pressure) {
        PressureSensor pressureSensor = mock(PressureSensor.class);
        doReturn(pressure).when(pressureSensor).probeValue();
        return pressureSensor;
    }
}
