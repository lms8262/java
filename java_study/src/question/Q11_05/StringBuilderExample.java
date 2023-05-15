package question.Q11_05;

public class StringBuilderExample {

	public static void main(String[] args) {
		StringBuilder stb = new StringBuilder();
		for (int i = 0; i <= 100; i++) {
			stb.append(i);
		}
		System.out.println(stb.toString());
	}

}
