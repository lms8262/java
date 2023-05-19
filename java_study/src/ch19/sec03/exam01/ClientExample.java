package ch19.sec03.exam01;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExample {

	public static void main(String[] args) {
		try {
			// 소켓 생성, 서버에 연결 요청
			// 내컴퓨터에서 서버를 구동시키므로 주소는 localhost
			// port는 50001번으로 접속
			Socket socket = new Socket("localhost", 50001);

			System.out.println("[클라이언트] 연결 성공");

			socket.close();
			System.out.println("[클라이언트] 연결 끊음");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
