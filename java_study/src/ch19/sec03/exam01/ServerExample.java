package ch19.sec03.exam01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {
	private static ServerSocket serverSocket = null;

	public static void main(String[] args) {
		System.out.println("--------------------------------------------------");
		System.out.println("서버를 종료하려면 q 또는 Q를 입력하고 Enter 키를 입력하세요.");
		System.out.println("--------------------------------------------------");

		startServer(); // 서버 시작

		Scanner scanner = new Scanner(System.in);

		while (true) {
			String key = scanner.nextLine();
			if (key.toLowerCase().equals("q")) { // 소문자로 변경 후 q와 같은지 비교
				break;
			}
		}

		scanner.close();

		stopServer();
	}

	public static void startServer() {
		Thread thread = new Thread() {

			@Override
			public void run() {
				// 소켓 생성, 50001번 포트로 들어오게 함.
				try {
					serverSocket = new ServerSocket(50001);
					System.out.println("[서버] 시작됨");

					while (true) { // 서버는 중지되면 안되므로 계속 돌린다.

						// 클라이언트가 request 할때까지 기다린다.
						System.out.println("\n[서버] 연결 요청을 기다림\n");

						// 연결 수락
						Socket socket = serverSocket.accept();

						// 연결된 클라이언트 정보 얻기
						InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
						System.out.println("[서버]" + isa.getHostName() + "의 연결 요청을 수락함.");

						// 연결 끊기
						socket.close();
						System.out.println("[서버]" + isa.getHostName() + "의 연결을 끊음");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		};

		thread.start();
	}

	public static void stopServer() {
		try {
			serverSocket.close(); // 서버 소켓을 닫는다.
			System.out.println("[서버] 종료됨");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
