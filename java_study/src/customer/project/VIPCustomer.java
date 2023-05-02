package customer.project;

public class VIPCustomer extends Customer {
	double saleRatio; // 할인율
	private int agentID; // 상담원 아이디

	@Override
	public int clacPrice(int price) {
		return super.clacPrice(price);
	}

	@Override
	public String showCustomerInfo() {
		return super.showCustomerInfo();
	}
}
