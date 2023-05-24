package supermarket;

import java.util.ArrayList;
import java.util.HashSet;

import receipt.Receipt;

public class Supermarket {
	private static Supermarket instance = null; // 싱글톤
	private String name = "연수 마트"; // 마트 이름
	private HashSet<Member> memberList = new HashSet<>(); // 마트 회원 목록
	private HashSet<Product> productList = new HashSet<>(); // 마트 상품 목록
	private ArrayList<Receipt> receiptList = new ArrayList<>(); // 영수증 목록

	// 싱글톤 생성자
	private Supermarket() {
	}

	// 싱글톤 메소드
	public static Supermarket getInstance() {
		if (instance == null) {
			instance = new Supermarket();
		}
		return instance;
	}

	// 회원 추가
	public void addMember(Member member) {
		memberList.add(member);
	}

	// 상품 추가
	public void addProduct(Product product) {
		productList.add(product);
	}

	// 영수증 추가
	public void addReceipt(Receipt receipt) {
		receiptList.add(receipt);
	}

	public String getName() {
		return name;
	}

	public HashSet<Member> getMemberList() {
		return memberList;
	}

	public HashSet<Product> getProductList() {
		return productList;
	}

}
