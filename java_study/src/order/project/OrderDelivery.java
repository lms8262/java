package order.project;

public class OrderDelivery extends Order { // 배달 주문시 배달 비용 추가
	double deliveryDistance; // 배달 거리(km)
	int deliveryCost; // 배달 비용

	public OrderDelivery(int orderNum, String orderName, int orderPrice, double deliveryDistance) {
		super(orderNum, orderName, orderPrice);
		super.orderType = "배달";
		this.deliveryDistance = deliveryDistance;
		this.deliveryCost = (int) deliveryDistance * 1000; // 거리에 비례해서 1000원 단위로 배달료 증가
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
