package product;

public class Drink extends Product {
	private int capacity; // 음료 용량

	public Drink(String name, int price, int capacity) {
		super(name, price);
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "이름: " + super.getName() + ", 가격: " + super.getPrice() + ", 용량: " + capacity;
	}

	@Override
	public int hashCode() {
		return super.getName().hashCode() + super.getPrice() + capacity;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Drink)) {
			return false;
		}
		Drink target = (Drink) obj;
		return (target.getName().equals(super.getName())) && (target.getPrice() == super.getPrice())
				&& (target.capacity == capacity);
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
