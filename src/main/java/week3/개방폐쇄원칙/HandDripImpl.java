package week3.개방폐쇄원칙;

public class HandDripImpl implements HandDrip{
    @Override
    public void makeCoffee(int amount) {
        System.out.println("핸드드립으로 " + amount + "잔의 커피를 만듭니다");
    }
}
