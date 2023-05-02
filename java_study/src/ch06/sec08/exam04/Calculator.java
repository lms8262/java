package ch06.sec08.exam04;

public class Calculator {
	// 메소드 오버로딩: 같은 이름을 가진 메소드가 여러개
	// => 기능은 같은데 메소드 안의 코드가 달라야 할때
	// 1. 메소드 이름은 무조건 같아야 한다.
	// 2. 단, 매개변수의 타입, 개수, 순서 중 하나는 달라야 한다.

	// 정사각형의 넓이 구하기
	double areaRectangle(double width) {
		return width * width; // 사각형의 넓이 구하기
	}

	// 직사각형의 넓이 구하기
	double areaRectangle(double width, double height) {
		return width * height; // 사각형의 넓이 구하기
	}
}
