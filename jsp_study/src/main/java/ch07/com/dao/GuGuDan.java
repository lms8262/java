package ch07.com.dao;

public class GuGuDan {
	public String process(int num) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 9; i++) {
			sb.append(num + "*" + i + "=" + num * i + "<br>");
		}
		return sb.toString();
	}

}
