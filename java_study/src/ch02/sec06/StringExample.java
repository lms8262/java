package ch02.sec06;

public class StringExample {

	public static void main(String[] args) {
		String name = "홍길동";

		String str = "나는 \"자바\"를 배웁니다.";
		System.out.println(str);

		str = "번호\t이름\t직업";
		System.out.println(str);

		str = "나는\n자바를\n배웁니다.";
		System.out.println(str);

		String result = name + 1;
		System.out.println(result);

		String num1 = "1"; // 문자
		String num2 = "3"; // 문자
		int a = 10;
		System.out.println(num1 + num2);
		System.out.println(num1 + a);

	}

}
