package product;

public class Snack extends Product {
	private String company;

	public Snack(String name, int price, String company) {
		super(name, price);
		this.company = company;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}
