import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(JUnitParamsRunner.class)
public class BerlinClockTest {

    @Test
    @Parameters({
            "00:00:00, OOOO",
            "23:59:59, YYYY",
            "12:32:00, YYOO",
            "12:34:00, YYYY",
            "12:35:00, OOOO"
    })
    public void shouldCalculateSingleMinutesRow(String time, String expectedMinutesRow) {
        //Given
        BerlinClock bc = new BerlinClock();
        //When
        String singleMinuteRow = bc.getSingleMinutesRow(time);
        //Then
        assertThat(singleMinuteRow).isEqualTo(expectedMinutesRow);
    }

    @Test
    @Parameters({
            "00:00:00, OOOOOOOOOOO",
            "23:59:59, YYRYYRYYRYY",
            "12:04:00, OOOOOOOOOOO",
            "12:23:00, YYRYOOOOOOO",
            "12:35:00, YYRYYRYOOOO"
    })
    public void shouldCalculateFiveMinutesRow(String time, String expectedFiveMinutesRow) {
        //Given
        BerlinClock bc = new BerlinClock();
        //When
        String fiveMinutesRow = bc.getFiveMinutesRow(time);
        //Then
        assertThat(fiveMinutesRow).isEqualTo(expectedFiveMinutesRow);
    }

    @Test
    @Parameters({
            "00:00:00, OOOO",
            "23:59:59, RRRO",
            "02:04:00, RROO",
            "08:23:00, RRRO",
            "14:35:00, RRRR"
    })
    public void shouldCalculateSingleHourRow(String time, String expectedSingleHourRow) {
        //Given
        BerlinClock bc = new BerlinClock();
        //When
        String singleHourRow = bc.getSingleHourRow(time);
        //Then
        assertThat(singleHourRow).isEqualTo(expectedSingleHourRow);
    }

    @Test
    @Parameters({
            "00:00:00, OOOO",
            "23:59:59, RRRR",
            "02:04:00, OOOO",
            "08:23:00, ROOO",
            "16:35:00, RRRO"
    })
    public void shouldCalculateFiveHourRow(String time, String expectedFiveHoursRow) {
        //Given
        BerlinClock bc = new BerlinClock();
        //When
        String fiveHoursRow = bc.getFiveHoursRow(time);
        //Then
        assertThat(fiveHoursRow).isEqualTo(expectedFiveHoursRow);
    }

    @Test
    @Parameters({
            "00:00:00, Y",
            "23:59:59, O"
    })
    public void shouldCalculateSecondsLamp(String time, String expectedSecondsLamp) {
        //Given
        BerlinClock bc = new BerlinClock();
        //When
        String secondsLamp = bc.getSecondsLamp(time);
        //Then
        assertThat(secondsLamp).isEqualTo(expectedSecondsLamp);
    }

    @Test
    @Parameters({
            "00:00:00, YOOOOOOOOOOOOOOOOOOOOOOO",
            "23:59:59, ORRRRRRROYYRYYRYYRYYYYYY",
            "16:50:06, YRRROROOOYYRYYRYYRYOOOOO",
            "11:37:01, ORROOROOOYYRYYRYOOOOYYOO"
    })
    public void shouldCalculateBerlinCloak(String time, String expectedBerlinClock) {
        //Given
        BerlinClock bc = new BerlinClock();
        //When
        String berlinClock = bc.getClock(time);
        //Then
        assertThat(berlinClock).isEqualTo(expectedBerlinClock);
    }
}