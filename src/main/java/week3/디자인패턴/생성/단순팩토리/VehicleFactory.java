package week3.디자인패턴.생성.단순팩토리;

import lombok.val;

//팩토리 클래스 -> 즉 메인 공장 이다.
//공장에서는 여러가지 기계를 돌린다.
//여기서 생성한 인스턴스 들이 기계들이다.
public class VehicleFactory {
    public Vehicle getVehicle(String vehicleType) {
        switch (vehicleType) {
            case "car":
                return new Car();
            case "truck" :
                return new Truck();
            default:
                throw new IllegalArgumentException("Unknowns");
        }

    }

    //클라이언트 코드
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();

        Vehicle car = factory.getVehicle("car");
        car.drive();

        Vehicle truck = factory.getVehicle("truck");
        truck.drive();
    }
}

