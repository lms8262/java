package ch06.sec10.exam03;

public class Car {
	// 인스턴스 필드
	int speed;

	// 정적(static) 필드
	static int gas;

	// 인스턴스 메소드
	// 인스턴스 메소드에서는 인스턴스 필드, 정적 필드 다 사용할 수 있다.
	void run() {
		System.out.println(speed + "으로 달립니다.");
		// System.out.println("가스양: " + gas);
	}

	// 인스턴스 메소드에서는 인스터스 메소드, 정적 메소드 다 사용할 수 있다.
	void run2() {
		System.out.println(speed + "으로 달립니다.");
		// System.out.println("가스양: " + gas);
		run(); // 인스턴스 메소드
		simulate(); // 정적 메소드
	}

	// 정적(static) 메소드
	static void simulate() {
		// 정적 메소드에서는 인스턴스 필드를 사용할 수 없다.
		// System.out.println(speed + "으로 달립니다.");

		// 정적 메소드에서 정적 필드, 정적 메소드만 사용 가능
		// System.out.println("가스양: " + gas);
		// simulate2();

		// 정적 메소드에서 인스턴스 메소드를 사용할 수 없다.
		// run();

		// 중요. 정적 메소드에서 인스턴스 멤버를 사용하기 위해서는 객체를 생성해서 사용해야 한다.
		Car myCar = new Car();
		myCar.speed = 60;
		myCar.run();
	}

	static void simulate2() {
		System.out.println("가스양: " + gas);
	}

	// 리턴 타입이 없는 정적 메소드
	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.speed = 60;
		myCar.run();
		
		System.out.println(Car.gas);
		Car.simulate2();
	}

}
