package ch18.sec03.exam03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {

	public static void main(String[] args) {
		String originalFileName = "C:/Temp/test.jpg";
		String targetFileName = "C:/Temp/test2.jpg";

		try {
			InputStream is = new FileInputStream(originalFileName);
			OutputStream os = new FileOutputStream(targetFileName);

			byte[] data = new byte[1024];

			while (true) {
				int num = is.read(data); // 1024byte씩 읽어온다.
				if (num == -1) { // 파일을 끝까지 읽으면 종료
					break;
				}
				os.write(data, 0, num);
			}

			os.flush();
			os.close();
			is.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
