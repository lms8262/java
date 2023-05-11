package ch09.sec02.exam01;

public class AExample {

	public static void main(String[] args) {
		A a = new A();

		// 외부에서 중첩된 클래스에 객체를생성하는 방법
		A.B b = a.new B();
	}

}
