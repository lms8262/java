package order.project;

import java.util.ArrayList;

public class OrderSystem {
	private static ArrayList<Order> orderList = new ArrayList<>();

	public static void main(String[] args) {
		Order order1 = new Order(1, "김씨", 10000);
		Order order2 = new Order(2, "이씨", 20000);

		Order order3 = new OrderTakeOut(3, "박씨", 15000);
		Order order4 = new OrderTakeOut(4, "정씨", 25000);

		Order order5 = new OrderDelivery(5, "최씨", 18000, 3.2);
		Order order6 = new OrderDelivery(6, "장씨", 28000, 5.4);

		Order order7 = new OrderBulk(7, "장씨", 88000);
		Order order8 = new OrderBulk(8, "장씨", 125000);

		orderList.add(order1);
		orderList.add(order2);
		orderList.add(order3);
		orderList.add(order4);
		orderList.add(order5);
		orderList.add(order6);
		orderList.add(order7);
		orderList.add(order8);

		// 오늘의 모든 주문 출력
		showAllOrderList();
	}

	public static void showAllOrderList() {
		System.out.println("===============================오늘의 모든 주문===============================");
		for (Order order : orderList) {
			System.out.println(order.orderInfo());
		}
	}
	
	public static void allOrderStatistics() {
		
	}
}
