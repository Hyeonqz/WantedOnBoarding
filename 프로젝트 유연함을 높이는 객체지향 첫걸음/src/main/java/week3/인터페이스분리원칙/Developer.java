package week3.인터페이스분리원칙;

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
