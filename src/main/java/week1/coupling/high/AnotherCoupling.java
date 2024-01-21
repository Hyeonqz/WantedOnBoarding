package week1.coupling.high;



public class AnotherCoupling {
	private int data;

	public AnotherCoupling(HighCouplingClass highCouplingClass) {
		this.data = highCouplingClass.getData();
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}
