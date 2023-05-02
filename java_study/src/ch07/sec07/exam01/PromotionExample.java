package ch07.sec07.exam01;

class A {
}

class B extends A {
}

class C extends A {
}

class D extends B {
}

class E extends C {
}

public class PromotionExample {
	public static void main(String[] args) {
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();

		// 자동타입변환
		A a1 = b; // 자식 - 부모
		A a2 = c;
		A a3 = d; // 손주 - 할아버지
		A a4 = e;

		// 상속관계가 아닌 자동타입변환은 에러가 발생한다.
		// B b3 = e;
		// C c2 = d;
	}

}
