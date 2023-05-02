package ch07.sec04.exam02;

public class SupersonicAirplane extends Airplane {
	// 상수 필드
	public static final int NORMAL = 1;
	public static final int SUPERSONIC = 2;

	// 인스턴스 필드
	public int flyMode = NORMAL;

	@Override
	public void fly() {
		if (flyMode == SUPERSONIC) {
			System.out.println("초음속 비행합니다.");
		} else {
			// 부모 클래스에 있는 메소드를 호출한다.
			super.fly();
		}
	}

}
