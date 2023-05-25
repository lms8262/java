package product;

public class Fish extends Product {
	private String origin;

	public Fish(String name, int price, String origin) {
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
