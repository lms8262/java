package ch09.sec03.exam01;

public class A {
	static class B {
	}

	B field = new B(); // A클래스 내부에서 필드로 객체 생성가능
	static B field2 = new B(); // A클래스 내부에서 정적 필드로 객체 생성가능

	A() {
		B b = new B(); // 생성자 내부에서도 객체 생성 가능
	}

	void method() {
		B b = new B(); // A클래스 메소드 내부에서도 객체 생성 가능
	}

	static void method2() {
		B b = new B(); // A클래스 정적 메소드 내부에서도 객체 생성 가능
	}
}
