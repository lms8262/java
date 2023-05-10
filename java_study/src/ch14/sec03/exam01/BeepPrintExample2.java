package ch14.sec03.exam01;

import java.awt.Toolkit;

public class BeepPrintExample2 extends Thread {
	@Override
	public void run() {
		// 실행시킬 코드
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // 비프음 발생시키기 위한 객체
		for (int i = 0; i < 5; i++) {
			toolkit.beep(); // 비프음 발생
			try {
				Thread.sleep(500); // 1초 = 1000
			} catch (Exception e) {

			}
		}
	}

	public static void main(String[] args) {

		Thread thread = new BeepPrintExample2();

		thread.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500); // 1초 = 1000
			} catch (Exception e) {

			}
		}
	}

}
