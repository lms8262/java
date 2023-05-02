package order.project;

public class OrderDelivery extends Order {
	double deliveryDistance; // 배달 거리(km)
	int deliveryCost; // 배달 비용

	public OrderDelivery(int orderNum, String orderName, int orderPrice, double deliveryDistance) {
		super(orderNum, orderName, orderPrice);
		super.orderType = "배달";
		this.deliveryDistance = deliveryDistance;
		this.deliveryCost = (int) deliveryDistance * 1000;
	}

	// 주문 정보 출력(주문번호, 주문자 이름, 주문 유형, 주문금액, 배달거리)
	
	@Override
	public String orderInfo() {
		return super.orderInfo() + ", 배달거리: " + deliveryDistance + "km";
	}

	@Override
	public int payment() {
		return super.payment() + deliveryCost;
	}


}
