package ch05.sec04;

public class GarbageObjectExample {

	public static void main(String[] args) {
		String hobby = "여행"; // 주소를 가지고 있다.
		hobby = null; // 주소를 가지고 있지 않다.

		String kind1 = "자동차";
		String kind2 = kind1;
		kind1 = null;
		System.out.println(kind2);

	}

}
