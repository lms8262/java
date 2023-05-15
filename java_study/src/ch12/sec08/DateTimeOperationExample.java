package ch12.sec08;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeOperationExample {

	public static void main(String[] args) {
		// Date, Calendar: 날짜를 보여줄때
		// LocalDateTime: 날짜 연산이 가능하다.
		LocalDateTime now = LocalDateTime.now(); // 현재 날짜를 구해준다.
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");

		System.out.println("현재시간: " + now.format(dtf));
		LocalDateTime result1 = now.plusYears(1); // 1년 후
		System.out.println(result1.format(dtf));

		LocalDateTime result2 = now.plusHours(10); // 10시간 후
		System.out.println(result2.format(dtf));

		LocalDateTime result3 = now.minusMonths(2); // 2달 전
		System.out.println(result3.format(dtf));

		LocalDateTime result4 = now.plusDays(7); // 7일 후
		System.out.println(result4.format(dtf));

	}

}
