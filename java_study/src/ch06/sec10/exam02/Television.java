package ch06.sec10.exam02;

public class Television {
	// 정적 필드는 필드 선언과 동시에 초기값을 주는게 일반적이다.
	static String company = "MyCompany";
	static String model = "LCD";
	static String info;
	
	// 정적 블록: 연산 등 복잡한 초기화 작업이 필요할 때 사용
	static {
		info = company + "-" + model;
	}
}
