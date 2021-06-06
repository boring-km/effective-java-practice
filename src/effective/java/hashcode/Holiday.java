package effective.java.hashcode;

import java.util.Objects;

public class Holiday {
    private int month;
    private int day;

    public Holiday(int month, int day) {
        this.month = month;
        this.day = day;
    }

    // 자동 생성된 equals() 사용함
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Holiday holiday = (Holiday) o;
        return month == holiday.month && day == holiday.day;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(month);
        result = 31 * result + Integer.hashCode(day);
        return result;
    }
}
