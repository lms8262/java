package java_modeling.ch01.asso2;

import java.util.Vector;

public class Student {
	//필드
	private String name; //학생명
	//Vector : ArrayList와 비슷하게 배열에 저장을 할수 있다.
	//course는 1..*
	private Vector<Course> courses;
	
	//생성자
	public Student(String name) {
		this.name = name;
		courses = new Vector<Course>(); 
	}
	
	//수강신청
	public void registerCourse(Course course) {
		courses.add(course);
	}
	
	//수강취소
	public void dropCourse(Course course) {
		courses.remove(course);
	}
	
}
