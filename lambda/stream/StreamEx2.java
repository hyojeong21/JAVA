package test.lambda.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamEx2 {

   public static void main(String[] args) {

      List <Student> list = new ArrayList <Student> ();
      
      list.add(new Student("홍길동", 85, "남"));
      list.add(new Student("아이언맨", 90, "남"));
      list.add(new Student("일지매", 95, "여"));

      // Student를 Score 스트림으로 변환
      list.stream()
      .mapToInt(value -> value.getScore())
      .forEach(value -> System.out.println(value));
      
      
      
      
      List <String> list1 = new ArrayList <String> ();
      list1.add("자바 수업");
      list1.add("~~~ ~~~");
      
      list1.stream()
      .flatMap(t -> Arrays.stream(t.split(" ")))      // flatMap: 이 Stream들을 전부 하나로 펼쳐버림
      .forEach(word -> System.out.println(word));
      
      
      
      
      List <String> list2 = Arrays.asList("10", "20", "30", "40", "50");
      list2.stream()
      .flatMapToInt(data -> {      // data는 list2를 가리킴
         String[] strArr = data.split(", ");
         int[] intArr = new int[strArr.length];
         for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i].trim());   // Integer.parseIn: 문자열을 int로
         }
         return Arrays.stream(intArr);
      }).forEach(number -> System.out.println(number));
      
      
      
      
      // Student 객체 3개를 ArrayList list3에 담아보자
      List <Student> list3 = new ArrayList <Student> ();
      
      list3.add(new Student("김민지", 80, "여"));
      list3.add(new Student("이서현", 95, "여"));
      list3.add(new Student("박지현", 90, "여"));
      
      list3.stream()
      .sorted(Comparator.reverseOrder())   // 역순으로 정렬됨. Comparator: "정렬 기준을 정해주는 객체"
      .forEach(t -> System.out.println(t));
      
   }
}