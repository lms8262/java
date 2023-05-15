package ch12.sec08;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {

	public static void main(String[] args) {
		Date now = new Date();
		String strNow1 = now.toString(); // String 타입으로 변환
		System.out.println(now);
		System.out.println(strNow1);

		// 날짜 모양 포맷
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		String strNow2 = sdf.format(now); // 날짜의 포맷을 변경
		System.out.println(strNow2);

		sdf = new SimpleDateFormat("오늘은 E요일");
		System.out.println(sdf.format(now));

		sdf = new SimpleDateFormat("올해의 D번째 날"); // 365일 기준
		System.out.println(sdf.format(now));

		sdf = new SimpleDateFormat("이달의 d번째 날"); // 1달을 기준
		System.out.println(sdf.format(now));
	}

}
