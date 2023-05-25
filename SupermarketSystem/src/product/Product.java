package product;

public abstract class Product {
	private String name; // 상품 이름
	private int price; // 상품 가격

	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "이름: " + name + ", 가격: " + price;
	}

	@Override
	public int hashCode() {
		return name.hashCode() + price;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Product)) {
			return false;
		}
		Product target = (Product) obj;
		return target.name.equals(name) && (target.price == price);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	};

}