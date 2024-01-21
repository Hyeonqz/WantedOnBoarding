package week1.coupling.low;

public class LowCouplingMain {
	public static void main(String[] args) {
		LowCoupling lowCouplingInstance = new LowCoupling();
		AnotherLowCoupling anotherLowCouplingInstance = new AnotherLowCoupling(lowCouplingInstance.getData());

		System.out.println(anotherLowCouplingInstance.getData());
	}
}
