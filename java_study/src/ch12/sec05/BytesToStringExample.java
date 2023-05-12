package ch12.sec05;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class BytesToStringExample {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String data = "자바";

		// 인코딩: UTF-8을 제일 많이 쓴다.
		byte[] arr1 = data.getBytes(); // 문자열 => byte 배열로 변경(UTF-8로 인코딩)
		System.out.println("arr1" + Arrays.toString(arr1));

		String str1 = new String(arr1); // byte배열 => 문자열로 변경
		System.out.println("str1:" + str1);
	}

}
