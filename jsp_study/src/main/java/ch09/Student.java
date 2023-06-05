package ch09;

import java.sql.Date;

// 엔티티 클래스, DO, DTO
// => model과 controller에서 데이터를 주고 받을때 데이터를 담는 곳으로 사용되는 클래스
public class Student {
	private int id;
	private String username;
	private String univ;
	private Date birth;
	private String email;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUniv() {
		return univ;
	}

	public void setUniv(String univ) {
		this.univ = univ;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
