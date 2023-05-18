package ch18.sec11;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesExample {

	public static void main(String[] args) throws IOException {
		String data = "" + "id: winter\n" + "email: winter@mycompany.com\n" + "tel: 010-2122-1111";

		// path 객체 생성
		Path path = Paths.get("C:/Temp/user.txt");

		// 파일 생성, 데이터를 저장
		Files.writeString(path, data, Charset.forName("UTF-8"));

		System.out.println("파일 유형: " + Files.probeContentType(path));
		System.out.println("파일 크기: " + Files.size(path) + " bytes");

		// 파일 읽기
		String content = Files.readString(path, Charset.forName("UTF-8"));
		System.out.println(content);
	}

}
