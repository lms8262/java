package ch13.sec03.exam01;

public class GenericExample {
	// 제네릭 메소드
	public static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<>();
		box.setT(t);
		return box;
	}

	public static void main(String[] args) {
		Box<String> box1 = boxing("홍길동");
		System.out.println(box1.getT());
	}

}
