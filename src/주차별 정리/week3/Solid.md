## Solid : 객체지향 설계 원칙

오늘은 Solid원칙 에 대해서 알아볼 것 입니다.<br>
주니어 개발자인 저한테 Solid원칙까지 신경쓰면서 코드를 짜고, 고민하는 것은 너무 힘들다고 생각합니다<br>

그럼에도 불구하고 시니어 개발자들이 SOLID을 이야기를 가끔 하고는 합니다

왜 알아야하고, 어떻게 적용을 해야할지에 대한 고민을 항상 하고는 합니다.

그러면 왜 SOLID원칙을 지켜야하고 왜 알고 사용해야 할까요?

답은 꽤나 간단하고, 명쾌한 답이 예~~전부터 나와있습니다 바로
- 가독성
- 확장성
- 재사용성
- 유지보수성

을 향상시키는데 도움이 되기 때문입니다.

여러분들도 알다시피, 객체지향에 4가지인, 캡슐화, 상속, 추상화, 다형성 을 활용하면 뭐가 좋을까요?<br>
바로 위 내용하고 똑같을 것입니다.

결국 **객체지향 4가지를 잘 지키기 위해서, SOLID 원칙이 필요한 것** 입니다.

#### 왜 SOLID라고 불릴까요?
바로 아래 5가지 원칙의 앞글자만 딴 용어 이기 때문입니다
1) 단일 책임 원칙
2) 개방 폐쇄 원칙
3) 리스코프 치환 원칙
4) 인터페이스 분리 원칙
5) 의존 역전 원칙

한개씩 봐보겠습니다

### 단일 책임 원칙(SRP)
-> 클래스가 하나의 책임이나 기능만을 담당한다.

기본적으로 작은 단위와 단일 기능을 가진 클래스를 설계 해야한다.<br>
대부분 사람들이 1클래스 1기능 이라고 많이들 이야기를 합니다.<br>

저는 사실 왜 그래야 할까? 라는 의문이 처음에는 들었습니다.<br>

💡 결국 **유지보수** 때문이였습니다.<br>
제가 코드를 딱 짜고 나중에 절대 수정할 일이 없을까요?<br>
정답은 'No' 라고 생각합니다. 분명히 수정할 일이 있을 것 입니다.

#### 그러면 어떤 상황에서 단일책임 원칙을 적용해야할까요??
- 클래스에 속성, 메소드가 많아서 가독성, 유지보수에 어려움을 느낄 때
- 많은 수의 클래스에 의존하는 경우
- 클래스의 이름을 비즈니스 적으로 정확하게 명명할 수 없는 경우
- 응집도가 낮은 경우 => 메소드들이 클래스의 적은 수의 속성만 사용하는 경우

위 내용들은 분명 맞는 내용이긴한데, 결국 설계를 하고 직접 코딩을 하다보면 다 지킬 수는 없을 것이라고 생각합니다<br>
최소한의 지키면서 진행하는 편이 좋은 것 같습니다.

즉 정답은 없다고 생각합니다. 본인 프로젝트 상황에 맞춰가면서 적절하게 사용하는게 좋다고 생각합니다.<br>
ex) 작은 프로젝트는 적용하기 간편하지만, 큰 프로젝트는...힘들 수도 있다

다음으로는 코드로 한번 보겠습니다

```java
public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    
    public void printEmployeeInfo() {
        System.out.println("name = " + name);
        System.out.println("salary = " + salary);
    }
    
    public void saveEmployeeInfoToFile() {
        List<Employee> list = new ArrayList<>();
        //list.add();
        //작원 정보를 파일에 저장 -> 저장 로직
    }
}

```
위 코드를 보면 Employee 클래스는 두 가지 책임을 가지고 있습니다. <br>
하나는 직원 정보를 출력하고, 다른 하나는 직원 정보를 파일에 저장하는 책임 입니다<br>
즉 책임이라 함은, 메소드(=명령)을 의미합니다. 

