package ch07.sec09;

public class Student extends Person {
	// 필드
	public int studentNo;

	// 생성자
	public Student(String name, int studentNo) {
		super(name); // 부모 클래스의 생성자 호출
		this.studentNo = studentNo;
	}

	// 메소드
	public void study() {
		System.out.println("공부를 합니다.");
	}
}