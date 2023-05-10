package ch15.sec03.exam01;

import java.util.HashSet;

public class HashSetExample {

	public static void main(String[] args) {
		HashSet<Member> set = new HashSet<Member>();
		
		Member m1 = new Member("홍길동", 30);
		Member m2 = new Member("홍길동", 30);
		
		System.out.println(m1.hashCode());
		System.out.println(m2.hashCode());
		
		set.add(m1);
		set.add(m2);
		
		System.out.println("총 객체수: " + set.size());
	}

}
