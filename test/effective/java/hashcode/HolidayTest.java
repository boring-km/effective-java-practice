package effective.java.hashcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class HolidayTest {
    @Test
    public void hashCode를_재정의하지_않고_2개의_동일한_인스턴스를_비교하면_같지_않다() {
        Map<Holiday, String> holidayMap = new HashMap<>();
        String expected = "삼일절";
        holidayMap.put(new Holiday(3, 1), expected);

        String actual = holidayMap.get(new Holiday(3, 1));

        assertNotEquals(expected, actual);
    }
}