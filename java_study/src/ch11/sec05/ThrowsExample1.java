package ch11.sec05;

public class ThrowsExample1 {

	// main에 throw를 하면 JVM에서 알아서 예외처리를 해준다.
	public static void main(String[] args) throws ClassNotFoundException {

		findClass(); // 예외를 던지면 메소드가 실행되는 곳에서 처리해줘야 한다.

	}

	public static void findClass() throws ClassNotFoundException {

		Class.forName("java.lang.String2"); // 예외가 발생하는 곳

	}
}
