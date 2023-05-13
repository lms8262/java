package library;

import java.util.ArrayList;

import utils.Define;

public class Member {
	// 필드
	private String name; // 회원이름
	private int memberId; // 회원번호
	private int memberType; // 회원등급구분
	private ArrayList<Book> checkOutBookList = new ArrayList<>(); // 현재 빌리고 있는 책 목록

	// 생성자
	public Member(String name, int memberId) {
		this.name = name;
		this.memberId = memberId;
		this.memberType = Define.GENERAL_TYPE; // 디폴트 회원등급
	}

	// 현재 빌리고 있는 책 추가
	public void addCheckOutBookList(Book book) {
		checkOutBookList.add(book);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getMemberType() {
		return memberType;
	}

	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}

	public ArrayList<Book> getCheckOutBookList() {
		return checkOutBookList;
	}

	public void setCheckOutBookList(ArrayList<Book> checkOutBookList) {
		this.checkOutBookList = checkOutBookList;
	}

}
