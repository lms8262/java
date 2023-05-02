package order.project;

public class OrderBulk extends Order {
	final double discountRatio = 0.05; // 대량주문 할인율

	public OrderBulk(int orderNum, String orderName, int orderPrice) {
		super(orderNum, orderName, orderPrice);
		super.orderType = "대량주문";
	}

	@Override
	public int payment() {
		return super.payment() - (int) (super.orderPrice * discountRatio);
	}

	@Override
	public int sales() {
		return super.sales() - (int) (super.orderPrice * discountRatio);
	}

}
