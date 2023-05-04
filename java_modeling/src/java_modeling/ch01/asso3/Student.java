package java_modeling.ch01.asso3;

import java.util.Vector;

public class Student {
	//필드
	private String name; //학생명
	private Vector<Transcript> transcripts; //수강신청 리스트
	
	//생성자
	public Student(String name) {
		this.name = name;
		transcripts = new Vector<Transcript>();
	}
	
	//수강신청 추가
	public void addTranscript(Transcript transcript) {
		transcripts.add(transcript);
	}
	
}
