package library.checkout;

import java.util.ArrayList;
import java.util.Scanner;

import library.Book;
import library.Library;
import library.Member;
import utils.Define;

public class GeneralCheckOut implements CheckOut {
	Library library = Library.getInstance();
	Scanner scanner = new Scanner(System.in);

	@Override
	public void checkOutBook(Member loginMember) {
		CheckOut.currentCheckOutBookList(loginMember);
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
					book = b;
					break;
				}
			}
			loginMember.addCheckOutBookList(book);
			book.setCheckOutMember(loginMember);
			System.out.println(book.getName() + "을(를) 대여했습니다.");
		}
	}

	@Override
	public void returnBook(Member loginMember) {

	}

}
