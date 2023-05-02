package ch06.sec11.exam02;

public class EarthExample {

	public static void main(String[] args) {
		Earth earth1 = new Earth();
		earth1.personCount = 70;
		System.out.println(earth1.personCount + "억 지구1");

		Earth earth2 = new Earth();
		earth2.personCount = 90;
		System.out.println(earth2.personCount + "억 지구2");

		// static이므로 '클래스명.필드명' 으로 접근한다.
		System.out.println("지구 반지름: " + Earth.EARTH_RADIUS);
		System.out.println("지구 표면적: " + Earth.EARTH_SURFACE_AREA);

		// final이므로 바꿀 수 없다.
		// Earth.EARTH_RADIUS = 111;
	}
}
