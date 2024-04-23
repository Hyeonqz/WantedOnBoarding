package week3.디자인패턴.생성;

import week3.디자인패턴.생성.단순팩토리.Truck;
import week3.디자인패턴.생성.단순팩토리.Vehicle;
import week3.디자인패턴.생성.단순팩토리.VehicleFactory;
import week3.디자인패턴.생성.팩토리메소드.CarFactory;
import week3.디자인패턴.생성.팩토리메소드.TruckFactory;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new CarFactory().getVehicle();
        car.drive();

        Vehicle truck = new TruckFactory().getVehicle();
        truck.drive();
    }
}
