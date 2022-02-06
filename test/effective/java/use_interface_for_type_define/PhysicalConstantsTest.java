package effective.java.use_interface_for_type_define;

import org.junit.Test;

import static org.junit.Assert.*;

public class PhysicalConstantsTest {
    @Test
    public void 아보가드로_수_테스트() {
        assertEquals(PhysicalConstants.AVOGADROS_NUMBER, 6.022140857e23, 0.0001);
    }
}