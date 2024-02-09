package week3.개방폐쇄원칙;

public class CoffeeMachineImpl implements CoffeeMachine{
    @Override
    public void makeCoffee(int amount) {
        System.out.println("커피머신이 " + amount + "잔의 커피를 만듭니다.");
    }
}
