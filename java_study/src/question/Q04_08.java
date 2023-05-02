package question;

public class Q04_08 {

	public static void main(String[] args) {
		String str = "*";
		for (int x = 1; x <= 5; x++) {
			for (int y = 1; y <= x; y++) {
				System.out.print(str);			
			}
			System.out.println();
		}
	}

}
