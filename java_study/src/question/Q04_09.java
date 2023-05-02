package question;

public class Q04_09 {

	public static void main(String[] args) {
		int answer = (int)(Math.random() * 100 + 1);
		int input = 0;
		int count = 0;
		// 화면으로 부터 사용자입력을 받기 위해서 Scanner클래스 사용
		java.util.Scanner s = new java.util.Scanner(System.in);
		do {
			count++;
			System.out.print("1과 100사이의 값을 입력하세요: ");
			input = s.nextInt(); // 입력받은 값을 변수 input에 저장한다.
			if (answer > input) {
				System.out.println("더 큰 수를 입력하세요.");
			} else if (answer < input) {
				System.out.println("더 작은 수를 입력하세요.");				
			} else {
				System.out.println("정답입니다.");
				System.out.println(count + "번 만에 맞추셨습니다.");
				break;
			}
		} while (true); // 무한반복문
	} //end of main

}
