package order.project;

public class Order { // 매장 주문 , 부모 클래스
	private int orderNum; // 주문 번호
	private String orderName; // 주문고객 이름
	private int orderPrice; // 주문 금액
	protected String orderType; // 주문 유형(매장, 포장, 배달, 대량주문)
	private boolean orderComplete; // 주문 처리 여부

	public Order(int orderNum, String orderName, int orderPrice) {
		this.orderNum = orderNum;
		this.orderName = orderName;
		this.orderPrice = orderPrice;
		initOrderType();
	}

	public void initOrderType() {
		orderType = "매장";
	}

	// 주문 정보 출력(주문번호, 주문자 이름, 주문 유형, 주문금액)
	public String orderInfo() {
		return "주문번호: " + orderNum + "번, 주문고객: " + orderName + "님, 주문유형: " + orderType + ", 주문금액: " + orderPrice + "원";
	}

	// 실제 고객 지불 금액
	public int payment() {
		return orderPrice;
	}

	// 매출 (할인 금액 뺀 금액)
	public int sales() {
		return orderPrice;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public boolean isOrderComplete() {
		return orderComplete;
	}

	public void setOrderComplete(boolean orderComplete) {
		this.orderComplete = orderComplete;
	}

}
