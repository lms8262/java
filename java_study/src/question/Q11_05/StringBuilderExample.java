package question.Q11_05;

public class StringBuilderExample {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= 100; i++) {
			sb.append(i);
		}
		System.out.println(sb.toString());
	}

}
