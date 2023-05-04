package java_modeling.ch01.gip;

//합성관계: 전체가 사라지면 부분도 사라진다.
public class Computer {
	private MainBoard mb;
	private CPU c;
	private Memory m;
	private PowerSupply ps;

	public Computer() {
		// 생성자에서 필드에 값을 넣어준다.
		this.mb = new MainBoard();
		this.c = new CPU();
		this.m = new Memory();
		this.ps = new PowerSupply();
	}
}
