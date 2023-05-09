package application;

import school.*;
import school.report.GenerateGradeReport;
import utils.Define;

public class StudentInfoApplication {
	School goodSchool = School.getInstance(); // 학교 생성
	Subject korean; // 국어 과목
	Subject math; // 수학 과목
	GenerateGradeReport gradeReport = new GenerateGradeReport();

	public static void main(String[] args) {
		StudentInfoApplication test = new StudentInfoApplication();

		test.createSubject(); // 과목 생성
		test.createStudent(); // 학생 생성

		String report = test.gradeReport.getReport(); // 성적 결과 생성
		System.out.println(report);
	}

	// 과목 생성하는 메소드
	public void createSubject() {
		korean = new Subject("국어", Define.KOREA); // 국어 생성
		math = new Subject("수학", Define.MATH); // 수학 생성

		// 학교에 과목을 등록
		goodSchool.addSubject(korean);
		goodSchool.addSubject(math);
	}

	// 학생 생성하는 메소드
	public void createStudent() {
		// 학생 생성
		Student student1 = new Student(181213, "박지은", korean);
		Student student2 = new Student(181518, "차슬기", math);
		Student student3 = new Student(171230, "이현욱", korean);
		Student student4 = new Student(171255, "임지연", korean);
		Student student5 = new Student(171590, "김재현", math);

		// 학교에 학생 등록
		goodSchool.addStudent(student1);
		goodSchool.addStudent(student2);
		goodSchool.addStudent(student3);
		goodSchool.addStudent(student4);
		goodSchool.addStudent(student5);

		// 수강신청
		korean.register(student1);
		korean.register(student2);
		korean.register(student3);
		korean.register(student4);
		korean.register(student5);
		math.register(student1);
		math.register(student2);
		math.register(student3);
		math.register(student4);
		math.register(student5);

		// 학생의 시험 점수 등록

		// 박지은 학생의 국어, 수학 점수 등록
		addScoreForStudent(student1, korean, 95);
		addScoreForStudent(student1, math, 56);

		// 차슬기 학생의 국어, 수학 점수 등록
		addScoreForStudent(student2, korean, 95);
		addScoreForStudent(student2, math, 98);

		// 이현욱 학생의 국어, 수학 점수 등록
		addScoreForStudent(student3, korean, 100);
		addScoreForStudent(student3, math, 88);

		// 임지연 학생의 국어, 수학 점수 등록
		addScoreForStudent(student4, korean, 89);
		addScoreForStudent(student4, math, 95);

		// 김재현 학생의 국어, 수학 점수 등록
		addScoreForStudent(student5, korean, 83);
		addScoreForStudent(student5, math, 56);
	}

	// 학생의 시험점수 등록하는 메소드
	public void addScoreForStudent(Student student, Subject subject, int point) {
		Score score = new Score(student.getStudentId(), subject, point);
		student.addSubjectScore(score); // 해당 학생의 점수를 저장
	}
}
