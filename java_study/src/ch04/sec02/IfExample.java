package ch04.sec02;

public class IfExample {

	public static void main(String[] args) {
		int score = 93;

		if (score >= 90) { // 90점 이상~
			System.out.println("학점 A입니다.");
		} else if (score >= 80) { // 89 ~ 80
			System.out.println("학점 B입니다.");
		} else if (score >= 70) { // 79 ~ 70
			System.out.println("학점 C입니다.");
		} else { // 69이하
			System.out.println("학점 D입니다.");
		}
		
	}

}
