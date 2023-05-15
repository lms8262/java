package ch12.sec07;

import java.util.Arrays;
import java.util.Random;

public class RandomExample {

	public static void main(String[] args) {
		// 두 정수 사이의 랜덤 값 구하는 공식(start부터 시작하는 n개의 정수_
		// 값 = (int) (Math.rendom() * n) + start;

		// 선택번호
		int[] selectNumber = new int[6];
		Random random = new Random(3);

		System.out.print("선택번호: ");
		for (int i = 0; i < selectNumber.length; i++) {
			selectNumber[i] = random.nextInt(45) + 1;
			System.out.print(selectNumber[i] + " ");
		}
		System.out.println();

		// 당첨번호
		int[] winningNumber = new int[6];
		random = new Random(5);
		System.out.print("당첨번호: ");
		for (int i = 0; i < winningNumber.length; i++) {
			winningNumber[i] = random.nextInt(45) + 1;
			System.out.print(winningNumber[i] + " ");
		}
		System.out.println();

		// 당첨여부
		Arrays.sort(selectNumber); // 배열 정렬(오름차순)
		Arrays.sort(winningNumber);

		boolean result = Arrays.equals(selectNumber, winningNumber); // 배열 항목 비교
		System.out.print("당첨여부: ");
		if (result) {
			System.out.println("1등에 당첨되셨습니다.");
		} else {
			System.out.println("당첨되지 않았습니다.");
		}
		
	}

}
