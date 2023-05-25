package supermarket;

public class Product {
	private String name; // 상품 이름
	private String kind; // 상품 종류
	private int price; // 상품 가격

	public Product(String name, String kind, int price) {
		this.name = name;
		this.kind = kind;
		this.price = price;
	}

	@Override
	public String toString() {
		return "이름: " + name + ", 종류: " + kind + ", 가격: " + price;
	}

	@Override
	public int hashCode() {
		return name.hashCode() + kind.hashCode() + price;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Product) {
			Product target = (Product) obj;
			return target.name.equals(name) && target.kind.equals(kind) && (target.price == price);
		} else {
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	};

}