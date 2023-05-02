package ch06.sec07.exam01;

public class CarExample {

	public static void main(String[] args) {
		// 중요. 인스턴스(객체)가 생성될때 생성자가 실행된다.
		Car myCar = new Car("그렌저", "검정", 250);
		
	System.out.println(myCar.model);
	System.out.println(myCar.color);
	System.out.println(myCar.maxSpeed);
	}

}
