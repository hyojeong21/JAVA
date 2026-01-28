package test;

import java.util.Arrays;

public class ArrayExam {

   public static void main(String[] args) {
      int intArr[] = new int[4];   // 4개 길이의 int 타입의 배열 생성함
      double[] douArr = {1,2,3};
      String[] strArr = new String[] {"A", "B", "C"};
      
      // 위 구문은 배열 생성식이다. 기억 해두자..
      // 배열 객체는 만약 초기 값을 주지 않은 상태로 생성하면
      // 각 타입의 기본값으로 자동으로 세팅되어짐.
      // 정수는 0, 실수는 0.0, boolean은 false, Object는 null
      
      System.out.println(strArr);
      System.out.println(Arrays.toString(strArr));      // Arrays.toString 써야 정상적으로 출력됨
      
      for (int i = 0; i < strArr.length; i++) {
         System.out.println(strArr[i]);
      }
      
      // 향상된 for. 위 for문과 동일한 기능임
      for(String str : strArr) {
         System.out.println(str);   // str 변수가 배열의 리턴되는 값을 자동으로 대입해서 출력시키도록 함
      }
      
      strArr[0] = "hello";
      // intArr[0] = false;    이런 식으로 타입이 섞이면 안 됨
      douArr[0] = 10;       // 이건 double이 int보다 커서 됨
      
      System.out.println(strArr[strArr.length]);   // 객체는 실행 이후에 오류 생김 (예외).
      // strArr.length 이게 3이니까 strArr[3] 이렇게 되는데 0 1 2만 존재하니까 오류 뜸
      
      
      // 다중 배열.. 배열 내부에 배열을 가지고 있는 형태
      int[] multi[] = new int[2][3];
      multi[0][0] = 10;
      multi[1][2] = 50;
      multi[1][multi.length] = 50;   // 이렇게도 쓸 수 있음. multi.length는 행의 개수
      
      for (int i = 0; i < multi.length; i++) {         // 행
         for (int j = 0; j < multi[i].length; j++) {      // 열. 각 행이 가지고 있는 배열의 길이를 봐야 하기 때문
            System.out.println(multi[i][j]);
         }
      }

   }
}