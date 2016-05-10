import org.junit.Test;
import tddmicroexercises.tirepressuremonitoringsystem.Alarm;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AlarmTest {
    @Test
    public void alarm_is_on_when_pressure_is_too_low() {
        Alarm alarm = new FakeAlarm(10);

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }

    public class FakeAlarm extends Alarm {
        double pressureValue;
        public FakeAlarm(double pressureValue) {
            this.pressureValue = pressureValue;
        }

        @Override
        protected double obtainPressureValue() {
            return pressureValue;
        }
    }
}
