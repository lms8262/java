package ch07.sec10.exam01;

// 추상클래스
/*
 1. 상속을 하기 위해 만들어진 클래스(추상 클래스가 부모 클래스가 된다.)
 2. 완전하지 않은 클래스 -> 추상메소드를 가지므로(뒤에가서...)
 */
public abstract class Phone {
	// 필드
	String owner;
	
	// 생성자
	Phone(String owner) {
		this.owner = owner;
	}
	
	// 메소드
	void turnOn() {
		System.out.println("폰 전원을 켭니다.");
	}
	
	void turnOff() {
		System.out.println("폰 전원을 끕니다.");
	}
}
