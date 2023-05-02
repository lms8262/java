package ch03.sec06;

public class CompareOperatorExample {

	public static void main(String[] args) {

		// char끼리 비교
		char char1 = 'A'; // 65
		char char2 = 'B'; // 66

		boolean result4 = (char1 < char2); // 65 < 66
		System.out.println("result4: " + result4);

		// 타입이 다른 경우 비교(int와 float, double)
		int num3 = 1;
		float num4 = 1.0f;
		boolean result5 = (num3 == num4);
		System.out.println("result5: " + result5);

		// 예외. 타입이 다른 경우(float와 double) => 타입 변환을 해줘야 한다.
		float num5 = 0.1f;
		double num6 = 0.1;
		boolean result6 = (num5 == (float) num6);
		System.out.println("result6: " + result6);

		//문자열 비교
		String str1 = "자바";
		String str2 = "Java";
		boolean result8 = (str1.equals(str2)); // str1 == str2
		boolean result9 = (!str1.equals(str2)); // str1 != str2
		System.out.println("result8: " + result8);
		System.out.println("result9: " + result9);
		
	}

}
