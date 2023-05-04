package java_modeling.ch01.gip;

//집약 관계
public class Computer2 {
	private MainBoard mb;
	private CPU c;
	private Memory m;
	private PowerSupply ps;
	
	public Computer2(MainBoard mb, CPU c, Memory m, PowerSupply ps) {
		this.mb = mb;
		this.c = c;
		this.m = m;
		this.ps = ps;
	}
}