즉 단일 책임 원칙을 어기고 있습니다. 이를 해결하기 위해서는 두 개의 클래스로 나누는 것이 좋습니다.
- 클래스나 모듈은 하나의 책임만 가져야함
- 클래스가 변경되어야 하는 이유는 단 하나여야만 한다는 것을 의미하기도 합니다. 
```java
public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void printEmployeeInfo() {
        System.out.println("name = " + name);
        System.out.println("salary = " + salary);
    }


}
class EmployeeSaver {
    public void saveEmployeeInfoToFile() {
        List<Employee> list = new ArrayList<>();
        //list.add();
        //작원 정보를 파일에 저장 -> 저장 로직
    }
}
```
즉 이런 식으로 두개의 클래스로 나눠서 책임음 한개로 분산하면 됩니다. 


### 개방 폐쇄 원칙(OCP)
- 확장할 때는 개방, 수정할 때는 폐쇄
- 새로운 기능을 추가할 때 기존의 모듈, 클래스, 함수를 수정하기보다는 기존 코드를 기반으로 모듈 클래스, 
함수 등을 추가하는 방식으로 코드를 확장해야한다.

즉 위 뜻은 인터페이스를 생성하고, 인터페이스를 거쳐서 구현하라는 뜻으로 보입니다. <br>
즉, 항상 열려서 직접 접근할 수 있는게 아닌, 중간에 인터페이스(=문) 을 거쳐서 작동하게 만드는 것 입니다.
![스크린샷 2024-02-09 오후 4.17.16.png](..%2F..%2F..%2F..%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-02-09%20%EC%98%A4%ED%9B%84%204.17.16.png)
즉 위 사진을 보면 손님을 요청을 바리스타가 받고 바리스타가 요청을 할 때 중간 매개체인 CoffeeMaker가 있습니다. <br>
이때 이CoffeeMaker를 직접 거치게하지 않게 하는 것 입니다.

![스크린샷 2024-02-09 오후 4.17.26.png](..%2F..%2F..%2F..%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-02-09%20%EC%98%A4%ED%9B%84%204.17.26.png)
즉 직접적인 접근을 하여 한곳에 메소드가 모여있는 곳에서 호출을 하는게 아닌, 인터페이스를 구현하여<br>
인터페이스인 CoffeeMaker가 그때 그때 요청이 오면 그거에 맞는 구현체로 이동시켜주는 그런 구조 라고 생각하면 됩니다. 

#### 그럼 이렇게 헀을 떄의 장점은 뭐가 있을까요?
- 확장 할때는 확장을 할 수 있고, 수정하 때는 폐쇄를 할 수 있습니다.

그럼 무엇이 **확장**이고, 무엇을 **수정**이라고 볼 수 있을까요?

즉 확장은 새로운 제조 방식을 추가하면 CoffeeMaker인터페이스를 구현하는 새로운 클래스를 만들어 확장할 수 있다<br>
위 방식을 이용하면 Barista, CoffeeMaker를 추가할 수 없다. 

그럼 어떻게 하면 개방 폐쇄 원칙을 지킬 수 있을까요?
- 확장 포인트가 어디인지 이해
- 즉 비즈니스에 대한 충분한 이해가 필요함
- 미래 요구될 기능은 생각하지말고, 현재의 기능에 충실하게 비즈니스 설계를 해야함
- 나중에 추가되는건 그때 그때 추가하고, 리팩토링을 하는게 나을수 있다

물론 이 내용이 정답은 아니긴하다. 이렇게 하는게 좋다 정도로 이해하면 될 것 같습니다

이제 코드를 통해 이해를 도와보겠습니다. 
```java
public interface Barista {
    void makeCoffee();
    void userCoffeeMachine(CoffeeMachine coffeeMachine);
    void userHandDrip(HandDrip handDrip);
}

```
```java
public class BaristaImpl implements Barista{
    @Override
    public void makeCoffee() {
        System.out.println("직접 커피를 만듭니다");
    }

    @Override
    public void userCoffeeMachine(CoffeeMachine coffeeMachine) {
        System.out.println("커피머신을 사용하여 커피를 만듭니다");
        coffeeMachine.makeCoffee(4);
    }

    @Override
    public void userHandDrip(HandDrip handDrip) {
        System.out.println("핸드드립으로 만듭니다.");
        handDrip.makeCoffee(5);
    }
}

```

