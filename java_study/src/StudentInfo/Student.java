package StudentInfo;

import java.util.ArrayList;

public class Student {
	// 필드
	private int studentId;
	private String studentName;
	private Subject majorSubject;
	private ArrayList<Score> scoreList = new ArrayList<>();

	// 생성자
	public Student(int studentId, String studentName, Subject majorSubject) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.majorSubject = majorSubject;
	}

	// 메소드
	public void addSubjectScore(Score score) {
		scoreList.add(score);
	}

}
