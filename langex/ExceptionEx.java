package test.langex;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx {

   public static void main(String[] args) throws FileNotFoundException {
   // throws FileNotFoundException: "이 메서드는 FileNotFoundException 예외를 직접 처리하지 않고, 호출한 쪽으로 던질 수도 있다" 라는 의미
      Scanner sc = new Scanner(System.in);
      
      System.out.println("가위바위보(1,2,3) 입력해 ");
      
      int input = 0;   // try 안에서 예외가 발생하면 input에 값이 안 들어서 미리 초기화 해둠
      
      try {
         input = sc.nextInt();         // 예외 발생하는 코드 작성
      } catch(InputMismatchException e) {   // "try 안에서 특정 예외가 발생하면, 프로그램을 멈추지 말고 여기로 와라".  InputMismatchException: 예외 타입. "이 타입의 예외가 발생했을 때만 잡겠다"는 의미. e: "예외 정보가 담긴 객체"
         System.out.println("예외발생함");
         System.out.println(e.getMessage());      // e.getMessage() → 예외 원인 설명
         // e.printStackTrace();            // e.printStackTrace() → 예외 위치 추적
      }
      
      System.out.println(input);   // 만약 사용자가 문자 입력했어도 input = 0 유지되어서 예외 잡혔기 때문에 프로그램 안 멎추고 0 출력됨
      
      // 파일에 접근하는 API를 사용하려 함
      try {
         FileReader fr = new FileReader("message.txt");
         
         while(true) {
             int i = fr.read();   // 파일을 1바이트(1글자) 읽음.
             if(i == -1)
                break;
             System.out.print((char)i);
         }
         int i = fr.read();
      } catch (Exception e) {      // 어떤 예외가 발생하든 전부 잡겠다
         System.out.println(e.getMessage());
      }
      
   }

}