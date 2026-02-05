package test.ioex;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOEx4 {

   // BufferedReader and Writer.. 버퍼를 이용해서 읽어온 데이터를 버퍼메모리에 담은 후 
   // 프로그래머는 이 버퍼메모리의 데이터를 읽거나 쓴다
   // 효육적인 입출력을 위해서는 반드시 사용해야 한다
   
   public static void main(String[] args) throws Exception {
      
      // 같은 클래스패스에 있는 이미지 접근해보기
      // IOEx4.class 클래스의 위치 기준
      // getResource("orgImg.jpeg"): 이 클래스와 같은 패키지에 있는 orgImg.jpeg 파일을 찾음
      // .getPath(): 그 파일의 실제 절대 경로 문자열을 가져오는 것
      String originalFilePath = IOEx4.class.getResource("orgImg.jpeg").getPath();
      System.out.println(originalFilePath);

      // 복사할 경로 및 파일명 path 초기화 (복사할 파일 경로 설정)
      String targetFilePath1 = "C:\\Temp\\targetFile1.jpeg";
      
      // in-output stream 연결
      // 파일을 1바이트씩 읽어서 그대로 1바이트씩 쓰는 구조
      FileInputStream fis = new FileInputStream(originalFilePath);
      FileOutputStream fos = new FileOutputStream(targetFilePath1);
      
      
      // 이번엔 버퍼스트림을 이용한 스트림 생성
      String originalFilePath2 = IOEx4.class.getResource("orgImg.jpeg").getPath();
      
      String targetFilePath2 = "C:\\Temp\\targetFile2.jpeg";
      
      FileInputStream fis2 = new FileInputStream(originalFilePath);
      FileOutputStream fos2 = new FileOutputStream(targetFilePath1);
      
      BufferedInputStream bis = new BufferedInputStream(fis2);
      BufferedOutputStream bos = new BufferedOutputStream(fos2);
      
//      BufferedInputStream bis = 
//            new BufferedInputStream(new FileInputStream(originalFilePath)); 이렇게 쓸 수도 있음
      
      // 버퍼를 사용하지 않고 복사하도록 메서드 호출함
      // copy(): 1바이트씩 읽고 쓰기
      long nonBufferTime = copy(fis,fos);
      System.out.println("버퍼 미사용시: " + nonBufferTime + "ns");   // 버퍼 미사용시: 12108100ns
      
   }

   private static long copy(InputStream fis, OutputStream fos) throws IOException {
      
      // nanoTime: 시간 측정
      long start = System.nanoTime();
      // 1바이트 읽고 1바이트 출력
      while(true) {
         int data = fis.read();   // 운영체제에게 "파일에서 1바이트만 주세요" 라고 말하는 것과 같음
         if (data == -1) break;
         fos.write(data);      // "파일에 1바이트만 써 주세요"
      }
      fos.flush();
      long end = System.nanoTime();
      return (end-start);      // 파일을 읽고 쓰는 시간의 편차를 리턴함
      
   }
   
}