package ch08.sec07;

public interface Service {
	default void defalutMethod1() {
		System.out.println("defalutMethod1 종속 코드");
		deaultCommon();
	}

	default void defalutMethod2() {
		System.out.println("defalutMethod2 종속 코드");
		deaultCommon();
	}

	// private 메소드 => 사용할 때 구현 객체가 필요하다.
	private void deaultCommon() {
		System.out.println("defaultMethod 종복 코드A");
		System.out.println("defaultMethod 종복 코드B");
	}

	static void staticMethod1() {
		System.out.println("staticMethod1 종속 코드");
		staticCommon();
	}

	static void staticMethod2() {
		System.out.println("staticMethod2 종속 코드");
		staticCommon();
	}

	private static void staticCommon() {
		System.out.println("staticMethod 중복 코드 C");
		System.out.println("staticMethod 중복 코드 D");
	}
}
