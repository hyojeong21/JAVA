package test.lambda;

import java.util.ArrayList;

/*
 * 자바의 람다는 익명 구현 객체를 응용한 형태이다
 * 익명 구현 객체는 인터페이스를 구현한 익명 객체를 말하는데,
 * 이를 기반으로 함수형 구체를 대입하도록 하는 문법이다.
 * 
 * 자바에서는 람다가 성립하려면 반드시 인터페이스로 정의되어 있어야 하고,
 * 또한 반드시 하나의 메서드만 가져야 한다
 * 만약 하나 이상 보유하게 되면 람다식으로 적용불가하다.
 * 
 * 이를 보장하는 @ -> 어노테이션으로 functionalInerface라는 게 있다
 * 이를 인터페이스에 선언하면, 해당 인터페이스가 람다식으로 사용되기 전에 컴파일시에 유효을 검증하게 된다.
 */

interface A {
   void a();
}


// 파라미터가 없는 람다식을 적용할 때는 () -> {} or () -> 실행문 식으로 작성할 수 있음
// 단 실행문이 두개 이상인 경우엔 무조건 {}로 처리해야 함

// "할 일"을 정하는 설계도
interface Workable{
   void work();      // 매개변수 X, 리턴 X
}

// "두 수를 계산"하는 설계도
@FunctionalInterface
interface Addable {
   double add(double x, double y);    // 두 수 받아서 double 리턴
}


// "이름과 직업으로 행동"하는 설계도
@FunctionalInterface
interface Action{
   void action(String name, String job);
}

// "말하기" 설계도
@FunctionalInterface
interface Speakable {
   void speak(String content);
}


// "정수 계산" 설계도
@FunctionalInterface   // 이건 옵션임. 메서드가 하나여야 함. 하나 이상이면 안 됨
interface Calculable {
   void calc(int x, int y);
}   // "int 두 개 받아서, 아무것도 리턴 안 하는 메서드 하나 있는 인터페이스"



// Person 클래스
class Person{
   // "일하는 방법"을 밖에서 받아옴
   public void action(Workable workable) {      // (자료형 변수명)
      workable.work();   // 받은 일을 실행
   }

    // "계산 방법"을 밖에서 받아옴
   public void addAction(Addable addable) {
      double result = addable.add(10, 4);      // 계산 방법 실행
      System.out.println("result: " + result);
   }
}


// SomeOne 클래스
class SomeOne{
   // 행동 방법을 받아옴
   void doSomething(Action action) {
      action.action("홍길동", "프로그래밍");
   }

   // 말하는 방법을 받아옴
   void doSomething2(Speakable speakable) {
      speakable.speak("hello world");
   }
}


class CalSub1 implements Calculable {
   @Override
   public void calc(int x, int y) {
      System.out.println(x - y);
   }
}

class CalSub2 implements Calculable {
   @Override
   public void calc(int x, int y) {
      System.out.println(x + y);
   }
}


/*
 * 리턴이 있는 람다식 알아보기
 * 리턴이 있는 경우에 만약 return문 하나만 존재한다면, return 키워드를 생략하고
 * 값만 선언하게 되면 그 값이 리턴된다.
 * ex) (파라미터) -> value
 * 
 * 만약 실행문이 하나 이상인 경우엔 반드시 {실행문1, 실행문2, return value;} 해줘야 함
 */

// Calculable을 사용하는 메서드   
public class LambdaExam {
   // 계산 방법을 받아서 실행하는 메서드
   public static void action(Calculable calculable) {

   // 여기서는 데이터를 가지게 된다.
      int x = 10;
      int y = 4;
      
      calculable.calc(x,y);   // 계산 실행

      // SomeOne 사용
      SomeOne ironMan = new SomeOne();
      
       // Action 인터페이스 구현 (이름, 직업 받아서 출력)
      ironMan.doSomething((name, job) -> {
         System.out.println(name + " 이 ");
         System.out.println(job + " 을 합니다");
      });
      
      // Speakable 인터페이스 구현 (문장 출력)
      ironMan.doSomething2((content) -> {
         System.out.println(content + "를 말합니다");
         });


      // forEach 람다
      ArrayList<String> list = new ArrayList<String>();   
      // ArrayList<String> 전체가 자료형, new ArrayList<String>(): String만 담는 ArrayList 객체를 생성
      list.add("일");
      list.add("2");
      list.add("삼");
      
      // Consumer 인터페이스를 람다로 구현
      list.forEach(element -> System.out.println(element));
   }


   public static void main(String[] args) {
      
      Person p = new Person();

      // Addable 사용 (계산 방법 전달)
      // Addable 구현 : 더하기
      p.addAction((x, y) -> {
         double result = x + y;
         return result;
      });
      
      // 리턴문이 하나만 있을 경우
      // Addable 구현 : 빼기
      p.addAction((x, y) -> {
         return (x - y);
      });
      
      // p.addAction((x, y) -> (x - y)); 이렇게 적을 수도 있음


      Person me = new Person();
      
      // Workable 사용 (일하는 방법 전달)
      // Workable을 익명객체로 구현
      me.action(new Workable() {
         @Override
         public void work() {
            System.out.println("출근을 함");
            System.out.println("자바프로그래밍 함");
         }
      });

      // 위 코드를 람다로 바꾸면 (Workable을 람다로 구현)
      new Person().action(() -> System.out.println("퇴근함"));


      // Calculable 사용 (계산 방법 전달)
      // 익명구현객체를 이용한 action 호출
      // Calculable을 익명객체로 구현
      action(new Calculable() {
         @Override
         public void calc(int x, int y) {
            int result = x + y;
            System.out.println("result: " + result);
         }
      });
      
      // 위 코드가 람다로 바뀌면 (Calculable을 람다로 구현)
      // action((x, y) -> {
          //    System.out.println(x + y);
      // });
      
      // 람다를 이용한 익명구현객체
      // action((j,k) -> {
      //   int result = j - k;
      //   System.out.println("result: " + result);
      // });


//              // A 인터페이스 익명 구현 객체
//      new A() {
//         @Override
//         public void a () {
//            System.out.println("a() 오버라이드한 내용");
//         }
//      };
   }
}