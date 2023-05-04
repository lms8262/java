package java_modeling.ch01.asso3;

import java.util.Vector;

public class Course {
	//필드
	private String name; //과목명
	private Vector<Transcript> transcripts;
	
	//생성자
	public Course(String name) {
		this.name = name;
		transcripts = new Vector<Transcript>();
	}
	
	//과목명
	public String getName() {
		return name;
	}
	
	//수강신청 추가
	public void addTranscript(Transcript transcript) {
		transcripts.add(transcript);
	}
}
