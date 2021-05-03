package effective.java.unnecessary_object_creation;

import java.util.regex.Pattern;

public class RomanNumerals {

    public static boolean isRomanNumeral(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})" +
                "X([CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    private static final Pattern ROMAN = Pattern.compile(
            "^(?=.)M*(C[MD]|D?C{0,3})" +
                    "X([CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    public static boolean isRomanNumeralByPattern(String s) {
        return ROMAN.matcher(s).matches();
    }
}
