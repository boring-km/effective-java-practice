package effective.java.unnecessary_object_creation;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumeralsTest {

    @Test
    public void isRomanNumeralTest() {
        String ten = "X";

        boolean result = RomanNumerals.isRomanNumeral(ten);
        boolean resultByPattern = RomanNumerals.isRomanNumeralByPattern(ten);

        assertTrue(result);
        assertTrue(resultByPattern);
    }

    @Test
    public void Pattern을_사용하면_isRomanNumeral의_실행시간은_10배_이상_줄어든다() {
        String ten = "X";
        long start = System.nanoTime();
        RomanNumerals.isRomanNumeral(ten);
        long afterIsRomanNumeral = System.nanoTime();
        RomanNumerals.isRomanNumeralByPattern(ten);
        long afterIsRomanNumeralByPattern = System.nanoTime();

        long normalTime = afterIsRomanNumeral - start;
        long patternTime = afterIsRomanNumeralByPattern - afterIsRomanNumeral;

        assertTrue(normalTime > patternTime * 10);
    }
}