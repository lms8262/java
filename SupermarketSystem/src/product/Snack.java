package product;

public class Snack extends Product {

	private static final long serialVersionUID = 4770757344462807421L;
	private String company; // 제조회사

	public Snack(String name, int price, String company) {
		super(name, price);
		this.company = company;
	}

	@Override
	public String productInfo() {
		return company + "|" + super.getName() + "|" + super.getPrice() + "원";
	}

	@Override
	public String toString() {
		return "이름: " + super.getName() + ", 가격: " + super.getPrice() + ", 제조회사: " + company;
	}

	@Override
	public int hashCode() {
		return super.getName().hashCode() + super.getPrice() + company.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Snack)) {
			return false;
		}
		Snack target = (Snack) obj;
		return (target.getName().equals(super.getName())) && (target.getPrice() == super.getPrice())
				&& (target.company.equals(this.company));
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}
