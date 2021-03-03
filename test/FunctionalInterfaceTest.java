import basic.Calculation;
import basic.FpCounterService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FunctionalInterfaceTest {
    @Test
    public void 함수형_인터페이스를_사용해_12와_8을_sum_하면_20이다() {
        final FpCounterService fpCounterService = new FpCounterService();
        final Calculation counter = Integer::sum;
        int result = fpCounterService.sum(counter, 12, 8);
        int expected = 20;
        assertEquals(expected, result);
    }
}
