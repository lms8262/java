package receipt;

import java.util.HashMap;

import supermarket.Member;
import supermarket.Product;

public class Receipt {
	private Member member; // 결제 회원
	private int payment; // 결제 금액
	private String paymentDate; // 결제일
	private HashMap<Product, Integer> paymentList; // 결제 상품 목록 및 개수

	public Receipt(Member member, int payment, String paymentDate, HashMap<Product, Integer> paymentList) {
		this.member = member;
		this.payment = payment;
		this.paymentDate = paymentDate;
		this.paymentList = paymentList;
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

	public HashMap<Product, Integer> getPaymentList() {
		return paymentList;
	}

}
