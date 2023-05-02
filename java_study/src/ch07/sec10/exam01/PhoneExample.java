package ch07.sec10.exam01;

public class PhoneExample {

	public static void main(String[] args) {
		// 중요. 추상 클래스는 객체를 생성할 수 없다.
		// Phone phone = new Phone();

		SmartPhone smartPhone = new SmartPhone("홍길동");
		smartPhone.turnOn();
		smartPhone.internetSearch();
		smartPhone.turnOff();
	}

}
