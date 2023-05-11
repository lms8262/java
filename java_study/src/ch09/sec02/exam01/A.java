package ch09.sec02.exam01;

public class A {
	class B {
	} // 인스턴스 멤버 클래스

	B field = new B(); // A클래스 내부에서 필드로 객체 생성가능

	A() {
		B b = new B(); // 생성자 내부에서도 객체 생성 가능
	}

	void method() {
		B b = new B(); // A클래스 메소드 내부에서도 객체 생성 가능
	}
}
