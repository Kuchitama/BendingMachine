
public enum Drink {
	COKE("コーラ", 120),
	;
	
	private String name;
	private int price;
	
	private Drink(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
}
