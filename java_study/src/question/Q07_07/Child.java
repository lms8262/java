package question.Q07_07;

public class Child extends Parent {
	public String name;

	public Child() {
		// 1번: 부모생성자 실행
		this("홍길동"); // 4번
		System.out.println("Child() call"); // 6번
	}

	public Child(String name) {
		this.name = name;
		System.out.println("child(String name) call"); // 5번
	}
}
