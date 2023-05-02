package ch07.sec10.exam02;

public class Cat extends Animal {
	/*
	 * Cat(String owner) { super(owner); }
	 */

	// 중요. 추상 클래스가 부모 클래스일때 추상 메소드가 있으면
	// 반드시 오버라이드(재정의)를 해야한다.
	@Override
	public void sound() {
		System.out.println("야옹");
	}

}
