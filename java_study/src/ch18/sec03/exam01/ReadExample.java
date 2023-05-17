package ch18.sec03.exam01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ReadExample {

	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("C:/Temp/test1.db");

			while (true) {
				int data = is.read(); // 1bite씩 데이터를 읽어온다.

				if (data == -1) {
					break;
				}

				System.out.println(data);

			}

			is.close(); // 입력스트림을 닫는다(메모리에서 해제)

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
