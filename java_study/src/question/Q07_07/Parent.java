package question.Q07_07;

public class Parent {
	public String nation;

	public Parent() {
		this("대한민국");
		System.out.println("Parent() call"); // 3번
	}

	public Parent(String nation) {
		// 2번
		this.nation = nation;
		System.out.println("Parent(String nation) call");
	}
}
