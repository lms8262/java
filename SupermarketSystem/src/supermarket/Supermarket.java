package supermarket;

import java.util.*;

import member.Member;
import product.Product;
import receipt.Receipt;

public class Supermarket {
	private static Supermarket instance = null; // 싱글톤
	private String name = "연수 마트"; // 마트 이름
	private HashSet<Member> memberList = new HashSet<>(); // 마트 회원 목록
	private HashSet<Product> productList = new HashSet<>(); // 마트 상품 목록
	private ArrayList<Receipt> receiptList = new ArrayList<>(); // 영수증 목록

	private Supermarket() { // 싱글톤 생성자
	}

	public static Supermarket getInstance() { // 싱글톤 메소드
		if (instance == null) {
			instance = new Supermarket();
		}
		return instance;
	}

	public void addMember(Member member) { // 회원 추가
		memberList.add(member);
	}

	public void addProduct(Product product) { // 상품 추가
		productList.add(product);
	}

	public void addReceipt(Receipt receipt) { // 영수증 추가
		receiptList.add(receipt);
	}

	public String getName() {
		return name;
	}

	public HashSet<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(HashSet<Member> memberList) {
		this.memberList = memberList;
	}

	public HashSet<Product> getProductList() {
		return productList;
	}

	public ArrayList<Receipt> getReceiptList() {
		return receiptList;
	}

	public void setReceiptList(ArrayList<Receipt> receiptList) {
		this.receiptList = receiptList;
	}

}
