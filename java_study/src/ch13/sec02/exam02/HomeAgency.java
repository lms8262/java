package ch13.sec02.exam02;

public class HomeAgency implements Rentable<Home> {

	@Override
	public Home rent() { // 리턴타입이 Home이어야 한다.
		return new Home();
	}

}
