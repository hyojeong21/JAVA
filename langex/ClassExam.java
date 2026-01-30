package test.langex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ClassExam {
   public static void main(String[] args) throws ClassNotFoundException {
      
      // Class class 는 클래스에 필요한 정보를 관리하는 클래스임
      
      Class cls = Class.forName("test.langex.ClassExam");   // "test.langex.ClassExam" 라는 이름을 가진 클래스를 찾아서 그 클래스의 정보를 담고 있는 Class 객체를 만들어라
      
      System.out.println(cls.getName());   // 클래스의 전체 경로 이름(패키지 포함) 을 출력
      
      Constructor[] cons = cls.getConstructors();   // 이 클래스가 가지고 있는 모든 public 생성자를 배열로 가져옴
      for(Constructor con: cons) {
         System.out.println(con);
      }
      
      // 메서드 이름을 출력시켜보자. API 참조하자..
      Method[] methods = cls.getMethods();   // 이 클래스가 가진 모든 public 메서드를 가져옴
      // getMethods()는 내가 만든 메서드 뿐만 아니라 Object 클래스에서 상속받은 메서드까지 전부 가져온다
      for(Method name : methods) {
         System.out.println(name.getName());         // name.getName(): 메서드 이름
         System.out.println(name.getParameterCount());      // name.getParameterCount(): 매개변수 개수
      }
   }
   
   void a() {
      
   }
   
   void b() {
      
   }
}