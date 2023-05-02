package ch07.sec08.exam02;

public class Driver {
	// Vehicle 타입의 매개변수를 가지고 있다.
	public void drive(Vehicle vehicle) {
		// Vehicle vehicle = new Bus();
		// Vehicle vehicle = new Taxi();
		vehicle.run();
	}
}
