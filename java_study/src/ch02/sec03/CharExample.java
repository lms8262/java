package ch02.sec03;

public class CharExample {

	public static void main(String[] args) {
		char c1 = 'A';
		char c2 = 65; // 유니코드를 직접저장

		char c3 = '가';
		char c4 = 44032; // 유니코드를 직접저장
		char c5 = ' '; // 유니코드: 32

		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
	}

}
