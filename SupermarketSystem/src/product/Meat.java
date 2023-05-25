package product;

public class Meat extends Product {
	private String origin;
	
	public Meat(String name, int price, String origin) {
		super(name, price);
		this.origin = origin;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
}
