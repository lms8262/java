package StudentInfo;

import java.util.ArrayList;

public class GradeOutput {
	School goodSchool = School.getSchool(); // 학교(goodSchool) 싱글톤 객체 생성

	// goodScholl에 등록된 모든 과목의 그 과목을 수강하는 학생 전체 이름, 학번, 필수과목, 점수, 학점 출력.
	public void allSubjectScorePrint() {
		ArrayList<Subject> subjectList = goodSchool.getSubjectList();
		for (Subject subject : subjectList) {
			subjectScorePrint(subject);
		}
	}

	// 그 과목을 수강하는 학생 전체 이름, 학번, 필수과목, 점수, 학점 출력.
	public void subjectScorePrint(Subject subject) {
		System.out.println("---------------------------------");
		System.out.println("        " + subject.getSubjectName() + "수강생 학점");
		System.out.println("이름 | 학번 | 필수과목 | 점수");
		System.out.println("---------------------------------");
		ArrayList<Student> studentList = subject.getStudentList();
		for (Student student : studentList) {
			System.out.println(student.getStudentName() + " | " + student.getStudentId() + " | "
					+ student.getMajorSubject().getSubjectName() + " | "
					+ getScoreGrade(student, subject.getSubjectId()) + " | ");
			System.out.println("---------------------------------");
		}
	}

	// 학생의 그 과목 점수, 등급 구하기
	public String getScoreGrade(Student student, int subjectId) {
		ArrayList<Score> scoreList = student.getScoreList();
		int point = 0;
		String grade = "";
		GradeEvaluation gradeEvaluation1 = new MajorEvaluation();
		GradeEvaluation gradeEvaluation2 = new BasicEvaluation();
		for (Score score : scoreList) {
			// 입력한 과목코드와 같은지 확인
			if (score.getSubject().getSubjectId() == subjectId) {
				point = score.getPoint();
				// 필수과목인지 아닌지 확인
				if (student.getMajorSubject().getSubjectId() == subjectId) {
					// 필수과목일때
					grade = String.valueOf(gradeEvaluation1.getGrade(score.getPoint()));
				} else {
					// 일반과목일때
					grade = String.valueOf(gradeEvaluation2.getGrade(score.getPoint()));
				}
			}
		}
		return point + ":" + grade;
	}
}
