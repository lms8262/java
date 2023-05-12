package ch12.sec05;

public class StringBuilderExample {

	public static void main(String[] args) {
		// StringBuilder : 문자열 추가, 삭제 할때 주로 쓴다. => 동기화 지원이 안됨
		// StringBuffer : 문자열 추가, 삭제 할때 주로 쓴다. => 동기화 지원이 된다
		String data = new StringBuilder() //
				.append("DEF") // 문자열의 맨 끝에 추가
				.insert(0, "ABC") //
				.delete(3, 4) // delete(시작위치, 끝위치)
				.toString(); // StringBuilder => String 타입으로 변경

		System.out.println(data);
	}

}
