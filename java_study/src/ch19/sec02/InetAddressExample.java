package ch19.sec02;

import java.net.InetAddress;

public class InetAddressExample {

	public static void main(String[] args) {
		try {
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("내 컴퓨터의 IP주소: " + local.getHostAddress());

			InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
			for (InetAddress remote : iaArr) {
				System.out.println("네이버 서버 IP주소: " + remote.getHostAddress());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
