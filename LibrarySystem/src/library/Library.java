package library;

import java.util.ArrayList;

public class Library {
	private static Library instance = null; // 싱글톤 객체
	private String libraryName = "연수 도서관"; // 도서관 이름
	private ArrayList<Member> memberList = new ArrayList<>(); // 도서관 회원 목록
	private ArrayList<Book> bookList = new ArrayList<>(); // 도서관 책 목록

	// 싱글톤 생성자 제한
	private Library() {
	}

	// 싱글톤 메소드
	public static Library getInstance() {
		if (instance == null) {
			instance = new Library();
		}
		return instance;
	}

	// 도서관 회원등록
	public void addMember(Member member) {
		memberList.add(member);
	}

	// 도서관 책 추가
	public void addBook(Book book) {
		bookList.add(book);
	}

	// getter 메소드
	public String getLibraryName() {
		return libraryName;
	}

	public ArrayList<Member> getMemberList() {
		return memberList;
	}

	public ArrayList<Book> getBookList() {
		return bookList;
	}

}
