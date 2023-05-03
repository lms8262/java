package ch08.sec10.exam01;

public class PromotionExample {

	public static void main(String[] args) {
		// 자동타입변환(부모 클래스가 자식 클래스를 참조한다.)
		A a1 = new B();
		A a2 = new C();
		A a3 = new D();
		A a4 = new E();
	}

}
