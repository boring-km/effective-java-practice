package effective.java.comparable;

import java.util.Comparator;

public class ComparableTest {
    public static void main(String[] args) {

    }

    static Comparator<Object> hashCodeOrder = Comparator.comparingInt(Object::hashCode);
}
