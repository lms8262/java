package StudentInfo;

public class Application {
	School goodSchool = School.getSchool(); // 학교(goodSchool) 싱글톤 객체 생성
	Subject korean; // 국어 과목
	Subject math; // 수학 과목
	GradeOutput gradeOutput = new GradeOutput(); // 

	public static void main(String[] args) {
		Application app = new Application();

		app.createSubject();
		app.createStudent();

		app.gradeOutput.allSubjectScorePrint();
	}

	public void createSubject() {
		// 과목 객체 생성, 학교 필드에 있는 ArrayList에 넣기
		korean = new Subject("국어", 1);
		math = new Subject("수학", 2);
		goodSchool.addSubject(korean);
		goodSchool.addSubject(math);
	}

	public void createStudent() {
		// 학생 생성
		Student student1 = new Student(181213, "박지은", korean);
		Student student2 = new Student(181518, "차슬기", math);
		Student student3 = new Student(171230, "이현욱", korean);
		Student student4 = new Student(171255, "임지연", korean);
		Student student5 = new Student(171590, "김재현", math);

		// 학교 등록
		goodSchool.addStudent(student1);
		goodSchool.addStudent(student2);
		goodSchool.addStudent(student3);
		goodSchool.addStudent(student4);
		goodSchool.addStudent(student5);

		// 국어 과목 수강신청
		korean.register(student1);
		korean.register(student2);
		korean.register(student3);
		korean.register(student4);
		korean.register(student5);

		// 수학 과목 수강신청
		math.register(student1);
		math.register(student2);
		math.register(student3);
		math.register(student4);
		math.register(student5);

		// 국어 과목 점수 입력
		addScore(student1, korean, 95);
		addScore(student2, korean, 95);
		addScore(student3, korean, 100);
		addScore(student4, korean, 89);
		addScore(student5, korean, 83);

		// 수학 과목 점수 입력
		addScore(student1, math, 56);
		addScore(student2, math, 98);
		addScore(student3, math, 88);
		addScore(student4, math, 95);
		addScore(student5, math, 56);
	}

	// 학생별로 각 과목 점수추가하는 메소드
	public void addScore(Student student, Subject subject, int point) {
		Score score = new Score(student.getStudentId(), subject, point);
		student.addSubjectScore(score);
	}

}
