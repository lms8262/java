package question;

public class Q04_01 {

	public static void main(String[] args) {
		char ch = 'a';
		boolean a = !((ch == ' ')||(ch == '\t'));
		System.out.println(a);
		
		boolean powerOn = false;
		
		if(!powerOn) {
			System.out.println("출력");
		}
		
		String str = "yes";
		if(str.equals("yes")) {
			System.out.println("출력");
		}
	}

}
