package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import school.School;
import school.Score;
import school.Student;
import school.Subject;
import school.report.GenerateGradeReport;
import utils.Define;

public class StudentInfoApplicationWithFile {
	School goodSchool = School.getInstance(); // 학교 객체 생성(싱글톤)
	Subject korean;
	Subject math;
	GenerateGradeReport gradeReport = new GenerateGradeReport();

	public static void main(String[] args) throws Exception {
		StudentInfoApplicationWithFile test = new StudentInfoApplicationWithFile();

		test.createSubject();
		test.createStudent();

		String report = test.gradeReport.getReport();
		System.out.println(report);
	}

	public void createSubject() {
		korean = new Subject("국어", Define.KOREA);
		math = new Subject("수학", Define.MATH);

		goodSchool.addSubject(korean);
		goodSchool.addSubject(math);
	}

	public void createStudent() throws Exception {
		FileInputStream is = new FileInputStream("studentinfo.txt");
		// File is = null;
		Scanner scanner = new Scanner(is);

		String name;
		int id;
		int koreanScore;
		int mathScore;
		int majorCode;
		Student student = null;

		try (is; scanner) {
			// is = new File("studentinfo.txt");

			// 라인에 데이터가 있으면 실행
			while (scanner.hasNextLine()) {
				name = scanner.next();
				id = scanner.nextInt();
				koreanScore = scanner.nextInt();
				mathScore = scanner.nextInt();
				majorCode = scanner.nextInt();

				if (majorCode == Define.KOREA) {
					// 국어국문과인 학생을 생성한다
					student = new Student(id, name, korean);
				} else if (majorCode == Define.MATH) {
					// 컴공과인 학생을 생성한다
					student = new Student(id, name, math);
				} else {
					System.out.println("존재하지 않는 과목입니다.");
					return;
				}

				goodSchool.addStudent(student); // 학교에 등록
				korean.register(student); // 수강신청
				math.register(student);

				// 시험점수 등록
				addScoreForStudent(student, korean, koreanScore);
				addScoreForStudent(student, math, mathScore);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 학생마다 과목별(수학, 국어) 점수 추가
	public void addScoreForStudent(Student student, Subject subject, int point) {
		Score score = new Score(student.getStudentId(), subject, point);
		student.addSubjectScore(score);
	}
}
