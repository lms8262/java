package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import library.Book;
import library.Library;
import library.Member;
import library.checkout.CheckOut;
import library.checkout.GeneralCheckOut;
import library.checkout.SpecialCheckOut;
import library.report.GenerateLibraryReport;
import utils.Define;

public class LibraryApplication {
	Scanner scanner = new Scanner(System.in);
	Library library = Library.getInstance(); // 싱글톤 도서관 객체 생성
	GenerateLibraryReport libraryReport = new GenerateLibraryReport();
	CheckOut[] checkOut = new CheckOut[] { new GeneralCheckOut(), new SpecialCheckOut() };

	public static void main(String[] args) {
		LibraryApplication app = new LibraryApplication(); // 도서관 어플 객체 생성
		app.applicationRun(); // 도서관 어플리케이션 실행
	}

	// 도서관 어플리케이션 실행 메소드
	public void applicationRun() {
		createMember();
		createBook();
		boolean runCheck = true;
		Member loginMember = null;
		while (runCheck) {
			while (true) {
				try {
					System.out.println("------------------------------------------------------");
					System.out.println("\t\t  " + library.getLibraryName() + " 어플리케이션");
					System.out.println(" 1.로그인 | 2.도서 대여 | 3.도서 반납 | 4.관리자 모드 | 5.종료");
					System.out.println("------------------------------------------------------");
					int select = 0;
					System.out.print("선택> ");
					select = scanner.nextInt();
					switch (select) {
					case 1:
						loginMember = login(loginMember);
						break;
					case 2:
						checkOutBook(loginMember);
						break;
					case 3:
						returnBook(loginMember);
						break;
					case 4:
						System.out.println("-------------------------");
						System.out.println("\t4.관리자 모드");
						System.out.println("-------------------------");
						break;
					case 5:
						runCheck = false;
						break;
					default:
						System.out.println("1~5 사이의 숫자를 입력해주세요.");
						break;
					}
					break;
				} catch (InputMismatchException e) {
					scanner.next();
					System.out.println("1~5 사이의 숫자를 입력해주세요.");
				}
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

	// 이름, 회원 아이디 입력받아 회원 객체 리턴
	public Member searchMember(String name, int memberId) {
		ArrayList<Member> memberList = library.getMemberList();
		Member member = null;
		for (Member m : memberList) {
			if (m.getName().equals(name) && m.getMemberId() == memberId) {
				member = m;
				return member;
			}
		}
		return member;
	}

	// 1.로그인
	public Member login(Member loginMember) {
		System.out.println("-------------------------");
		System.out.println("\t1.로그인");
		System.out.println("-------------------------");
		Member member = loginMember;
		if (loginMember == null) {
			System.out.print("회원이름> ");
			String name = scanner.next();
			int memberId = 0;
			while (true) {
				try {
					System.out.print("회원번호> ");
					memberId = scanner.nextInt();
					break;
				} catch (InputMismatchException e) {
					scanner.next();
					System.out.println("회원번호는 8자리 숫자로 입력해주세요.");
				}
			}
			member = searchMember(name, memberId);
			if (member == null) { // 입력한 값과 맞는 회원 정보가 없을 경우
				System.out.println("회원정보를 찾을 수 없습니다.");
				return member;
			}
			System.out.println(member.getName() + "님 로그인에 성공했습니다.");
		} else {
			System.out.println(member.getName() + "님 이미 로그인 중입니다.");
		}
		return member;
	}

	// 2.도서 대여
	public void checkOutBook(Member loginMember) {
		System.out.println("-------------------------");
		System.out.println("\t2.도서 대여");
		System.out.println("-------------------------");
		if (loginMember != null) {
			if (loginMember.getMemberType() == Define.SPECIAL_TYPE) {
				checkOut[Define.SPECIAL_TYPE].checkOutBook(loginMember);
			} else {
				checkOut[Define.GENERAL_TYPE].checkOutBook(loginMember);
			}
		} else {
			System.out.println("로그인이 필요합니다.");
			return;
		}
	}

	// 3.도서 반납
	public void returnBook(Member loginMember) {
		System.out.println("-------------------------");
		System.out.println("\t3.도서 반납");
		System.out.println("-------------------------");
		if (loginMember != null) {
			if (loginMember.getMemberType() == Define.SPECIAL_TYPE) {
				checkOut[Define.SPECIAL_TYPE].returnBook(loginMember);
			} else {
				checkOut[Define.GENERAL_TYPE].returnBook(loginMember);
			}
		} else {
			System.out.println("로그인이 필요합니다.");
			return;
		}
	}

}
