package ch06.sec08.exam04;

public class CalculatorExample {

	public static void main(String[] args) {
		// 인스턴스 생성
		Calculator myClac = new Calculator();
		
		double result = myClac.areaRectangle(10);
		double result2 = myClac.areaRectangle(10,20);
		
		System.out.println("정사각형의 넓이:" + result);
		System.out.println("직사각형의 넓이:" + result2);
	}

}
