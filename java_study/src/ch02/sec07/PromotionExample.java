package ch02.sec07;

public class PromotionExample {

	public static void main(String[] args) {
		byte byteValue = 10; // 00001010
		int intValue = byteValue; // 00000000 00000000 00000000 00001010
		System.out.println(intValue);

		char charValue = 'A'; // 65
		intValue = charValue;
		System.out.println(intValue);

		byteValue = 65;
		charValue = byteValue;

		// 00000000 00000000 00000000 00110010
		intValue = 50;

		// 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00110010
		long longValue = intValue;
		System.out.println(longValue);

		longValue = 100;
		float floatValue = longValue;
		System.out.println(floatValue);

		floatValue = 100.5F;
		double doubleValue = floatValue;
		System.out.println(doubleValue);

	}

}
