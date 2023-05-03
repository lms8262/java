package ch08.sec12;

public class InstanceofExample {

	public static void main(String[] args) {
		Taxi taxi = new Taxi();
		Bus bus = new Bus();

		ride(taxi);
		System.out.println();
		ride(bus);
	}

	public static void ride(Vehicle vehicle) {
		// vehicle 객체가 Bus 객체를 참조하는가? => 자동타입변환 되었는가?
		if (vehicle instanceof Bus) {
			Bus bus = (Bus) vehicle;

			// 자식 클래스에 있는 고유의 메소드, 필드 사용 가능
			bus.checkFare();
		}
		vehicle.run();
	}

}
