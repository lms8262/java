package ch12.sec03.exam02;

public class HashCodeExample {

	public static void main(String[] args) {
		// 동등객체 : 객체도 같아야하고(객체의 주소로 안다), 값도 같아야 한다.
		Student s1 = new Student(1, "홍길동");
		Student s2 = new Student(1, "홍길동");

		if (s1.hashCode() == s2.hashCode()) {
			if (s1.equals(s2)) {
				System.out.println("동등 객체입니다.");
			} else {
				System.out.println("데이터가 다르므로 동등객체가 아닙니다.");
			}
		} else {
			System.out.println("해시코드가 다르므로 동등객체가 아닙니다.");
		}
	}

}
