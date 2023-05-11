package application;

import java.util.Scanner;

import library.Book;
import library.Library;
import library.Member;
import library.report.GenerateLibraryReport;
import utils.Define;

public class LibraryApplication {
	Scanner scanner = new Scanner(System.in);
	Library library = Library.getInstance(); // 싱글톤 도서관 객체 생성
	GenerateLibraryReport libraryReport = new GenerateLibraryReport();

	public static void main(String[] args) {
		LibraryApplication app = new LibraryApplication(); // 도서관 어플 객체 생성
		app.applicationRun();
	}

	// 도서관 어플리케이션 작동 메소드
	public void applicationRun() {
		createMember();
		createBook();
		boolean runCheck = true; 
		while (runCheck) {
			System.out.println("------------------------------------------------------");
			System.out.println("\t\t  " + library.getLibraryName() + " 어플리케이션");
			System.out.println(" 1.로그인 | 2.도서 대출 | 3.도서 반납 | 4.관리자 모드 | 5.종료");
			System.out.println("------------------------------------------------------");
			System.out.print("선택> ");
			int select = scanner.nextInt();
			switch (select) {
			case 1:
				System.out.println("1.로그인");
				break;
			case 2:
				System.out.println("2.도서 대출");
				break;
			case 3:
				System.out.println("3.도서 반납");
				break;
			case 4:
				System.out.println("4.관리자 모드");
				break;
			case 5:
				runCheck = false;
				break;
			default:
				System.out.println("1~5 사이의 숫자를 입력해주세요.");
				break;
			}
		}
		System.out.println("어플리케이션 종료");
	}

	// 책 생성 및 도서관에 추가
	public void createBook() {
		String[] bookNameList = new String[] { "이것이 자바다", "자바의 정석", "너의 이름은", "너의 췌장을 먹고 싶어", "상냥한 저승사자를 기르는 법",
				"날씨의 아이", "언어의 정원", "나미야 잡화점의 기적", "가면산장 살인사건", "그리고 아무도 없었다" };
		for (String bookName : bookNameList) {
			Book book = new Book(bookName);
			library.addBook(book);
		}
	}

	// 회원 생성 및 도서관에 추가
	public void createMember() {
		Member member1 = new Member("김철수", 22021801);
		Member member2 = new Member("이지혜", 17032302);
		Member member3 = new Member("김동현", 20110803);
		Member member4 = new Member("이지수", 23051104);
		Member member5 = new Member("박찬용", 13092105);

		library.addMember(member1);
		library.addMember(member2);
		library.addMember(member3);
		library.addMember(member4);
		library.addMember(member5);

		// 회원등급을 특별회원으로 설정
		member2.setMemberType(Define.SPECIAL_TYPE);
		member5.setMemberType(Define.SPECIAL_TYPE);
	}
}
