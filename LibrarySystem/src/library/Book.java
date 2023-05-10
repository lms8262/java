package library;

import utils.Define;

public class Book {
	// 필드
	private String name; // 책 이름
	private boolean checkOutCheck; // 책 대출 여부
	private int checkOutPeriod; // 책 대출 기간
	private Member checkOutMember; // 책을 대출 중인 회원
	
	public Book(String name) {
		this.name = name;
		this.checkOutPeriod = Define.GENERAL_PERIOD; // 디폴트 책 대출 기간
	}
	
	public void addCheckOutMember(Member member) {
		this.checkOutMember = member; 
	}
}
