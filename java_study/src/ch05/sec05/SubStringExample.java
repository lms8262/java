package ch05.sec05;

public class SubStringExample {

	public static void main(String[] args) {
		String ssn = "880815-1234567";

		// substring(시작인덱스, 끝인덱스 직전);
		String firstNum = ssn.substring(0, 6);
		System.out.println(firstNum);

		// substring(시작인덱스) => 시작인덱스로부터 문자열 끝까지
		String secondNum = ssn.substring(7);
		System.out.println(secondNum);
		
	}

}
