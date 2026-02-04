package test.ioex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class IOEx3 {

	public static void write(String str) throws Exception {
		OutputStream os = new FileOutputStream("C:\\Temp\\test.txt");	// 파일에 바이트 단위로 저장하는 스트림
		Writer writer = new OutputStreamWriter(os, "UTF-8");	// "이 Writer는 UTF-8 방식으로 문자를 바이트로 바꿔서 os에게 보내라"
		
		writer.write(str);	
		// 문자열을 Writer에게 넘겨서 Writer가 UTF-8로 바이트 변환. 변환된 바이트가 FileOutputStream으로 전달되어서 파일에 저장됨
		writer.flush();
		writer.close();
	}
	
	public static void main(String[] args) throws Exception {

		write("문자 변환 스트림을 사용하는 예시입니다");
		
		String data = read();	// 아까 만든 read()로 다시 읽음
		System.out.println(data);

	}
	
	/* read 메서드를 다음과 같이 정의 하세요
	 * Reader에 InputStreamReader를 꼽고, InputStreamReader에는 FileInputStream을 꽂으세요.
	 * 이렇게 스트림을 연결한 후 100size의 char 배열을 생성해서 reader를 이용해서 읽은 데이터를
	 * String 타입의 변수에 담아서 리턴시키세요.
	 */
	public static String read() throws Exception {
		
		InputStream is = new FileInputStream("C:\\Temp\\test.txt");		// 파일을 바이트 단위로 읽어오는 스트림
		Reader reader = new InputStreamReader(is, "UTF-8");		// "UTF-8 방식으로 바이트를 문자로 바꿔줘"
		
		char[] chArr = new char[100];
		
		int data = reader.read(chArr);		// 파일에서 문자를 읽어서 chArr에 넣어줌. 몇 글자 읽었는지 리턴해줌
		
		reader.close();		// 맨 마지막에 꼽은 스트림만 닫으면 내부적으로 다 닫힘.. 때문에 reader만 close() 호출
		
		String realData = new String(chArr, 0, data);	// chArr의 0번부터 읽은 글자 수(data) 만큼만 문자열로 만들어라

		return realData;
		
	}
}