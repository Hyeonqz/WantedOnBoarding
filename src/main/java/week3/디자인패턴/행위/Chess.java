package week3.디자인패턴.행위;

import week3.디자인패턴.구조.Facade.Game;

public class Chess extends Game {

    @Override
    protected void initalize() {
        System.out.println("체스 게임 초기화");
    }

    @Override
    protected void startPlay() {
        System.out.println("체스 게임 시작");
    }

    @Override
    protected void endPlay() {
        System.out.println("체스 게임 종료");
    }
}
