package ch08.sec02;

public interface RemoteControl {
	// 인터페이스는 상수 + 추상메소드 => 상속만을 위해 쓰인다.

	// 상수 => 인터페이스는 public static final을 붙이지 않아도 모든 필드를 상수로 인식한다.
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;

	// 추상 메소드
	void turnOn();

	void turnOff();

	void setVolume(int volume);

	// 디폴트 인스턴스 메소드
	default void setMute(boolean mute) {
		if (mute) {
			System.out.println("무음 처리합니다.");
			setVolume(MIN_VOLUME); // 추상 메소드 호출
		} else {
			System.out.println("무음 해제합니다.");
		}
	}

	// 정적 메소드
	static void changeBatterty() {
		System.out.println("리모콘 건전지를 교환합니다.");
	};

}
