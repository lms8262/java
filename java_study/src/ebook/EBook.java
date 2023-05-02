package ebook;

import java.util.Scanner;

public class EBook {
	// 필드
	int page;
	String publisher;
	String writer;
	int currentPage;
	int rentalPrice;
	int buyPrice;
	boolean rentalCheck;
	boolean buyCheck;

	// 생성자

	EBook(int page) {
		this.page = page;
	}

	// 메서드
	void rental() { // 책 대여하기
		if (!rentalCheck && !buyCheck) {
			System.out.println("책을 대여했습니다.");
			this.rentalCheck = true;
		} else if (rentalCheck) {
			System.out.println("이미 대여 중인 책입니다.");
		} else {
			System.out.println("이미 구매한 책입니다.");
		}
	}

	void buy() { // 책 구매하기
		if (!rentalCheck && !buyCheck) {
			System.out.println("책을 구매했습니다.");
			this.buyCheck = true;
		} else if (rentalCheck) {
			System.out.println("이미 대여 중인 책입니다.");
		} else {
			System.out.println("이미 구매한 책입니다.");
		}
	}

	void read() { // 책 읽기
		while (true) {
			if (rentalCheck || buyCheck) {
				if (currentPage == page) {
					System.out.println("이미 마지막 페이지까지 읽은 책입니다.");
					return;
				}
				Scanner scanner = new Scanner(System.in);
				System.out.println("============================================");
				System.out.println("현재 페이지는 " + currentPage + "페이지입니다.");
				System.out.print("읽을 페이지 수를 입력해주세요. > ");
				int readPage = scanner.nextInt();
				if (page > currentPage + readPage) {
					this.currentPage += readPage;
					System.out.println("책을 " + currentPage + "페이지까지 읽으셨습니다.");
					System.out.print("계속 읽으려면 y, 그만 읽으려면 n을 입력해주세요.");
					char readContinue = scanner.next().charAt(0);
					if(readContinue == 'n' || readContinue == 'N') {
						return;
					}
				} else {
					this.currentPage = page;
					System.out.println("책을 마지막 페이지" + "(" + page + "페이지" + ")" + "까지 읽으셨습니다.");
					return;
				}
			} else {
				System.out.println("책을 구매 또는 대여해주세요.");
				return;
			}
		}

	}

}
