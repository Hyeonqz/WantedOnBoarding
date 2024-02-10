package week3.디자인패턴.행위;

public class Football extends Game{
    @Override
    protected void initialize() {
        System.out.println("풋볼게임 초기화");
    }

    @Override
    protected void startPlay() {
        System.out.println("풋볼게임 시작");
    }

    @Override
    protected void endPlay() {
        System.out.println("풋볼게임 종료");
    }
}
