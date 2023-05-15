package question.Q11_06;

import java.util.StringTokenizer;

public class StringTokenizerExample {

	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("아이디,이름,패스워드", ",");
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

}
