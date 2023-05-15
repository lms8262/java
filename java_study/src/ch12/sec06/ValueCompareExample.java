package ch12.sec06;

public class ValueCompareExample {

	public static void main(String[] args) {
		Integer obj1 = 300;
		Integer obj2 = 300;

		System.out.println(obj1 == obj2); // 주소를 비교
		System.out.println(obj1.equals(obj2)); // 값을 비교

		// Byte, Short, Integer는 -128 ~ 127 사이의 값을 비교시 주소를 비교하지 않고 값을 비교한다.
		Integer obj3 = 10;
		Integer obj4 = 10;
		System.out.println(obj3 == obj4);
		System.out.println(obj3.equals(obj4));
	}

}
