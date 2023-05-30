package receipt;

import java.util.HashMap;
import java.util.Map;

import member.Member;
import product.Product;

public class Receipt {
	private Member member; // 결제 회원
	private int payment; // 결제 금액
	private String paymentDate; // 결제일
	private Map<Product, Integer> paymentList = new HashMap<>(); // 결제 상품 목록 및 개수

	public Receipt(Member member, int payment, String paymentDate, Map<Product, Integer> shoppingCart) {
		this.member = member;
		this.payment = payment;
		this.paymentDate = paymentDate;
		this.paymentList = shoppingCart;
	}

	public Member getMember() {
		return member;
	}

	public int getPayment() {
		return payment;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public Map<Product, Integer> getPaymentList() {
		return paymentList;
	}

}
