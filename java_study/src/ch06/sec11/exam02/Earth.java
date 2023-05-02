package ch06.sec11.exam02;

public class Earth {
	// 상수 필드
	// 중요. 상수명은 대문자로 작성한다.(단어가 2개 이상이면 언더바)
	static final double EARTH_RADIUS = 6400;
	static final double EARTH_SURFACE_AREA;

	// 인스턴스 필드
	int personCount;
	
	// 정적블록으로 상수 초기화
	static {
		EARTH_SURFACE_AREA = 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS;
	}
}
