package java_modeling.ch01.gip;

//합성 관계
public class Computer {
	private MainBoard mb;
	private CPU c;
	private Memory m;
	private PowerSupply ps;
	
	public Computer() {
		this.mb = new MainBoard();
		this.c = new CPU();
		this.m = new Memory();
		this.ps = new PowerSupply();
	}
}

