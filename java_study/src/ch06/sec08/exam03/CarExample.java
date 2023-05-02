package ch06.sec08.exam03;

public class CarExample {

	public static void main(String[] args) {
		// 인스턴스 생성될때 생성자가 실행된다.
		Car myCar = new Car();

		// 휘발유 넣어줌
		myCar.setGas(5);
		
		if (myCar.isLeftGas()) {
			// 가스가 있을때
			System.out.println("출발합니다.");
			myCar.run();
		}
		System.out.println("gas를 주입하세요.");
	}

}
