package library.checkout;

import java.util.ArrayList;
import java.util.Scanner;

import library.Book;
import library.Library;
import library.Member;
import library.report.GenerateLibraryReport;
import utils.Define;

// 일반 회원 책 대여, 반납 기능
public class GeneralCheckOut implements CheckOut {
	Library library = Library.getInstance();
	Scanner scanner = new Scanner(System.in);
	GenerateLibraryReport libraryReport = new GenerateLibraryReport();

	// 책 대여 기능
	@Override
	public void checkOutBook(Member loginMember) {
		if (loginMember.getCheckOutBookList().size() != 0) {
			libraryReport.currentCheckOutBookList(loginMember);
		}
		if (loginMember.getCheckOutBookList().size() >= Define.GENERAL_LIMIT) {
			System.out.println("도서 대여 한도 권수를 초과했습니다.");
			System.out.println("일반 회원은 동시에 3권까지만 대여가능합니다.");
		} else {
			ArrayList<Book> bookList = library.getBookList();
			System.out.println("대여할 책 이름을 입력해주세요.");
			System.out.print("입력> ");
			String bookName = scanner.nextLine().replaceAll("\\s", "");
			Book book = null;
			for (Book b : bookList) {
				if (bookName.equals(b.getName().replaceAll("\\s", ""))) {
					if (b.getCheckOutMember() != null) { // 대여 중인 책인지 확인
						if (b.getCheckOutMember().getMemberId() == loginMember.getMemberId()) {
							System.out.println("이미 회원님이 대여 중인 책입니다.");
						} else {
							System.out.println("이미 다른 회원이 대여 중인 책입니다.");
						}
						return;
					} else {
						book = b;
						break;
					}
				}
			}
			if (book == null) {
				System.out.println("도서관에 없는 책입니다.");
				return;
			}
			loginMember.addCheckOutBookList(book);
			book.setCheckOutMember(loginMember);
			System.out.println(book.getName() + "을(를) 대여했습니다.");
		}
	}

	// 책 반납 기능
	@Override
	public void returnBook(Member loginMember) {
		libraryReport.currentCheckOutBookList(loginMember);
		ArrayList<Book> bookList = loginMember.getCheckOutBookList();
		System.out.println("반납할 책 이름을 입력해주세요.");
		System.out.print("입력> ");
		String bookName = scanner.nextLine().replaceAll("\\s", "");
		Book book = null;
		for (int i = 0; i < bookList.size(); i++) {
			if (bookName.equals(bookList.get(i).getName().replaceAll("\\s", ""))) {
				book = bookList.get(i);
				break;
			}
		}
		if (book == null) {
			System.out.println("현재 대여중인 책이 아닙니다.");
			return;
		}
		bookList.remove(book);
		book.setCheckOutMember(null);
		System.out.println(book.getName() + "을(를) 반납했습니다.");
	}

}
