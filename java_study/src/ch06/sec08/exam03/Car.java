package ch06.sec08.exam03;

public class Car {
	// 필드
	int gas;

	// 생성자 Car(){} 중요. 인스턴스가 생성될때 한번만 실행!
	/*
	 * Car(int gas) { System.out.println("생성자 실행!"); this.gas = gas; }
	 */

	// 메소드 중요. 메소드는 여러번 실행된다.
	void setGas(int gas) { // 휘발유를 채워넣는다.
		this.gas = gas;
	}

	boolean isLeftGas() { // 휘발유의 잔량을 보여줌.
		if (gas == 0) {
			System.out.println("gas가 없습니다.");
			return false; // 메소드 종료
		}
		System.out.println("gas가 있습니다.");
		return true; // 메소드 종료
	}

	void run() { // 자동차가 달린다(휘발유 소모).
		while (true) {
			if (gas > 0) { // 가스가 있음
				System.out.println("달립니다. gas 잔량: " + gas);
				gas -= 1; // 1씩 가스 소모
			} else { // 가스가 없음
				System.out.println("멈춥니다. gas 잔량: " + gas);
				return; // 메소드 종료
			}
		}
	}
}
