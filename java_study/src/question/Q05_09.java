package question;

public class Q05_09 {

	public static void main(String[] args) {
		int[][] array = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };
		int totalSum = 0;
		int totalNum = 0;
		for (int i = 0; i < array.length; i++) {
			totalNum += array[i].length;
			for (int j = 0; j < array[i].length; j++) {
				totalSum += array[i][j];
			}
		}
		double avg = (double) totalSum / totalNum;
		System.out.println("전체 합: " + totalSum);
		System.out.println("평균: " + avg);
	}

}
