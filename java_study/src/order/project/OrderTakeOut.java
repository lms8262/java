package order.project;

public class OrderTakeOut extends Order { // 포장 주문시 2000원 할인
	final int discount; // 포장 주문 할인 값

	public OrderTakeOut(int orderNum, String orderName, int orderPrice) {
		super(orderNum, orderName, orderPrice);
		super.orderType = "포장";
		this.discount = 2000;
	}

	@Override
	public int payment() {
		return super.payment() - discount;
	}

	@Override
	public int sales() {
		return super.sales() - discount;
	}

}
