package ch07.sec08.exam01;

public class Car {
	// 필드(객체의 속성)
	public Tire tire;

	// 메소드(기능)
	public void run() {

		// tire 필드에 어떤 타이어가 올지 모르지만
		// 대입된 객체의 roll을 호출한다.
		// 메소드 오버라이딩
		tire.roll();
	}
}
