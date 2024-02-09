package week3.인터페이스분리원칙;

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
