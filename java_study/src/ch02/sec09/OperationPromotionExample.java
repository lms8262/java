package ch02.sec09;

public class OperationPromotionExample {

	public static void main(String[] args) {
		// 중요. byte, short, char끼리 연산하면 int로 따라간다. => int 타입에 결과값을 담아야 한다.
		byte v1 = 10;
		byte v2 = 20;
		int result2 = v1 + v2;

		// 중요. 타입이 다양한 변수끼리 연산시 허용범위가 큰 타입으로 따라간다. => 허용범위가 큰 타입에 결과값을 담아야 한다.
		byte v3 = 10;
		int v4 = 100;
		long v5 = 1000L;
		long result3 = v3 + v4 + v5;

		char v6 = 'A'; // 65
		char v7 = 1;
		int result4 = v6 + v7;
		System.out.println("result4:" + result4);
		System.out.println("result4:" + (char) result4);

		// 중요. 정수 연산의 결과는 정수(연산 후 실수에 담아도 정수)
		int v8 = 10;
		double result5 = v8 / 4;
		System.out.println("result5:" + result5);

		// 첫번째 문제)정수로 실수 결과를 얻는 해결방법 => 정수와 실수 연산을 시킨다.
		int v9 = 10;
		double result6 = v9 / 4.0;
		System.out.println("result6:" + result6);

		// 두번째 문제)둘 다 정수가 담긴 변수인데 실수 결과를 얻어야 할때?
		int v10 = 1;
		int v11 = 2;
		double result7 = (double) v10 / v11; // (double) (v10 / v11)가 되지 않도록 조심
		System.out.println("result7:" + result7);

	}

}
