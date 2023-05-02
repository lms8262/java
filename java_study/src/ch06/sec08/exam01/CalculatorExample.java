package ch06.sec08.exam01;

public class CalculatorExample {

	public static void main(String[] args) {

		// 인스턴스(객체) 생성
		Calculator myCalc = new Calculator();

		// 인스턴스명.메소드명();
		myCalc.powerOn();

		int result1 = myCalc.plus(5, 6);
		System.out.println(result1);

		int x = 10, y = 4;
		double result2 = myCalc.divide(x, y);
		System.out.println(result2);
		
		myCalc.powerOff();
	}

}
