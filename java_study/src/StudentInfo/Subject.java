package StudentInfo;

import java.util.ArrayList;

public class Subject {
	// 필드
	private String subjectName;
	private int subjectId;
	private ArrayList<Student> studentList = new ArrayList<>();

	// 생성자
	public Subject(String subjectName, int subjectId) {
		this.subjectName = subjectName;
		this.subjectId = subjectId;
	}

	// 메소드
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

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

}
