package ch09.sec07.exam01;

public class Car {
	private Tire tire1 = new Tire();
	// private Tire tire2 = new KumhoTire();
	private Tire tire2 = new Tire() {
		@Override
		public void roll() {
			System.out.println("금호 타이어가 굴러갑니다.");
		}
	};
	
	public void run1() {
		tire1.roll();
		tire2.roll();
	}
	
	public void run2() {
		// Tire tire = new HankookTire();
		Tire tire = new Tire() {
			@Override
			public void roll() {
				System.out.println("한국 타이어가 굴러갑니다.");
			}
		};
		tire.roll();
	}
	
	public void run3(Tire tire) {
		tire.roll();
	}
}
