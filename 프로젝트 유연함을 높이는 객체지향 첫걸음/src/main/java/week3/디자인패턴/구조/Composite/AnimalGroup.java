package week3.디자인패턴.구조.Composite;

import java.util.ArrayList;
import java.util.List;

public class AnimalGroup implements  Animal{

    private List<Animal> animals = new ArrayList<>();

    public void add(Animal animal) {
        animals.add(animal);
    }
    @Override
    public void speak() {
        for(Animal animal : animals) {
            animal.speak();
        }
    }
}
