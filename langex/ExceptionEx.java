package test.langex;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("가위바위보(1,2,3) 입력해 ");
		
		int input = 0;
		
		try {
			input = sc.nextInt();		// 예외 발생하는 코드 작성
		} catch(InputMismatchException e) {
			System.out.println("예외발생함");
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
		
		System.out.println(input);
		
		// 파일에 접근하는 API를 사용하려 함
		try {
			FileReader fr = new FileReader("message.txt");
			
			while(true) {
				 int i = fr.read();
				 if(i == -1)
					 break;
				 System.out.print((char)i);
			}
			int i = fr.read();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
