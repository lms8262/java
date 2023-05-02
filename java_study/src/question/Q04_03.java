package question;

public class Q04_03 {

	public static void main(String[] args) {
		int result = 0;
		for (int i = 1; i <= 20; i++) {
			if (!(i % 2 == 0) && !(i % 3 == 0)) {
				result += i;
			}
		}
		System.out.println(result);
	}

}
