package library.checkout;

import java.util.ArrayList;

import library.Book;
import library.Member;

public interface CheckOut {
	public void checkOutBook(Member loginMember);

	public void returnBook(Member loginMember);

	public static void currentCheckOutBookList(Member loginMember) {
		StringBuilder str = new StringBuilder();
		str.append("-----------------------------\n");
		str.append("\t현재 대여중인 책\n");
		ArrayList<Book> bookList = loginMember.getCheckOutBookList();
		for (Book book : bookList) {
			str.append(book.getName() + "\n");
		}
		str.append("-----------------------------\n");
		System.out.println(str.toString());
	}
}
