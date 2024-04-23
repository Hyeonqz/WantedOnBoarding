package week1.coupling.car;

public class Car {
	private int speed;
	private int fuelLevel;

	void accelerate() {
		speed +=1;
	}
	void brake() {
		speed = -1;
	}
	void turnLeft() {
		System.out.println("좌회전 합니다.");
	}
	void turnRight() {
		System.out.println("우회전 합니다.");
	}
}
