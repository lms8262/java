package question.Q06_23;

import java.util.Scanner;

public class BankApplication {
	// 계좌 객체를 저장 할 수 있는 배열(디폴트 값: null)
	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);

	// 계좌생성
	private static void createAccount() {
		System.out.println("----------");
		System.out.println("계좌생성");
		System.out.println("----------");
		System.out.print("계좌번호: ");
		String accountNumber = scanner.next();
		// 계좌번호 중복 체크
		Account account = fintAccount(accountNumber);
		if (account != null) {
			System.out.println("이미 존재하는 계좌번호입니다.");
			return;
		}
		System.out.print("계좌주: ");
		String owner = scanner.next();
		System.out.print("초기입금액: ");
		int balance = scanner.nextInt();
		if (balance < 0) {
			balance = 0;
		}
		Account newAccount = new Account(accountNumber, owner, balance);
		// 배열 안에 객체를 넣는게 포인트
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				accountArray[i] = newAccount; // 생성한 계좌객체를 배열에 넣어준다.
				System.out.println("결과: 계좌가 생성되었습니다.");
				break; // 계좌를 생성하면 for문을 나온다.
			}
		}
	}

	// 계좌목록
	private static void accountList() {
		System.out.println("----------");
		System.out.println("계좌목록");
		System.out.println("----------");
		for (Account account : accountArray) {
			if (account != null) {
				System.out.print(account.getAccountNumber());
				System.out.print("   ");
				System.out.print(account.getOwner());
				System.out.print("   ");
				System.out.println(account.getBalance());
			}
		}
	}

	// 예금
	private static void deposit() {
		System.out.println("----------");
		System.out.println("예금");
		System.out.println("----------");
		System.out.print("계좌번호: ");
		String accountNumber = scanner.next();
		Account account = fintAccount(accountNumber);
		if (account == null) {
			System.out.println("계좌를 찾을 수 없습니다.");
			return;
		}
		System.out.print("예금액: ");
		int deposit = scanner.nextInt();
		account.setBalance(account.getBalance() + deposit);
		System.out.println("예금이 완료됐습니다.");
	}

	// 출금
	private static void withdraw() {
		System.out.println("----------");
		System.out.println("출금");
		System.out.println("----------");
		System.out.print("계좌번호: ");
		String accountNumber = scanner.next();
		Account account = fintAccount(accountNumber);
		if (account == null) {
			System.out.println("계좌를 찾을 수 없습니다.");
			return;
		}
		System.out.print("출금액: ");
		int withdraw = scanner.nextInt();
		if (withdraw > account.getBalance()) {
			System.out.println("잔고가 부족합니다.");
			return;
		}
		account.setBalance(account.getBalance() - withdraw);
		System.out.println("출금이 완료됐습니다.");
	}

	private static Account fintAccount(String accountNumber) {
		Account resultAccount = null;
		for (Account account : accountArray) {
			if (account != null) {
				if (account.getAccountNumber().equals(accountNumber)) {
					resultAccount = account;
					break;
				}

			}
		}
		return resultAccount;
	}

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("---------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("---------------------------------------------");
			System.out.print("선택> ");
			int select = scanner.nextInt();
			switch (select) {
			case 1:
				createAccount();
				break;
			case 2:
				accountList();
				break;
			case 3:
				deposit();
				break;
			case 4:
				withdraw();
				break;
			case 5:
				run = false;
				break;
			default:
				System.out.println("1~5사이의 숫자를 입력해주세요.");
				break;
			}
		}
		System.out.println("프로그램 종료");
	}

}
