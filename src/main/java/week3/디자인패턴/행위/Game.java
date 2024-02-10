package week3.디자인패턴.행위;

public abstract class Game {

    public void play() {
        initialize();
        startPlay();
        endPlay();
    }

    protected abstract void initialize();
    protected abstract void startPlay();
    protected abstract void endPlay();
}
