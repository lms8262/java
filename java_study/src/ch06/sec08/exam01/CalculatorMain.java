package ch06.sec08.exam01;

public class CalculatorMain {

	// 리턴값이 없는 메소드
	public static void powerOn() {
		System.out.println("전원을 켭니다.");
	}

	public static int plus(int x, int y) {
		int result = x + y;
		return result;
	}

	public static void main(String[] args) {
		powerOn();
		int result = plus(10,20);
		System.out.println(result);
	}

}
