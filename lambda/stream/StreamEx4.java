package test.lambda.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class StreamEx4 {

   public static void main(String[] args) {

      List <Integer> list = new ArrayList <Integer> ();
      
//      // 리스트에 요소가 하나도 없다. 일부러 예외를 발생시켜 볼거임
//      double avg = list.stream()
//            .mapToInt(Integer :: intValue)
//            .average()
//            .getAsDouble();   // "Optional 안에 있는 값을 그냥 꺼내라"
      
      OptionalDouble optional = list.stream()   // 리스트를 스트림으로 변환
      .mapToInt(Integer :: intValue)   
      // average()는 int 스트림에서만 가능하기 때문에 Integer → int 로 바꾸는 작업
      // Integer 객체 안에 있는 int 값을 꺼내라
      .average();
      
      // 데이터가 존재하는지를 체크해서 로직을 작성할 수 있다.
      // OptionalDouble 안에 값이 있는지 검사
      if(optional.isPresent()) {   // isPresent(): 값이 있냐?
         System.out.println("평균: " + optional.getAsDouble());   // getAsDouble(): 값 꺼내기
      } else {
         System.out.println("평균: " + 0);
      }
      
      
      // 방법 2
      double avg = list.stream()
            .mapToInt(Integer :: intValue)
            .average()
            .orElse(0.0);
      System.out.println("방법 2 평균: " + avg);
      // 평균이 있으면 그 값을 쓰고 없으면 0.0을 써라
      
      
      // 방법 3
      list.stream()
      .mapToInt(Integer :: intValue)
      .average()
      .ifPresent(value -> System.out.println("방법 3: " + value));      // 값이 있을 때만 실행해라
      
   }
}