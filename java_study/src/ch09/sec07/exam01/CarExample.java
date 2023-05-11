package ch09.sec07.exam01;

public class CarExample {

	public static void main(String[] args) {
		Car car = new Car();
		car.run1();
		System.out.println();
		car.run2();
		System.out.println();
		// 매개변수에 익명자식객체를 넘겨준다.
		car.run3(new Tire() {
			@Override
			public void roll() {
				System.out.println("자바 타이어가 굴러갑니다.");
			}
		});
	}

}
