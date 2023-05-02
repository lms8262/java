package ch06.sec12.hyundai;

import ch06.sec12.hankook.*; // 모든 하위 클래스를 가져온다.
import ch06.sec12.kumho.AllSeasonTire;

public class Car {

	// 1) 패키지명.클래스
	// ch06.sec12.hankook.Tire tire1 = new ch06.sec12.hankook.Tire();
	Tire tire1 = new Tire();
	SnowTire snow1 = new SnowTire();
	AllSeasonTire allSeasonTire = new AllSeasonTire();
}
