# 아이템 23. 태그 달린 클래스보다는 클래스 계층구조를 활용하라

- 현재 표현하는 의미를 태그값으로 알려주는 원과 사각형을 표현하는 클래스 예시

```java
package effective.java.use_class_hierarchy_structure;

public class Figure {
    enum Shape { RECTANGLE, CIRCLE };

    final Shape shape;

    double length;
    double width;
    double radius;

    public Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    public Figure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError(shape);
        }
    }
}
```

- 열거 타입 선언, 태그 필드, switch 문 등 쓸데없는 코드가 많다.
- 여러 구현이 한 클래스에 혼합되어 있어서 가독성도 나쁘다.
- 다른 의미를 위한 코드도 언제나 함께 하니 메모리도 많이 사용한다.
- 이외에도 여러 문제가 많은데, 한마디로, **태그 달린 클래스는 장황하고, 오류를 내기 쉽고, 비효율적이다.**

