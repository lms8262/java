package ch12.sec06;

public class BoxingUnBoxingExample {

	public static void main(String[] args) {
		// 박싱: primitive(기본) 타입 => 포장 타입으로 변경
		Integer obj = 100;
		int a = 10;
		System.out.println(obj.intValue()); // int 타입으로 변경

		// 언박싱: 포장 타입 => primitive(기본) 타입으로 변경
		int value = obj;
		System.out.println(value);

		// 연산시에는 자동으로 primitive(기본) 타입으로 변경된다
		int result = obj + 100;
	}

}
