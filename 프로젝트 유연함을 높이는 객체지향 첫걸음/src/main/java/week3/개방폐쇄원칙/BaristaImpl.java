package week3.개방폐쇄원칙;

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
