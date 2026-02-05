package test.ioex;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExam {

   public static void main(String[] args) throws IOException {

      /*
       * 자바에서는 폴더건 파일이건 모두 File 객체가 관리함
       * 폴더인지 파일인지는 메서드를 통해 알수 있음
       */
      
      // C:\parent 라는 경로를 가리키는 File 객체를 만듦
      File file = new File("C:\\parent");
      // 폴더가 없으면 생성
      if(!file.exists()) {      // exists() : 실제로 경로가 존재하는지 확인
         file.mkdir();      // mkdir() : 폴더 생성 (파일 생성 아님)
      }
      
      // "file이 가리키는 폴더 안에 child.dat 파일을 만들어라"
      File file2 = new File(file, "child.dat");
      file2.createNewFile();   // createNewFile(): 진짜 파일을 디스크에 생성하는 메서드
      
      // C:\Temp 폴더 확인
      File file3 = new File("C:\\Temp");
      if(file3.exists()) {
         // 폴더 내부의 모든 정보를 출력하도록 한다.
         // 해당 폴더 안에 있는 모든 파일과 폴더를 File 객체 배열로 가져옴
         File[] files = file3.listFiles();
         // 날짜 형식 만들기
         SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd a HH:mm");
            
         // Temp 폴더 안에 있는 모든 파일/폴더를 하나씩 꺼냄
         for(File f: files) {
            // f.lastModified() → 마지막 수정 시간. new Date() → Date 객체로 변환. sdf.format() → 문자열로 변환
            System.out.printf("%-25s", sdf.format(new Date(f.lastModified())));
            
            // 폴더인지 파일인지 구분. true → 폴더. false → 파일
            if(f.isDirectory()) {      // 폴더일 때
               System.out.printf("%-10s%-20s", "<DIR>", f.getName());
            } else {         // 파일일 때
               System.out.printf("%-10s%-20s", f.length(), f.getName());
            }
            System.out.println();
         }
      }
      
   }
}