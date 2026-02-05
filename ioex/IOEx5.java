package test.ioex;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Serializable을 구현했다 = "이 객체는 파일에 통째로 저장될 수 있습니다"
class Member implements Serializable{

   // 객체의 버전 번호. 나중에 클래스 구조가 바뀌었을 때, 예전 파일에 저장된 객체와 현재 클래스가 같은 구조인지 확인하는 용도
   private static final long serialVersionUID = -3682820767514922541L;
   
   // 이 변수들이 파일에 같이 저장되는 데이터
   private String id;
   private String name;
   
   public Member(String id, String name) {
      this.id = id;
      this.name = name;
   }
   
   @Override
   public String toString() {
      return id + " : " + name;
   }
   
}

public class IOEx5 {

   public static void main(String[] args) throws Exception {
      
//      // FileReader: 파일을 문자 단위로 읽음, BufferedReader: 버퍼에 담아서 한 줄씩 읽는 기능 제공
//      BufferedReader br = 
//            new BufferedReader(
//                  new FileReader("C:\\JavaWorkspace\\javaFund2\\src\\test\\ioex\\IOEx4.java"));
//      
//      int lineNo = 1;
//      // 한 줄 읽고 → 출력하고 → 또 읽고 → 반복
//      while(true) {
//         String str = br.readLine();
//         if(str == null) break;   null 나오면 종료
//         System.out.println(lineNo + "\t" + str);
//         lineNo++;
//      }
//      br.close();
      
      
      
      
      /*
       * 객체를 통째로 쓰거나 읽기(ObjectIn-OutputStream)
       * 이 대상이 되는 객체는 반드시 Serializable을 구현한 객체여야 함
       * 이 인터페이스는 메서드가 없는 애이기 때문에 구현선언만 해주면 됨.
       */
      // FileOutputStream: 파일을 열어줌, ObjectOutputStream: 객체를 바이트로 바꿔서 저장
      ObjectOutputStream oos = 
            new ObjectOutputStream(
                  new FileOutputStream("C:\\Temp\\object.dat"));
      
      // Member 객체 생성
      Member m1 = new Member("aa", "자바객체");
      
      // 자바가 내부적으로 Member 객체 바이트 배열로 변환 (직렬화) -> 파일에 저장 자동으로 해줌
      // id, name을 따로 쓰지 않아도 객체 통째로 저장됨.
      oos.writeObject(m1);
      
      oos.flush();
      oos.close();
      
      
      
      
      // 파일에 쓰여진 객체를 읽어들인다.
      // 이때 주의해야할 것은 쓴 순서 그대로 읽어야 한다.
      // ex) 객체를 쓰고, byte[]를 썼다면, 읽을 때도 readObject(), readByte() 형태로 읽어야 한다.
      // 그렇지 않으면 예외 발생함
      // 또한 읽어들인 후에는 적절한 타입으로 캐스팅을 통해 원형으로 만든다
      // FileInputStream: 파일에서 바이트를 읽어옴, ObjectInputStream: 그 바이트를 객체로 변환
      ObjectInputStream ios =
            new ObjectInputStream(
                  new FileInputStream("C:\\Temp\\object.dat"));
      
      // 파일을 읽고 역직렬화 후 객체로 복원한다.
      // 파일에 저장된 바이트를 Member 객체로 복원 (역직렬화) -> m2에 저장
      // 생성자도 안 불렀는데 Member 객체가 그대로 살아서 돌아옴
      Member m2 = (Member)ios.readObject();
      
      ios.close();
      
      System.out.println(m2);
      
   }
}