```java
public interface CoffeeMachine {
    void makeCoffee(int amount);
}
```

```java
public class CoffeeMachineImpl implements CoffeeMachine{
    @Override
    public void makeCoffee(int amount) {
        System.out.println("커피머신이 " + amount + "잔의 커피를 만듭니다.");
    }
}

```

```java
public interface HandDrip {
    void makeCoffee(int amount);
}
```

```java
public class HandDripImpl implements HandDrip{
    @Override
    public void makeCoffee(int amount) {
        System.out.println("핸드드립으로 " + amount + "잔의 커피를 만듭니다");
    }
}

```

```java
package week3.개방폐쇄원칙;

public class Main1 {
    public static void main(String[] args) {
        Barista barista = new BaristaImpl();

        barista.makeCoffee();

        CoffeeMachine coffeeMachine = new CoffeeMachineImpl();
        barista.userCoffeeMachine(coffeeMachine);

        HandDrip handDrip = new HandDripImpl();
        barista.userHandDrip(handDrip);
    }
}

```
즉 개방 페쇄 원칙은 객체지향에서 다형성과 관련이 있습니다. 잘 이해가 안되신다면 다형성에 대해서<br>
학습 후 보시면 이해가 더 잘될 것이라고 생각합니다. 


### 리스코프 치환 원칙(LSP)
- 상위 타입의 객체를 하위 타입의 객체로 치환해도 상위 타입을 사용하는 프로그램은 정상적으로 동작해야함

1) 계약에 따른 설계
2) 상위 클래스에서 선언한 대로 기능이 동작
3) 입력, 출력 예외 모두 상위 클래스르 따른다.
4) 상위 클래스의 특별 지침을 모두 준수한다. 

대표적인 예시로 Circle Ellipse Problem 이 있습니다.<br.
한번 코드로 봐보겠습니다
```java
// 도형을 나타내는 인터페이스
interface Shape {
    double calculateArea();
}

// Ellipse 클래스 구현
class Ellipse implements Shape {
    private double majorAxis;
    private double minorAxis;

    public Ellipse(double majorAxis, double minorAxis) {
        this.majorAxis = majorAxis;
        this.minorAxis = minorAxis;
    }

    @Override
    public double calculateArea() {
        return Math.PI * majorAxis * minorAxis;
    }
}

// Circle 클래스 구현
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
```
이 내용은 결국, 각각의 특성 때문에 서로 대체될 수 없는 상황이 발생함을 의미합니다.<br>
원래는 Circle이 Ellipse의 서브클래스로 정의되지만, 이것이 문제를 일으킬 수 있는 가장 일반적인 예시 중 하나입니다.<br>
왜냐하면 Circle은 동일한 가로축과 세로축을 가진 정확한 크기의 원이어야 하지만, <br>
Ellipse는 서로 다른 크기의 가로축과 세로축을 가질 수 있기 때문입니다.<br>

이러한 문제를 해결하는 방법 중 하나는 Circle과 Ellipse를 상속 관계에서 벗어나게 하는 것입니다. <br>
대신, Circle과 Ellipse는 독립적인 클래스로 구현하고 공통적으로 사용되는 <br>
인터페이스나 추상 클래스를 도입하여 공통 기능을 추출할 수 있습니다<br>

여기서 헷갈릴 수 있는 개념은 다형성 인데, <br>
저도 아직 크게 와닿지는 않지만,
- 리스코프 치환원칙 : 상속 관계에서 하위 클래스의 설계 방식을 설명하는 설계
- 다형성 : 코드를 구현하는 방식

이런 차이가 있다고 합니다. 사실 이 내용에 대해서는 더 공부를 해봐야지 알 것 같습니다

### 인터페이스 분리 원칙(ISP)
- 클라이언트는 자신이 사용하는 메소드에만 의존해야 한다.
- 즉 클라이언트는 자신이 사용하지 않는 메소드에는 의존하면 안된다.
- 하나에 인터페이스에 여러가지 메소드 보다는, 여러개의 인터페이스에 구체적인 메소드가 있는게 낫다

