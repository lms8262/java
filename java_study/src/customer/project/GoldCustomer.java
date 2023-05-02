package customer.project;

public class GoldCustomer extends Customer {
	double saleRatio; // 할인율

	public GoldCustomer(int customerID, String customerName) {
		super(customerID, customerName);
		super.customerGrade = "GOLD";
		super.bonusRatio = 0.02;
		this.saleRatio = 0.1;
	}

	@Override
	public int clacPrice(int price) {
		// 1. 보너스 포인트가 쌓인다.
		bonusPoint += (price * bonusRatio);

		// 2. 사용자가 지불할 가격을 리턴(할인이 된다)
		return price - (int) (price * saleRatio);
	}

}
