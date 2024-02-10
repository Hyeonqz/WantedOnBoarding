package week3.디자인패턴.구조.Facade

import week3.디자인패턴.구조.Composite.Animal
import week3.디자인패턴.구조.Composite.AnimalGroup

class das {
}

abstract class Game {
    public fun play() {
        initalize()
        startPlay()
        endPlay()
    }

    protected abstract fun initalize()
    protected abstract fun startPlay()
    protected abstract fun endPlay()
}