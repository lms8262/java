package ch02.sec10;

public class PrimitiveAndStringConversionExample {

	public static void main(String[] args) {
		// 문자열 => 숫자타입으로 변환
		String a = "10";
		int value1 = Integer.parseInt(a); // String => int
		double value2 = Double.parseDouble(a);
		boolean value3 = Boolean.parseBoolean("true");

		System.out.println("value1: " + value1);
		System.out.println("value2: " + value2);
		System.out.println("value3: " + value3);
		
		// 숫자타입 => 문자열
		String str1 = String.valueOf(10); // int => String
		String str2 = String.valueOf(3.14); // double => String
		String str3 = String.valueOf(true);

		System.out.println("str1: " + str1);
		System.out.println("str2: " + str2);
		System.out.println("str3: " + str3);

	}

}
