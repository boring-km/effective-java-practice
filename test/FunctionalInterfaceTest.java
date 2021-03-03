import basic.Calculation;
import basic.FpCalculationService;
import org.junit.Test;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class FunctionalInterfaceTest {
    @Test
    public void 함수형_인터페이스를_사용해_12와_8을_sum_하면_20이다() {
        final FpCalculationService fpCounterService = new FpCalculationService();
        final Calculation calculation = Integer::sum;
        int result = fpCounterService.sum(calculation, 12, 8);
        int expected = 20;
        assertEquals(expected, result);
    }

    @Test
    public void Function을_사용해_array의_평균을_구할_수_있다() {
        final Function<int[], OptionalDouble> average = array -> Arrays.stream(array).average();
        final double result = average.apply(new int[]{1, 2, 3}).getAsDouble();
        double expected = 2;
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void 함수형_인터페이스의_identity는_자기자신을_가리킨다() {
        final Function<Integer, Integer> identity = Function.identity();
        final Function<Integer, Integer> chooseMyself = t -> t;
        int expected = 100;
        int identityResult = identity.apply(100);
        int chooseMyselfResult = chooseMyself.apply(100);
        assertEquals(expected, identityResult);
        assertEquals(expected, chooseMyselfResult);
    }
}
