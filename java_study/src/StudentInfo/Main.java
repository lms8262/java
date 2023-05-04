package StudentInfo;

public class Main {

	public static void main(String[] args) {
		// goodSchool 객체 생성
		School goodSchool = School.getSchool();

		// 과목 객체 생성
		Subject korean = new Subject("국어", 1);
		Subject math = new Subject("수학", 2);

		// 학생 객체 생성
		Student park = new Student(181213, "박지은", korean);
		Student cha = new Student(181518, "차슬기", math);
		Student lee = new Student(171230, "이현욱", korean);
		Student lim = new Student(171255, "임지연", korean);
		Student kim = new Student(171590, "김재현", math);

	}

}
