package test.lambda.stream;

import java.util.Arrays;
import java.util.List;

/*
 * List에 저장되어 있는 String 요소에서 대소문자와 상관없이
 * java 라는 단어가 포함된 영문자만 필터링해서 출력할거임..
 */

public class StreamQuiz1 {

   public static void main(String[] args) {

      List <String> list = Arrays.asList("This is a Java Class", 
                                 "Lambda 표현식을 배웁니다",
                                 "Java8부터 람다가 지원됩니다.");
      // Arrays.asList(): 여러 값을 한 번에 List로 바꿔주는 메서드
      list.stream()   // 리스트를 스트림으로 바꿔서 흐름 처리 시작
      .filter(str -> str.toLowerCase().contains("java"))
      // filter():  조건에 맞는 것만 걸러냄
      // str ->: 리스트의 요소를 하나씩 꺼냄
      // .toLowerCase(): 모두 소문자로 바꿈. 그래야 대소문자 무시 가능함
      // .contains("java"): "java"가 포함되어 있으면 true
      .forEach(str -> System.out.println(str));
      // forEach(): 스트림에 들어있는 요소를 하나씩 꺼내서 괄호 안에 있는 동작을 실행하는 메서드

   }
}