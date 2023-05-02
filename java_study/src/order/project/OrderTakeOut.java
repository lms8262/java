package order.project;

public class OrderTakeOut extends Order {
	final int discount;

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
