package product;

public class Drink extends Product {
	private int capacity;

	public Drink(String name, int price, int capacity) {
		super(name, price);
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
