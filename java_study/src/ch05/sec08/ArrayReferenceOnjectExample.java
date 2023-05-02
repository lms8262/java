package ch05.sec08;

public class ArrayReferenceOnjectExample {

	public static void main(String[] args) {
		String[] strArray = new String[3];
		strArray[0] = "java"; // 10번지
		strArray[1] = "java"; // 10번지
		strArray[2] = new String("java"); // 20번지

		System.out.println(strArray[0] == strArray[1]); // 주소가 같다.
		System.out.println(strArray[0] == strArray[2]); // 주소가 다르다.
		System.out.println(strArray[0].equals(strArray[2])); // 값은 같다.
		
	}

}
