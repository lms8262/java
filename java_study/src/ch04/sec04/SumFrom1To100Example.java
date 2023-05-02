package ch04.sec04;

public class SumFrom1To100Example {

	public static void main(String[] args) {
		int sum = 0;
		
		for(int i=0; i<=100; i++) {
			System.out.println(i);
			sum += i; // sum = sum + i
		}
		
		System.out.println(sum);
	}

}
