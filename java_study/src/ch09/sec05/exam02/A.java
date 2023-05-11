package ch09.sec05.exam02;

public class A {
	// A클래스의 인스턴스 필드
	String field = "A-field";

	// A클래스의 인스턴스 메소드
	void method() {
		System.out.println("A-method");
	}

	void useB() {
		B b = new B();
		b.print();
	}

	class B {
		// B클래스의 인스턴스 필드
		String field = "B-field";

		// B클래스의 인스턴스 메소드
		void method() {
			System.out.println("B-method");
		}

		void print() {
			// B 클래스의 필드와 메소드 사용
			System.out.println(this.field);
			this.method();

			// A 클래스의 필드와 메소드 사용
			System.out.println(A.this.field);
			A.this.method();
		}
	}
}
