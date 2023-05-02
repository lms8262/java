package customer.project;

public class VIPCustomer extends Customer {
	double saleRatio; // 할인율
	private int agentID; // 상담원 아이디

	public VIPCustomer(int customerID, String customerName, int agentID) {
		super(customerID, customerName);
		super.customerGrade = "VIP";
		super.bonusRatio = 0.05;
		this.saleRatio = 0.1;
		this.agentID = agentID;
	}

	@Override
	public int clacPrice(int price) {
		// 1. 보너스 포인트가 쌓인다.
		bonusPoint += (price * bonusRatio);

		// 2. 사용자가 지불할 가격을 리턴(할인이 된다)
		return price - (int) (price * saleRatio);
	}

	// 담당 상담원의 정보 출력
	@Override
	public String showCustomerInfo() {
		// 고객이름, 등급, 현재 보너스 포인트점수, 상담원ID
		return super.showCustomerInfo() + ", 담당 상담원 아이디: " + agentID;
	}

	public int getAgentID() {
		return agentID;
	}

	public void setAgentID(int agentID) {
		this.agentID = agentID;
	}

}