직접 코드로 보겠습니다.
```java
public interface Worker {
    void work();
    void eat();
}

public class Developer implements Worker{
    @Override
    public void work() {
        System.out.println("일한다");
    }

    @Override
    public void eat() {
        System.out.println("점심 타임");
    }
}

public class AI implements Worker{
    @Override
    public void work() {
        System.out.println("일한다");
    }

    @Override
    public void eat() {
        //로봇은 밥을 먹지 않는다 즉 필요가 없다 이 메소드는 
    }
}

```
Worker 인터페이스에 메소드를 선언하고, 구현받는 방식이다<br>
Developer 구현에는 문제가 없다.<br>
그러나 AI는 밥을 먹지 않는다 그러므로 eat() 메소드 구현이 불필요하다 
- 즉 불필요한 의존성을 가진다.

이를 해결하기 위해서는 서로 다른 구현을 하는 인터페이스를 만드는 것이 방법이다.


### 의존 역전 원칙
- **고수준 모듈**은 **저수준 모듈**의 구현에 의존해서는 안 된다.
- 저수준 모듈이 고수준 모듈에서 정의한 추상 타입에 의존해야한다. 

고수준 모듈? => 의미 있는 단일 기능을 제공하는 모듈<br>
저수준 모듈? => 고수준 모듈의 기능을 구현하기 위해 필요한 하위 기능의 실제 구현

이렇게 말로만 보면은 잘 이해가 안될 것이라고 생각합니다. 그러므로 코드로 봐보겠습니다

```java
//하위 모듈
public class HardDrive {
    
    void readData() {
        String read = "데이터 읽기";
        System.out.println(read + "진행");
    }
    
}

//상위 모듈
public class Computer {
    HardDrive hardDrive = new HardDrive();

    void start() {
        hardDrive.readData();
        System.out.println("컴퓨터 시작");
    }
}
```
위 코드는 고수준 모듈이 저수준 모듈에 의존하는 코드 입니다.

위 코드를 사용한다면 무슨 문제가 발생할까요? <br>
- 유연성 부족
- 확장성 문제
- 유지보수의 어려움

만약 위 코드에서 무언가 기능을 하나를 추가한다면?<br>
한번 SSD 객체를 추가해보겠습니다. 
```java
//하위모듈
public class SSD {
    void readData() {
        System.out.println("SSD에서 데이터 읽기");
    }
}
```
SSD를 추가하고 Computer가 시작이 될 때 깉이 시작하게 하려면<br>
Computer 내부 메소드를 수정해야 합니다. <br>
즉 무언가를 추가할 때 마다 상위 모듈이 계속 변동이 되어야 합니다. 엄청 귀찮습니다.<br>

그렇다면 위 문제를 해결하기 위해서는 어떻게 해야할까요?<br>
바로 중간에 인터페이스를 두는 것 입니다. -> **다형성 활용**<br>
![스크린샷 2024-02-09 오후 5.48.05.png](..%2F..%2F..%2F..%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-02-09%20%EC%98%A4%ED%9B%84%205.48.05.png)
위 다이어그램을 보면은 인터페이스를 거쳐서 프로세스가 진행하게 되어있습니다.<br>
즉 중간 단계를 거치면서 상위 모듈에 내부 수정이 필요없게 만드는 것입니다. <br>
직접 코드로 보겠습니다.
```java
//추상화된 인터페이스 (하위 모듈)
public interface StorageDevice {
    void readData(String read);
}

//하위모듈 -> 구체적인 구현체
public class SSD implements StorageDevice{
    @Override
    public void readData() {
        System.out.println("SSD를 읽습니다.");
    }
}

//하위 모듈 -> 구체적인 구현체
public class HardDrive implements StorageDevice{

    @Override
    public void readData() {
        System.out.println("하드 드라이브 데이터를 읽습니다. ");
    }
}

//상위 모듈
public class Computer {
    StorageDevice storageDevice;

    void start() {
        storageDevice.readData();
        System.out.println("컴퓨터를 시작 합니다.");
    }
}
```
위 인터페이스를 추가하여, 중복 작업을 줄여주며, 상위 모듈이 하위 모듈에 직접적인 의존을 하지않게 만들었습니다.














