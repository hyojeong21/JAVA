package test.lambda;

@FunctionalInterface
interface Calcuable2{
   double calc(double x, double y);   // "double 두 개를 받아서 double 하나를 리턴하는 계산"
}

class Person2 {
   public void doSome(Calcuable2 calcuable2) {
      double res = calcuable2.calc(10,4);
      System.out.println("결과: " + res);
   }
}

class Computer {
   public static double staticMethod(double x, double y) {
      return x + y;
   }
   public double instanceMethod(double x, double y) {
      return x * y;
   }
}

public class LambdaExam2 {

   public static void main(String[] args) {

      Person2 p = new Person2();
      
      // p.doSome((x, y) -> Computer.staticMethod(x, y));   
      // x, y를 받아서 Computer.staticMethod(x, y)를 실행해라
      p.doSome(Computer :: staticMethod);      // 위 코드와 같은 코드임
      
      Computer computer = new Computer();
      // (x, y) -> computer.instanceMethod(x, y)
      p.doSome(computer :: instanceMethod);
      
      /*
       * 메소드를 참조하는 람다식을 알아보자..
       * 정적 메서드와 인스턴스 메서드를 참조하는 방식이 있는데 문법은 다음과 같다
       * 클래스 :: 메서드
       * 인스턴스변수 :: 메서드
       */
      
//      Math.max(1, 0);
//      (left, right) -> Math.max(left, right);
//      Math :: max;

   }
}