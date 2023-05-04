package java_modeling.ch01.gip;

//집약관계: 관계가 사라져도 부분은 사라지지 않는다.
public class Computer2 {
	private MainBoard mb;
	private CPU c;
	private Memory m;
	private PowerSupply ps;

	public Computer2(MainBoard mb, CPU c, Memory m, PowerSupply ps) {
		// 생성자에서 매개변수로 값을 넣어준다.
		this.mb = mb;
		this.c = c;
		this.m = m;
		this.ps = ps;
	}
}
