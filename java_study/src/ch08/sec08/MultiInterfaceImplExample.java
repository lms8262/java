package ch08.sec08;

public class MultiInterfaceImplExample {

	public static void main(String[] args) {
		// RemoteControl에 선언된 메소드만 사용가능
		RemoteControl rc = new SmartTelevision();
		rc.turnOn();
		rc.turnOff();
		
		// Searchable에 선언된 메소드만 사용가능
		Searchable searchable = new SmartTelevision();
		searchable.search("https://www.naver.com");
	}

}
