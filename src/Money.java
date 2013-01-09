
public enum Money {
	COIN1(1),
	COIN5(5),
	COIN10(10),
	COIN50(50),
	COIN100(100),
	COIN500(500),
	BILL1000(1000);
	
	private int value;
	
	private Money(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
}
