package school;

import java.util.ArrayList;

public class Student {
	private int studentId; // 학번
	private String studentName; // 이름
	private Subject majorSubject; // 필수과목
	private ArrayList<Score> scoreList = new ArrayList<>(); // 학생이 수강한 과목의 점수 리스트

	public Student(int studentId, String studentName, Subject majorSubject) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.majorSubject = majorSubject;
	}

	@Override
	public String toString() {
		return "학번:" + studentId + ", 이름:" + studentName + ", 필수과목:" + majorSubject.getSubjectName() + "\n점수:" + scoreList;
	}

	// 학생이 수강한 과목에 점수 추가하는 메소드
	public void addSubjectScore(Score score) {
		scoreList.add(score);
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Subject getMajorSubject() {
		return majorSubject;
	}

	public void setMajorSubject(Subject majorSubject) {
		this.majorSubject = majorSubject;
	}

	public ArrayList<Score> getScoreList() {
		return scoreList;
	}

	public void setScoreList(ArrayList<Score> scoreList) {
		this.scoreList = scoreList;
	}

}
