package StudentInfo;

import java.util.ArrayList;

public class School {
	// 필드
	private static School goodSchool = null;
	private ArrayList<Subject> subjectList = new ArrayList<>();
	private ArrayList<Student> studentList = new ArrayList<>();

	// 생성자
	private School() {
	}

	// 메소드
	public static School getSchool() {
		if (goodSchool == null) {
			goodSchool = new School();
		}
		return goodSchool;
	}

	public void addSubject(Subject subject) {
		subjectList.add(subject);
	}

	public ArrayList<Subject> getSubjectList() {
		return subjectList;
	}

	public void addStudent(Student student) {
		studentList.add(student);
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}
}
