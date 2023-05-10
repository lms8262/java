package ch14.sec03.exam01;

public class ThreadNameExample {

	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread(); // main 메소드의 스레드 객체를 얻어온다.
		System.out.println(mainThread.getName()+ "실행");

		for (int i = 0; i < 3; i++) {
			Thread threadA = new Thread() {
				@Override
				public void run() {
					System.out.println(getName() + "실행");
				}
			};
			threadA.start();
		}

		Thread chatThread = new Thread() {
			@Override
			public void run() {
				System.out.println(getName() + "실행");
			}
		};
		// 스레드의 이름지정: 스레드가 시작되기전에 지정을 해준다.
		chatThread.setName("chat-thread");
		chatThread.start();
	}

}
