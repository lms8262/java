package question.Q06_20;

class Example {
	public static boolean isNumber(String str) {
		if (str == null || str.equals("")) {
			return false;
		}
		// 2번째 방법 toCharArray는 배열을 만들기 때문에 메모리를 더 사용하고 처리 속도가 더 느리다고 함.
//		char[] charArray = str.toCharArray();
//		for(char ch : charArray) {
//			if (!(('0' <= ch) && (ch <= '9'))) {
//				return false;
//			}
//		}
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch < '0' || ch > '9') {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String str = "123";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
		str = "1234o";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
	}
}
