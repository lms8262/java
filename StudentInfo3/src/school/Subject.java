package school;

import java.util.ArrayList;

import utils.Define;

public class Subject {
	private String subjectName; // 과목명
	private int subjectId; // 과목코드
	private int gradeType; // 학점 산출 방법
	private ArrayList<Student> studentList = new ArrayList<>(); // 과목을 수강신청한 학생 리스트

	public Subject(String subjectName, int subjectId) {
		this.subjectName = subjectName;
		this.subjectId = subjectId;
		this.gradeType = Define.AB_TYPE;
	}

	@Override
	public String toString() {
		return "과목명:" + subjectName + ", 과목코드:" + subjectId + ", 학점산출방법:" + gradeType;
	}

	// 수강신청한 학생이 등록된다.
	public void register(Student student) {
		studentList.add(student);
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getGradeType() {
		return gradeType;
	}

	public void setGradeType(int gradeType) {
		this.gradeType = gradeType;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

}
