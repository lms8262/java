package product;

public class Fish extends Product {

	private static final long serialVersionUID = 8257485387493468148L;
	private String origin; // 원산지

	public Fish(String name, int price, String origin) {
		super(name, price);
		this.origin = origin;
	}

	@Override
	public String productInfo() {
		return origin + "|" + super.getName() + "|" + super.getPrice() + "원";
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
		if (!(obj instanceof Fish)) {
			return false;
		}
		Fish target = (Fish) obj;
		return (target.getName().equals(super.getName())) && (target.getPrice() == super.getPrice())
				&& (target.origin.equals(this.origin));
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

}
