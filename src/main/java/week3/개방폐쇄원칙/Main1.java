package week3.개방폐쇄원칙;

public class Main1 {
    public static void main(String[] args) {
        Barista barista = new BaristaImpl();

        barista.makeCoffee();

        CoffeeMachine coffeeMachine = new CoffeeMachineImpl();
        barista.userCoffeeMachine(coffeeMachine);

        HandDrip handDrip = new HandDripImpl();
        barista.userHandDrip(handDrip);
    }
}
