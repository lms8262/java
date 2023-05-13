package library.report;

import java.util.ArrayList;

import library.Book;
import library.Library;
import library.Member;
import utils.Define;

// 출력 관련 메소드
public class GenerateLibraryReport {
	Library library = Library.getInstance();
	StringBuilder sb = new StringBuilder();

	// 대여중인 책 목록 출력
	public void currentCheckOutBookList(Member loginMember) {
		sb.setLength(0);
		sb.append("--------------------------------------\n");
		sb.append("\t현재 대여중인 책\n");
		sb.append("제목\t\t\t남은 대여일 수\n");
		ArrayList<Book> bookList = loginMember.getCheckOutBookList();
		for (Book book : bookList) {
			sb.append(book.getName() + "\t\t");
			sb.append(book.getCheckOutPeriod() + "일\n");
		}
		sb.append("--------------------------------------");
		System.out.println(sb.toString());
	}

	// 도서관 회원목록 출력
	public void memberListReport() {
		sb.setLength(0);
		sb.append("----------------------------------------\n");
		sb.append("\t     도서관 회원목록\n");
		sb.append("이름\t\t회원번호\t\t회원등급\n");
		for (Member member : library.getMemberList()) {
			sb.append(member.getName() + "\t\t" + member.getMemberId());
			if (member.getMemberType() == Define.GENERAL_TYPE) {
				sb.append("\t일반회원\n");
			} else if (member.getMemberType() == Define.SPECIAL_TYPE) {
				sb.append("\t특별회원\n");
			}
		}
		sb.append("----------------------------------------");
		System.out.println(sb.toString());
	}

	// 도서관 보유 도서 현황 출력
	public void bookListReport() {
		sb.setLength(0);
		sb.append("----------------------------------------\n");
		sb.append("\t도서관 보유 도서 현황\n");
		sb.append("책 제목\t\t\t대여 현황\n");
		for (Book book : library.getBookList()) {
			sb.append(book.getName());
			if (book.getCheckOutMember() != null) {
				sb.append("\t\t대여 중\n");
			} else {
				sb.append("\n");
			}
		}
		sb.append("----------------------------------------");
		System.out.println(sb.toString());
	}

	// 대여 중인 도서 목록 출력
	public void checkOutBookListReport() {
		sb.setLength(0);
		sb.append("------------------------------------------\n");
		sb.append("\t대여 중인 도서 목록\n");
		sb.append("책 제목\t\t\t대여 회원 번호\n");
		for (Book book : library.getBookList()) {
			if (book.getCheckOutMember() != null) {
				sb.append(book.getName() + "\t\t" + book.getCheckOutMember().getMemberId() + "\n");
			}
		}
		sb.append("------------------------------------------");
		System.out.println(sb.toString());
	}

	// 대여 가능 도서 목록 출력
	public void checkOutAbleBookListReport() {
		sb.setLength(0);
		sb.append("--------------------------------------\n");
		sb.append("\t대여 가능 도서 목록\n");
		sb.append("책 제목\n");
		for (Book book : library.getBookList()) {
			if (book.getCheckOutMember() == null) {
				sb.append(book.getName() + "\n");
			}
		}
		sb.append("--------------------------------------");
		System.out.println(sb.toString());
	}
}
