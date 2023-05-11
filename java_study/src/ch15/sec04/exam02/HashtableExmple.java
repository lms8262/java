package ch15.sec04.exam02;

import java.util.Hashtable;
import java.util.Map;

public class HashtableExmple {

	public static void main(String[] args) {
		Map<String, Integer> map = new Hashtable<>();

		Thread threadA = new Thread() {
			@Override
			public void run() {
				for (int i = 1; i <= 1000; i++)
					map.put(String.valueOf(i), i);
			}

		};

		Thread threadB = new Thread() {
			@Override
			public void run() {
				for (int i = 1001; i <= 2000; i++)
					map.put(String.valueOf(i), i);
			}

		};

		// 스레드 실행
		threadA.start();
		threadB.start();

		try {
			// A, B 스레드가 종료될때까지 메인스레드를 기다리게 한다.
			threadA.join();
			threadB.join();
		} catch (Exception e) {
			
		}
		
		int size = map.size();
		System.out.println(size);
	}

}
