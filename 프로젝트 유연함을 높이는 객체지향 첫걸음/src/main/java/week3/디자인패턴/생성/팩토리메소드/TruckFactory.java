package week3.디자인패턴.생성.팩토리메소드;

import week3.디자인패턴.생성.단순팩토리.Truck;
import week3.디자인패턴.생성.단순팩토리.Vehicle;

public class TruckFactory extends VehicleFactory1 {

    @Override
    public Vehicle getVehicle() {
        return new Truck();
    }
}
