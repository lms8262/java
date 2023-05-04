package java_modeling.ch01.asso3;

public class Main {

	public static void main(String[] args) {
		//학생 두명 생성
		Student s1 = new Student("haseo");
		Student s2 = new Student("gildong");
		
		//과목 생성
		Course jv = new Course("java");
		Course dp = new Course("Design Pattern");
		
		//수강신청
		Transcript t1 = new Transcript(s1, jv); //haseo는 java를 수강신청
		Transcript t2 = new Transcript(s1, dp); //haseo은 디자인 패턴을 수강신청
		Transcript t3 = new Transcript(s2, dp); //gildong은 디자인 패턴을 수강신청
		
		t1.setDate("2022");
		t1.setGrade("B0"); // haseo의 2022년 java성적이 B0다. 
		
		t2.setDate("2022");
		t2.setGrade("D+"); // haseo의 2022년 디자인패턴 성적이 D+다.
		
		t3.setDate("2023");
		t3.setGrade("C+"); // gildong의 2023년 디자인패턴 성적이 C+이다.
		
		
	}

}
