package week1;

// 커피를 만드는 바리스타를 나타내는 클래스
class Barista {
	private String name;
	private String coffeeType;

	public Barista(String name, String coffeeType) {
		this.name = name;
		this.coffeeType = coffeeType;
	}
	public void makeCoffee() {
		System.out.println(this.name + "님이 " + this.coffeeType + " 커피를 만듭니다.");
	}
}
// 커피를 주문하는 고객을 나타내는 클래스
class Customer {
	private String name;
	public Customer(String name) {
		this.name = name;
	}

	public void orderCoffee(Barista barista, String coffeeType) {
		barista.makeCoffee();
	}
}

// 메인 클래스
public class CoffeeShop {

	public static void main(String[] args) {
		Barista barista = new Barista("바리스타", "아메리카노");
		Customer customer = new Customer("고객");

		customer.orderCoffee(barista, "아메리카노");
	}
}
