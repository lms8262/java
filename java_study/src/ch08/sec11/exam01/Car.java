package ch08.sec11.exam01;

public class Car {
	// 필드의 다형성을 이용
	Tire tire1 = new HankookTire(); // 자동타입변환
	Tire tire2 = new HankookTire();

	// 메소드
	void run() {
		tire1.roll();
		tire2.roll();
	}
}
