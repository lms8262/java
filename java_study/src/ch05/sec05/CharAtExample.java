package ch05.sec05;

public class CharAtExample {

	public static void main(String[] args) {
		String ssn = "9506241230123"; // index:012345...
		char sex = ssn.charAt(6); // 인덱스 번호로 해당 문자를 구한다.

		System.out.println(sex);
		int length = ssn.length(); // 문자열의 길이를 구한다.

		if (length == 13) {
			System.out.println("주민등록번호 자릿수가 맞습니다");
		} else {
			System.out.println("주민등록번호 자릿수가 틀립니다");
		}

		switch (sex) {
		case '1':
		case '3':
			System.out.println("남자");
			break;

		case '2':
		case '4':
			System.out.println("여자");
			break;
		}
	}

}
