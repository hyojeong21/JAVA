package test.lambda.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Stream: 그룹핑 되어 있는 요소들(배열, collection, map 등)을
 * 빠른 속도로 접근하여 다음 작업들로 연결할 수 있는 기능을 가진 인터페이스
 * 이 스트림을 이용하면, 기존방식 for, Iterator 등으로만 처리했던 방식을 대체하면서
 * 다양한 중간 처리 방식을 적용할 수 있다. 속도도 매우 빠르다
 * 
 * Iterator: 직접 꺼냄, "다음 거 있어? 꺼내자. 또 있어? 꺼내자"
 * for-each: 거의 자동, "알아서 하나씩 꺼내서 줘"
 * Stream: 흐름에 맡김, "데이터를 흘려보내면서 처리해"
 */




@Data
@NoArgsConstructor
@AllArgsConstructor
// 정렬기능을 구현하기 위해 Comparable을 구현한다.
class Student implements Comparable <Student>{
   private String name;
   private int score;
   
   
   private String sex;
   
   
   @Override
   public int compareTo (Student o) {
      return Integer.compare(score, o.score);
   }
}


@Data
@AllArgsConstructor
class Product {
   private int pno;
   private String name;
   private String company;
   private int price;
}




public class StreamEx1 {
   
   static int sum = 0;
   
   public static void main(String[] args) {

      Set <String> set = new HashSet <String> ();
      // Set: 중복을 허용하지 않는 자료구조 (인터페이스), <String>: String 타입만 저장하겠다는 제네릭
      // HashSet: Set을 구현한 클래스 (해시 기반)
      // 즉, 문자열을 중복 없이 저장하는 통을 만든 것.
      set.add("A");
      set.add("B");
      set.add("C");
      
      for(String s: set) {      // String s: set에서 하나씩 꺼낸 값을 저장할 변수
         System.out.println(s);
      }
      
      Iterator <String> it = set.iterator();   // iterator(): 반복자 생성
      // iterator()는 Set이 가지고 있는 기능(메서드) 이기 때문에 set ~ 이런식으로 작성
      while(it.hasNext()) {            // hasNext(): 다음 값이 있는지 확인
         System.out.println(it.next());   // next(): 다음 값을 꺼냄
      }   
      // iterator를 만들어서 다음 값이 있으면 그 값을 꺼내 출력한다. 없을 때까지 반복

      Stream <String> stream = set.stream();      // set.stream(): Set을 Stream 객체로 변환
      // stream()은 Set이 가지고 있는 기능(메서드) 이기 때문에 set ~ 이런식으로 작성
      stream.forEach(t -> System.out.println(t));   // 데이터를 하나 받으면 출력하는 함수
      // forEach는 Stream에게 말하는 거야 "데이터 하나씩 흘려보내면서 이 람다식을 실행해줘"
      // forEach(): 하나씩 처리
      // 람다식은 원래 public void accept(String t) { System.out.println(t); } 이런 형태
      // t ->: 하나 꺼내서 t에 저장
      
      
      
      
      List <Student> list = Arrays.asList(   // 여러 객체를 한 번에 List로 만들기 위해서 asList() 사용
         new Student("AA", 10, "여"),
         new Student("BB", 20, "남"),
         new Student("CC", 30, "여")
      );
      
      Stream <Student> str = list.stream();   // 리스트를 스트림으로 변환
      IntStream is = str.mapToInt(student -> student.getScore());
      // mapToInt: Student → int 로 변환하는 작업을 함
      // "Student 객체를 하나 받아서, 그 학생의 점수를 꺼내라"
      OptionalDouble od = is.average();   // 학생 점수 스트림에서 평균을 구한다.
      // 스트림이 비어있을 수도 있기 때문에 OptionalDouble을 줌. "값이 있을 수도 있고 없을 수도 있다"는 의미
      double avg = od.getAsDouble();      // od 객체에서 평균 값을 리턴받는다.
      // getAsDouble(): OptionalDouble 안에 들어있는 진짜 double값(평균값)을 꺼내라 
      
      
      double avg2 = list.stream()
      .mapToInt(std -> std.getScore())   
      .average()
      .getAsDouble();
      
      
      
      
      List <Product> li = new ArrayList<Product>();   // List를 구현한 클래스를 써야 해서 ArrayList 사용. "List의 기능을 쓰되, 구현은 ArrayList로 하겠다"
      // List<Product>: Product 타입만 담는 리스트, new ArrayList<Product>(): 실제 리스트 객체 생성
      for(int i = 0; i < 5; i++) {
         Product p = new Product(i, "상품" + i, "삼성", (int)(Math.random() * 10000));   // 반복할 때마다 새로운 Product 객체를 생성
         li.add(p);   // 방금 만든 Product를 리스트에 넣는 것.
      }
      
      // 위 li를 스트림으로 생성해서 내부의 Product를 모두 출력하라. (forEach 이용하기)
      li.stream()      // "li가 가지고 있는 stream() 메서드를 호출한다" 는 의미
      .forEach(p -> System.out.println(p));   // Stream 안에 있는 각 Product를 하나씩 꺼내서 println이 호출됨
      
      li.forEach(p -> System.out.println(p));      // 위 코드를 이렇게 쓸 수도 있음
      

      
      
      // 특정 정수 범위만큼의 스트림을 생성해서 값출력해보기
      IntStream.rangeClosed(0, 100)   // 0부터 100까지의 int 값들을 가지는 스트림을 생성. rangeClosed(0,100) → 0 ~ 100 (100 포함)
      .forEach(i -> sum += i);      // 숫자를 하나씩 꺼내 sum에 더함
      // 스트림이 숫자를 하나씩 꺼내면서 for(int i = 0; i <= 100; i++) { sum += i; } 이 과정을 실행
      System.out.println(sum);
      
      
      
      
      List <String> lt = new ArrayList <String> ();
      lt.add("홍길동A");
      lt.add("홍길동B");
      lt.add("홍길동C");
      lt.add("홍길동A");
      lt.stream().distinct().forEach(t -> System.out.println(t));
      // distinct(): 중복 제거. Stream 안을 흐르는 데이터 중에서 이미 나온 값은 걸러버림
      
      System.out.println("==================================================");
      
      li.stream()
      .filter(t -> t.getPrice() > 5000)      
      // t.getPrice() > 5000 조건이 true인 데이터만 통과시켜라. filter(): 조건에 맞는 것만 통과
      .forEach(t -> System.out.println(t));
   }
}