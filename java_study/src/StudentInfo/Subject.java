package StudentInfo;

import java.util.ArrayList;

public class Subject {
	// 필드
	private String subjectName;
	private int subjectId;
	private int gradeType;
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
}
