package question;

import java.util.Scanner;

public class Q04_10 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int select = 0;
		int money = 0;

		while (true) {
			System.out.println("--------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("--------------------------------");
			System.out.print("선택> ");
			select = scanner.nextInt();
			if (select == 1) {
				System.out.print("예금액> ");
				money += scanner.nextInt();
			} else if (select == 2) {
				System.out.print("출금액> ");
				money -= scanner.nextInt();
			} else if (select == 3) {
				System.out.println("잔고> " + money);
			} else if (select == 4) {
				break;
			}
		}
		System.out.println("프로그램 종료");
	}

}
