import basic.Calculation;
import basic.FpCalculationService;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.function.*;

import static org.junit.Assert.*;

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

    @Test
    public void Predicate_인터페이스로_test_하려는_값의_조건을_판단하여_boolean_형태로_반환한다() {
        final Predicate<Integer> isPositive = i -> i > 0;
        assertTrue(isPositive.test(10));
        assertFalse(isPositive.test(-100));

        final BiPredicate<String, String> isLonger = (s1, s2) -> s1.length() > s2.length();
        assertTrue(isLonger.test("1234567", "12345"));
        assertFalse(isLonger.test("나는 진강민이다", "정말로 정신을 차리고 다시 기본을 다져야한다."));
    }

    @Test
    public void Consumer는_리턴이_없는_형태로_추상메서드_accept을_사용한다() {
        final Consumer<String> print = System.out::println;
        print.accept("나는");
        print.accept("절박하게");
        print.accept("공부를 한다.");

        final Consumer<String> printTime = System.out::println;
        final Consumer<String> mergedPrint = printTime.andThen(print);
        mergedPrint.accept(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
    }

    @Test
    public void Supplier는_파라미터가_없는_형태이며_추상메서드_get을_사용한다() {
        final Supplier<String> supplier = () -> "정신을 똑바로 차리자";
        String result = supplier.get();
        assertEquals("정신을 똑바로 차리자", result);
    }
}
