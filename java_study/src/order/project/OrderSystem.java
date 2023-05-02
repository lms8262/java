package order.project;

import java.util.ArrayList;

// 주문 관리 시스템
public class OrderSystem {
	private static ArrayList<Order> orderList = new ArrayList<>();

	public static void main(String[] args) {
		// 주문 접수
		Order order1 = new Order(1, "김철수", 10000);
		Order order2 = new Order(2, "이순신", 20000);

		Order order3 = new OrderTakeOut(3, "박찬호", 15000);
		Order order4 = new OrderTakeOut(4, "정약용", 25000);

		Order order5 = new OrderDelivery(5, "신짱구", 18000, 3.2);
		Order order6 = new OrderDelivery(6, "장보고", 28000, 5.4);

		Order order7 = new OrderBulk(7, "연보라", 108000);
		Order order8 = new OrderBulk(8, "강백호", 145000);

		// ArrayList에 Order 객체 추가
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

		// 오늘의 주문수, 주문 유형별 횟수 집계, 매출 출력
		allOrderStatistics();

		// 주문완료 처리
		orderComplete(1);
		orderComplete(9);
		orderComplete(1);
		orderComplete(3);
		orderComplete(5);
		orderComplete(7);

		// 완료한 주문 목록 출력
		completeOrder();

		// 현재 남은 주문 목록 출력
		leftOrder();

		// 주문 번호로 주문 정보 출력
		orderInfoSearch(2);

		// 주문 번호로 고객의 실제 지불 금액(할인 및 배달비 적용) 출력
		paymentCustomer(1);
		paymentCustomer(3);
		paymentCustomer(5);
		paymentCustomer(7);
	}

	// 오늘의 모든 주문 목록 출력
	public static void showAllOrderList() {
		System.out.println("===============================오늘의 모든 주문===============================");
		for (Order order : orderList) {
			System.out.println(order.orderInfo());
		}
	}

	// 완료한 주문 목록 출력
	public static void completeOrder() {
		System.out.println("===============================완료한 주문===============================");
		for (Order order : orderList) {
			if (order.isOrderComplete()) {
				System.out.println(order.orderInfo());
			}
		}
	}

	// 현재 남은 주문 목록 출력
	public static void leftOrder() {
		System.out.println("===============================현재 남은 주문===============================");
		for (Order order : orderList) {
			if (!order.isOrderComplete()) {
				System.out.println(order.orderInfo());
			}
		}
	}

	// 오늘의 총 주문수, 주문 유형별 횟수, 오늘 총 매출(포장, 대량주문 할인 적용 금액 배달비 제외 매출 총 합) 출력
	public static void allOrderStatistics() {
		int store = 0;
		int takeOut = 0;
		int delivery = 0;
		int bulk = 0;
		int sales = 0;
		for (Order order : orderList) {
			switch (order.orderType) {
			case "매장":
				store++;
				break;
			case "포장":
				takeOut++;
				break;
			case "배달":
				delivery++;
				break;
			case "대량주문":
				bulk++;
				break;
			}
			sales += order.sales();
		}
		System.out.println("====================오늘의 모든 주문 통계====================");
		System.out.println("오늘의 총 주문수: " + orderList.size() + "회");
		System.out.println(
				"주문 유형별 횟수: 매장(" + store + "회), 포장(" + takeOut + "회), 배달(" + delivery + "회), 대량주문(" + bulk + "회)");
		System.out.println("오늘 총 매출: " + sales + "원");
	}

	// 주문 번호로 주문 객체 찾기
	public static Order findOrder(int orderNum) {
		Order result = null;
		for (Order order : orderList) {
			if (order.getOrderNum() == orderNum) {
				result = order;
				break;
			}
		}
		return result;
	}

	// 주문 번호로 주문 정보 출력
	public static void orderInfoSearch(int orderNum) {
		Order order = findOrder(orderNum);
		if (order == null) {
			System.out.println("입력한 주문 번호를 찾을 수 없습니다.");
			return;
		}
		System.out.println("===============================" + orderNum + "번 주문 내용===============================");
		System.out.println(order.orderInfo());
	}

	// 주문 번호로 주문완료 처리하기
	public static void orderComplete(int orderNum) {
		Order order = findOrder(orderNum);
		if (order == null) {
			System.out.println("입력한 주문 번호를 찾을 수 없습니다.");
			return;
		}
		if (order.isOrderComplete()) {
			System.out.println("이미 완료한 주문입니다.");
			return;
		}
		order.setOrderComplete(true);
		System.out.println(orderNum + "번 주문을 완료처리했습니다.");
	}

	// 주문 번호로 고객의 실제 지불 금액(할인 및 배달비 적용) 출력
	public static void paymentCustomer(int orderNum) {
		Order order = findOrder(orderNum);
		if (order == null) {
			System.out.println("입력한 주문 번호를 찾을 수 없습니다.");
			return;
		}
		System.out.println(
				"주문번호 " + orderNum + "번 " + order.getOrderName() + " 고객님의 지불 금액은 " + order.payment() + "원 입니다.");
	}

}
