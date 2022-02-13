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

### 클래스 계층구조로 변환
- 계층구조의 루트가 될 추상 클래스를 정의하고, 태그 값에 따라 동작이 달라지는 메서드들을 루트 클래스의 추상 메서드로 선언한다.
- 태그 값에 상관없이 동작이 일정한 메서드들을 루트 클래스에 일반 메서드로 추가한다.
- 모든 하위 클래스에서 공통으로 사용하는 데이터 필드들도 전부 루트 클래스로 올린다.
- 루트 클래스를 확장한 구체 클래스를 의미별로 하나씩 정의한다.
- 각 하위 클래스에 각자의 의미에 해당하는 데이터 필드들을 넣는다.

```java
package effective.java.use_class_hierarchy_structure;

abstract class Figure {
    abstract double area(); // 공통이 되는 추상 메서드
}

class Circle extends Figure {
    final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * (radius * radius);
    }
}

class Rectangle extends Figure {
    final double length;
    final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}
```

### 정사각형이 추가가 된다면?

```java
class Square extends Rectangle {
    Square(double side) {
        super(side, side);
    }
}
```

- 간단하게 추가가 되었다.

### 핵심 정리
- 태그 달린 클래스를 써야 하는 상황은 거의 없다.
- 만약 보인다면 계층구조로 대체하는 방법을 생각해보자.
