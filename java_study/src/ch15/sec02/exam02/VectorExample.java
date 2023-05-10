package ch15.sec02.exam02;

import java.util.Vector;

public class VectorExample {

	public static void main(String[] args) {
		Vector<Board> list = new Vector<>();

		Thread threadA = new Thread() {
			@Override
			public void run() {
				// list에 1000개의 board객체를 추가
				for (int i = 1; i <= 1000; i++) {
					list.add(new Board("제목" + i, "내용" + i, "글쓴이" + i));
				}
			}
		};

		Thread threadB = new Thread() {
			@Override
			public void run() {
				// list에 1000개의 board객체를 추가
				for (int i = 1001; i <= 2000; i++) {
					list.add(new Board("제목" + i, "내용" + i, "글쓴이" + i));
				}
			}
		};

		threadA.start();
		threadB.start();

		// threadA, threadB가 종료될때까지 메인메소드를 기다리게 함
		try {
			threadA.join();
			threadB.join();
		} catch (Exception e) {
		}
		int size = list.size();
		System.out.println("총 객체 수: " + size);
	}

}
