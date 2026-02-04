package test.ioex;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class IOEx2 {

	public static void main(String[] args) {

		/*
		 * 문자를 쓰고 읽는데 특화된 Reader, Writer
		 * 대표적인 메서드인 write(int character)가 있고, 이 외에 문자열을 
		 * 직접 쓸 수도 있도록 메서드가 정의되어짐
		 * 어디에 쓸 것인지는 자식 클래스로 객체 생성해서 대상을 지정함
		 */
		
		try {
//			// 문자 기반 출력 스트림 생성함
//			Writer writer = new FileWriter("C:\\Temp\\test.txt");	
// 			// FileWriter: 문자 기반 출력 스트림. 이제부터 writer.write() 하면 파일에 써짐 (바로 파일에 써지는 건 아님)
//			
//			char a = 'A';
//			writer.write(a);	// 버퍼에 'A'를 저장
//			char b = 'B';
//			writer.write(b);
//			
//			// char 배열 출력
//			char[] arr = {'c', 'd', 'e'};
//			writer.write(arr);	// 배열에 있는 문자들을 한 번에 버퍼에 저장
//			
//			// 문자열 출력
//			writer.write("FGHI");	// 문자열도 결국 char들의 묶음이라서 한 번에 버퍼에 들어감.
//			
//			// 버퍼에 잔류한 데이터를 출력하고 버퍼 닫음
//			writer.flush();		// 버퍼에 쌓인 내용을 파일로 강제로 내보내라. 이때 파일에 써짐. flush()안 하면 파일에 안 써질 수 있음
//			writer.close();		// 스트림 종료 + 자동 flush
			
			
			
			
			char[] chArr = new char[100];
			
			/*
			 * 다음과 같은 로직을 작성하시오.
			 * 1. read()를 이용해서 test.txt 파일을 읽어서 콘솔에 출력하는 로직 작성
			 * 2. read(char[] arr)을 이용해서 위 chArr을 이용, test.txt 파일을 읽어서 콘솔에 출력하는 로직을 작성하시오
			 * 
			 *  결과는 test.txt 파일의 내용이 두 번 출력되어야 한다.
			 */
			
			// 1. read() 이용. read(): 문자 1개 읽음. "문자 하나의 코드값을 반환"
			Reader reader1 = new FileReader("C:\\Temp\\test.txt");
			int data1;
			
			while ((data1 = reader1.read()) != -1) {	// 더 이상 읽을 게 없으면 -1
			// reader1.read() 실행 후 그 값을 data1에 저장해서 그 값이 -1이 아니면 반복
				System.out.println((char)data1);	// read()는 문자를 int로 주기 때문에 (char) 해줘야 함
			}
			
			reader1.close();
			
			// 2. read(char[] arr) 이용. read(char[] arr): 배열에 최대 100글자씩 읽음. "읽은 문자 개수를 반환"
			Reader reader2 = new FileReader("C:\\Temp\\test.txt");
			int data2;
			
			while ((data2 = reader2.read(chArr)) != -1) {
			// (chArr) 이거를 써줘야 여러 글자 읽을 수 있음
				System.out.println(new String(chArr, 0, data2));
				// chArr의 0번부터 data2개까지만 문자열로 만들어라 (쓰레기 값이 출력되지 않게 함)
			}
			
			reader2.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

//Ctrl + Shift + o 누르면 오류 사라짐 (추가할거추가돼서)