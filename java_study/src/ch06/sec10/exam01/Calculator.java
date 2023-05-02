package ch06.sec10.exam01;

public class Calculator {
	// 정적(static) 필드: 프로그램 전체에서 쓰이는 필드
	static double pi = 3.14;

	// 정적(static) 메소드: 프로그램 전체에서 쓰이는 메소드
	static int plus(int x, int y) {
		return x + y;
	}

	static int minus(int x, int y) {
		return x - y;
	}

	void printPi() {
		System.out.println(pi);
	}
}
