package product;

public class Vegetable extends Product {
	private String origin; // 원산지

	public Vegetable(String name, int price, String origin) {
		super(name, price);
		this.origin = origin;
	}

	@Override
	public String toString() {
		return "이름: " + super.getName() + ", 가격: " + super.getPrice() + ", 원산지: " + origin;
	}

	@Override
	public int hashCode() {
		return super.getName().hashCode() + super.getPrice() + origin.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Vegetable)) {
			return false;
		}
		Vegetable target = (Vegetable) obj;
		return (target.getName().equals(super.getName())) && (target.getPrice() == super.getPrice())
				&& (target.origin.equals(origin));
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

}
