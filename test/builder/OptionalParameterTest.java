package builder;

import effective.java.builder.NutritionFactsWithBeans;
import effective.java.builder.NutritionFactsWithBuilder;
import effective.java.builder.NutritionFactsWithConstructor;
import org.junit.Before;
import org.junit.Test;

public class OptionalParameterTest {

    private int servingSize;
    private int servings;
    private int calories;
    private int fat;
    private int sodium;
    private int carbohydrate;

    @Before
    public void init() {
        servingSize = 240;
        servings = 8;
        calories = 100;
        fat = 35;
        sodium = 27;
    }

    @Test
    public void 생성자를_이용해_선택적_매개변수_구현() {
        // 생성자의 각 매개변수 위치가 어떤 값을 의미하는지 알아야 한다.
        NutritionFactsWithConstructor nutrition1 = new NutritionFactsWithConstructor(servingSize, servings);
        NutritionFactsWithConstructor nutrition2 = new NutritionFactsWithConstructor(servingSize, servings, calories);
        NutritionFactsWithConstructor nutrition3 = new NutritionFactsWithConstructor(servingSize, servings, calories, fat);
        NutritionFactsWithConstructor nutrition4 = new NutritionFactsWithConstructor(servingSize, servings, calories, fat, sodium);
    }

    @Test
    public void 자바빈즈_패턴을_이용해_선택적_매개변수_구현() {
        NutritionFactsWithBeans nutrition = new NutritionFactsWithBeans();
        // set 메서드를 매개변수마다 일일이 설정하다보면 객체가 현재 어떤상태일지 알 수 없어 일관성이 없어진다.
        nutrition.setServingSize(servingSize);
        nutrition.setServings(servings);
    }

    @Test
    public void 빌더_패턴을_이용해_선택적_매개변수_구현() {
        // 필수 값은 빌더 클래스의 생성자로 만들고 나머지 변수는 참조 연산자로 설정한다.
        // 읽기 쉽다.
        NutritionFactsWithBuilder nutrition = new NutritionFactsWithBuilder.Builder(servingSize, servings)
                .calories(calories)
                .fat(fat)
                .sodium(sodium)
                .build();
    }
}
