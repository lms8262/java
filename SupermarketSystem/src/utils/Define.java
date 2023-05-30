package utils;

public class Define {
	// 직렬화 파일명
	public static final String MEMBER_FILE = "Member.ser";
	public static final String RECEIPT_FILE = "Receipt.ser";

	// 구분선
	public static final String LINE = "----------------------------------------";

	// 회원등급
	public static final String MS_SILVER = "SILVER";
	public static final String MS_GOLD = "GOLD";
	public static final String MS_VIP = "VIP";

	// 포인트 적립 비율
	public static final double POINT_RATIO_SILVER = 0.01;
	public static final double POINT_RATIO_GOLD = 0.03;
	public static final double POINT_RATIO_VIP = 0.05;

	// 회원 등급 업그레이드 기준 누적실적
	public static final int TOTAL_PAYMENT_GOLD = 300000;
	public static final int TOTAL_PAYMENT_VIP = 1000000;

	// 상품 종류
	public static final String DRINK = "음료";
	public static final String FISH = "어류";
	public static final String FRUIT = "과일";
	public static final String MEAT = "육류";
	public static final String SNACK = "과자";
	public static final String VEGETABLE = "야채";

	// 관리자 이름, 비밀번호
	public static final String ADMIN_NAME = "이문수";
	public static final int ADMIN_PASSWORD = 8262;
}
