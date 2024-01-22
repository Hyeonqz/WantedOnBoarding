package week1.abstract1;

import java.time.LocalDateTime;

class Barista {
	private CoffeeMaker determineCoffeeMaker(LocalDateTime now) {
		return now.getHour() < 8 || now.getHour() > 20 ? new CoffeeMachine() : new HandDrip();
	}
	public Coffee makeCoffee(LocalDateTime now, String coffeeType) {
		return determineCoffeeMaker(now).makeCoffee(coffeeType);
	}
}

interface CoffeeMaker {
	Coffee makeCoffee(String coffeeType);
}

class CoffeeMachine implements CoffeeMaker {
	@Override
	public Coffee makeCoffee(String coffeeType) {
		System.out.println("커피머신이 " + coffeeType + " 커피를 만드는 중입니다.");
		return new Coffee(coffeeType);
	}
}

class HandDrip implements CoffeeMaker {
	@Override
	public Coffee makeCoffee(String coffeeType) {
		System.out.println("핸드드립으로 " + coffeeType + " 커피를 만드는 중입니다.");
		return new Coffee(coffeeType);
	}
}

class Coffee {
	private final String name;
	public Coffee(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}

public class Main2{
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		Barista barista = new Barista();
		Coffee coffee = barista.makeCoffee(now, "아메리카노");
		System.out.println(coffee.getName());
	}
}
