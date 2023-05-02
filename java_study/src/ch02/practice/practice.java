package ch02.practice;

public class practice {

	public static void main(String[] args) {
		/*
		 * System.out.println("1" + "2"); System.out.println('A' + 'B');
		 * System.out.println('1' + 2); System.out.println('1' + '2');
		 * System.out.println('J' + "ava");
		 */

		byte b = 10;
		char ch = 'A';
		int i = 100;
		long l = 1000L;

		b = (byte) i;
		ch = (char) b;
		short s = (short) ch;
		i = ch;
	}

}
