package ch12.sec03.exam01;

public class Member {
	public String id;

	public Member(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) { // obj가 Member 객체를 참조하는지?
			Member target = (Member) obj; // 강제타입변환
			if (id.equals(target.id)) { // 문자 값 비교
				return true;
			}
		}
		return false;
	}

}
