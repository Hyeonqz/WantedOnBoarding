package week3.개방폐쇄원칙;

class CustomerA {
    public void MakeOrder() {
        // 핸드르립 커피를 요청 로직
    }
}
class Barista{
    CustomerA customerA = new CustomerA();
    customerA.MakeOrder();
}

public  interface CoffeeMaker {
}
