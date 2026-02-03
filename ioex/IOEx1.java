package test.ioex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOEx1 {

	public static void main(String[] args) {

	/*
	 *  Data 입출력(Input, Output): 자바에서는 데이터의 입출력을 정의한 package가 있는데, java.io 임
	 *  이 패키지 내부에는 입출력과 관련된 기능을 하는 API들로 가득함.
	 *  물론 javax.io 라는 패키지에도 향상된 기능의 API들이 있지만,
	 *  모두 java.io를 확장한 애들이라, 반드시 java.io API 사용법을 잘 알아둬야 함.
	 *  
	 *  자바에서는 데이터가 입출력되기 위해서는 반드시 스트림(Stream)이라는 애가 연결되어야 함.
	 *  
	 *  만약 데이터가 프로그램에서 외부로 빠져나가려면 OutputStream이 연결되어야 하고,
	 *  반대인 경우에는 InputStream이 연결되어야 함.
	 *  
	 *  이 스트림이 연결이 되어야만 데이터 입출력이 이루어짐.
	 *  만약 채팅을 구현한다고 하면, 친구에게 데이터가 전송되어지려면,
	 *  프로그램에서 친구에게 나가는 것이기 때문에 OutputStream이 연결되어야 하고,
	 *  반대로, 친구의 메세지가 내게 보여지려면, 친구로부터 InputStream이
	 *  프로그램에 연결되어서 내용을 읽고 보여지도록 만들어야 함.
	 *  
	 *  이처럼 데이터가 프로그램을 기준으로 나가거나 들어오는 모든 행위는 In-OutputStream을 통해서 이뤄짐.
	 *  
	 *  스트림은 단방향이기 때문에 하나의 스트림을 이용해서 읽고 쓰기 불가임
	 *  
	 *  모든 기준을 내가 만든 프로그램으로 하자. 데이터를 갖고 들어오려면 input, 밖으로 빠져나가려면 output
	 *  
	 *  입출력이 이뤄지는 데이터는 크게 두 종류로 구분함.
	 *  1. 그림, 동영상, 음성, 문자 등 모든 종류의 데이터 --> 바이트 스트림
	 *  여기서 주의해야 할 것은 문자도 포함된다는 것임
	 *  2. 온리 문자만 입출력이 이루어져야 하는 경우: 문자 스트림
	 */
		
		try {
			
//			OutputStream out = new FileOutputStream("C:/Temp/test3.db");
//			
//			byte a = 10;
//			byte b = 20;
//			byte c = 30;
//			
//			out.write(a);
//			out.write(b);
//			out.write(c);
//			
//			
			
//			byte[] bArr = {10, 20, 30, 40, 50};
//			
//			// 바이트 배열쓰기
//			out.write(bArr, 2, 3);
//			out.flush();
//			out.close();
			
			
			
			// InputStream을 이용한 파일의 byte 읽기
//			InputStream is = new FileInputStream("C:/Temp/test1.db");
//			
//			while(true) {
//				int data = is.read();
//				// 파일의 끝을 알아야 하므로 -1 인지를 검색한다.
//				if(data == -1)
//					break;
//				System.out.println(data);
//			}
//			is.close();
			
			
			
//			InputStream is = new FileInputStream("C:/Temp/test2.db");
//			
//			byte[] data = new byte[100];
//			
//			while (true) {
//				int num = is.read(data);
//				if (num == -1)
//					break;
//				for (int i = 0; i < num; i++) {
//					System.out.println(data[i]);
//				}
//			}
			
			
			
			String orgFileName = "C:/Temp/orgImg.jpg";
			String copyFileName = "C:/Temp/orgImg.jpg";
			
			OutputStream os = new FileOutputStream(copyFileName);
			InputStream is = new FileInputStream(orgFileName);
			
			// 버퍼용으로 사용할 바이트 배열 선언
			byte[] data = new byte[1024];
			
			while(true) {
				// 읽어들이고, 읽은 만큼만 write한다.
				int num = is.read(data);
				if(num == -1) break;
				os.write(data, 0, num);
			}
			
			os.flush();
			os.close();
			is.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}