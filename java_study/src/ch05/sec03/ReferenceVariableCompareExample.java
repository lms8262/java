package ch05.sec03;

public class ReferenceVariableCompareExample {

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 1, 2, 3 };
		int[] arr3;

		// arr3는 arr2와 같은 주소를 가지고 있다.
		arr3 = arr2;

		// 주소를 비교한다.
		System.out.println(arr1 == arr2);
		System.out.println(arr2 == arr3);
	}

}
