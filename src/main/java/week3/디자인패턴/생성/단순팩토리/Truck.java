package week3.디자인패턴.생성.단순팩토리;

public class Truck implements Vehicle{
    @Override
    public void drive() {
        System.out.println("트럭을 운전합니다.");
    }
}
