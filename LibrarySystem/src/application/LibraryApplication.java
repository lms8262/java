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

	// 메인 메소드
	public static void main(String[] args) {
		LibraryApplication app = new LibraryApplication(); // 도서관 어플리케이션 객체 생성
		app.applicationRun(); // 도서관 어플리케이션 실행
	}

	// 도서관 어플리케이션 실행 메소드
	public void applicationRun() {
		createMember();
		createBook();
		boolean runCheck = true;
		Member loginMember = null;
		while (runCheck) {
			System.out.println("----------------------------------------------------------");
			System.out.println("\t\t  " + library.getLibraryName() + " 어플리케이션");
			System.out.println(" 1.로그인   2.도서 대여   3.도서 반납   4.관리자 모드   5.회원가입");
			System.out.println(" 6.대여 가능 도서 목록   7.로그아웃   8.어플리케이션 종료");
			System.out.println("----------------------------------------------------------");
			while (true) {
				try {
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
						adminMode();
						break;
					case 5:
						register(loginMember);
						break;
					case 6:
						libraryReport.checkOutAbleBookListReport();
						break;
					case 7:
						loginMember = logout(loginMember);
						break;
					case 8:
						runCheck = false;
						break;
					default:
						System.out.println("1~8 사이의 숫자를 입력해주세요.");
						break;
					}
					break;
				} catch (InputMismatchException e) {
					scanner.next();
					System.out.println("1~8 사이의 숫자를 입력해주세요.");
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

	// 회원 생성 및 도서관 회원목록에 추가
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

	// 로그인
	public Member login(Member loginMember) {
		if (loginMember == null) {
			System.out.println("-------------------------");
			System.out.println("\t1.로그인");
			System.out.println("-------------------------");
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
			loginMember = searchMember(name, memberId);
			if (loginMember == null) { // 입력한 값과 맞는 회원 정보가 없을 경우
				System.out.println("회원정보를 찾을 수 없습니다.");
				return loginMember;
			}
			System.out.println(loginMember.getName() + "님 로그인에 성공했습니다.");
		} else {
			System.out.println(loginMember.getName() + "님 이미 로그인 중입니다.");
		}
		return loginMember;
	}

	// 도서 대여
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

	// 도서 반납
	public void returnBook(Member loginMember) {
		if (loginMember != null) {
			if (loginMember.getCheckOutBookList().size() == 0) {
				System.out.println("현재 대여중인 책이 없습니다.");
				return;
			}
			System.out.println("-------------------------");
			System.out.println("\t3.도서 반납");
			System.out.println("-------------------------");
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

	// 회원가입
	public void register(Member loginMember) {
		if (loginMember == null) {
			System.out.println("이름을 입력해주세요.");
			System.out.print("이름> ");
			String name = scanner.next();
			int memberId = 0;
			System.out.println("회원번호를 8자리 숫자로 입력해주세요.");
			while (true) {
				try {
					System.out.print("회원번호> ");
					memberId = scanner.nextInt();
					if (10000000 <= memberId && memberId <= 99999999) {
						for (Member member : library.getMemberList()) {
							if (member.getMemberId() == memberId) { // 회원번호 중복 생성 막기
								System.out.println("이미 존재하는 회원번호입니다.");
								return;
							}
						}
						break;
					} else {
						System.out.println("회원번호는 8자리 숫자로 입력해주세요.");
					}
				} catch (InputMismatchException e) {
					scanner.next();
					System.out.println("회원번호는 8자리 숫자로 입력해주세요.");
				}
			}
			Member member = new Member(name, memberId);
			library.addMember(member);
			System.out.println(member.getName() + "님 회원가입이 완료되었습니다.");
		} else {
			System.out.println(loginMember.getName() + "님 이미 로그인 중입니다.");
		}
	}

	// 로그아웃
	public Member logout(Member loginMember) {
		if (loginMember != null) {
			System.out.println(loginMember.getName() + "님 로그아웃 완료했습니다.");
			loginMember = null;
		} else {
			System.out.println("로그인 상태가 아닙니다.");
		}
		return loginMember;
	}

	// 관리자 모드
	public void adminMode() {
		System.out.println("-------------------------");
		System.out.println("\t4.관리자 모드");
		System.out.println("-------------------------");
		System.out.println("관리자 이름과 비밀번호를 입력해주세요.");
		System.out.print("관리자 이름> ");
		String adminName = scanner.next();
		int adminPassword = 0;
		while (true) {
			try {
				System.out.print("관리자 비밀번호> ");
				adminPassword = scanner.nextInt();
				break;
			} catch (InputMismatchException e) {
				scanner.next();
				System.out.println("비밀번호는 숫자를 입력해주세요.");
			}
		}
		if (adminName.equals(Define.ADMIN_NAME) && adminPassword == Define.ADMIN_PASSWORD) {
			boolean runCheck = true;
			while (runCheck) {
				System.out.println("----------------------------------------------------------");
				System.out.println("\t\t관리자 모드");
				System.out.println("1.회원목록   2.도서관 보유 도서 현황   3.대여 중인 도서 목록");
				System.out.println("4.관리자 모드 종료");
				System.out.println("----------------------------------------------------------");
				while (true) {
					try {
						int select = 0;
						System.out.print("선택> ");
						select = scanner.nextInt();
						switch (select) {
						case 1:
							libraryReport.memberListReport();
							break;
						case 2:
							libraryReport.bookListReport();
							break;
						case 3:
							libraryReport.checkOutBookListReport();
							break;
						case 4:
							runCheck = false;
							System.out.println("관리자 모드 종료");
							break;
						default:
							System.out.println("1~4 사이의 숫자를 입력해주세요.");
							break;
						}
						break;
					} catch (InputMismatchException e) {
						scanner.next();
						System.out.println("1~4 사이의 숫자를 입력해주세요.");
					}
				}
			}
		} else {
			System.out.println("관리자 정보를 찾을 수 없습니다.");
		}
	}

}
