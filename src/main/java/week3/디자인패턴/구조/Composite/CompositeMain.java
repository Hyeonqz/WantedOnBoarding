package week3.디자인패턴.구조.Composite;

public class CompositeMain {
    public static void main(String[] args) {
        AnimalGroup catGroup = new AnimalGroup();
        catGroup.add(new Cat());
        catGroup.add(new Cat());
        catGroup.add(new Cat());

        AnimalGroup dogGroup = new AnimalGroup();
        dogGroup.add(new Dog());
        dogGroup.add(new Dog());
        dogGroup.add(new Dog());

        AnimalGroup zooGroup = new AnimalGroup();
        zooGroup.add(new Zoo());
        zooGroup.add(dogGroup);
        zooGroup.add(catGroup);

        zooGroup.speak();

    }
}
