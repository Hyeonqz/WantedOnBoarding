package week1.coupling.high;

public class HighCouplingMain {
	public static void main(String[] args) {
		HighCouplingClass highCouplingInstance = new HighCouplingClass();
		AnotherCoupling anotherHighCouplingInstance =
			new AnotherCoupling(highCouplingInstance);

		System.out.println(anotherHighCouplingInstance.getData());
	}
}