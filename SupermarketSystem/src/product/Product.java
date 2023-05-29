package product;

public abstract class Product {
	private String name; // 상품 이름
	private int price; // 상품 가격

	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public abstract String productInfo(); // 상품 정보 출력

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