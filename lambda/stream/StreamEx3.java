package test.lambda.stream;

import java.util.Arrays;

public class StreamEx3 {

   public static void main(String[] args) {

      // 요소를 하나씩 처리하는 메서드 peek(), forEach()
      int[] intArr = {2, 4};
      int total = Arrays.stream(intArr)         // 배열을 IntStream으로 바꿈
      .filter(value -> value % 2 == 0)         // 짝수만 통과시키는 필터
      .peek(value -> System.out.println(value))   // "지금 이 값이 여기까지 잘 흘러왔는지 찍어보기"
      // peek()은 스트림 중간에서 값을 몰래 출력해보는 디버깅용 메서드이고, 최종 연산이 있어야 실행된다.
      .sum();
      System.out.println(total);   // peek()은 최종 집계나 함수 처리를 해야만 수행가능하다

      
      
      // allMatch를 이용해서 2의 배수가 있는지의 여부를 검증해보기
      boolean result = Arrays.stream(intArr)
            .allMatch(value -> value % 2 == 0);
      System.out.println(result);
      
      // nonMatch를 이용해서 3의 배수가 없는지의 여부를 검증해보기
      result = Arrays.stream(intArr)
            .noneMatch(value -> value % 3 == 0);
      System.out.println(result);
      
   }
}