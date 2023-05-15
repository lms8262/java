package ch13.sec02.exam02;

public class CarAgency implements Rentable<Car> {

	@Override
	public Car rent() { // 리턴타입이 Car가 되어야한다.
		return new Car();
	}

}
