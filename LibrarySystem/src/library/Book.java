package library;

import utils.Define;

public class Book {
	// 필드
	private String name; // 책 이름
	private int checkOutPeriod; // 책 대여 기간
	private Member checkOutMember; // 책을 대여 중인 회원
	
	public Book(String name) {
		this.name = name;
		this.checkOutPeriod = Define.GENERAL_PERIOD; // 디폴트 책 대여 기간
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCheckOutPeriod() {
		return checkOutPeriod;
	}

	public void setCheckOutPeriod(int checkOutPeriod) {
		this.checkOutPeriod = checkOutPeriod;
	}

	public Member getCheckOutMember() {
		return checkOutMember;
	}
	
	public void setCheckOutMember(Member checkOutMember) {
		this.checkOutMember = checkOutMember;
	}
	
}
