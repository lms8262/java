package ch18.sec03.exam02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ReadExample {

	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("C:/Temp/test2.db");
			
			byte[] data = new byte[100]; // 100byte씩 읽어오도록 설정
			
			while (true) {
				int num = is.read(data); // 100bite씩 데이터를 읽어온다.

				if (num == -1) {
					break;
				}

				for(int i=0; i<num; i++) {
					System.out.println(data[i]);					
				}

			}

			is.close(); // 입력스트림을 닫는다(메모리에서 해제)

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
