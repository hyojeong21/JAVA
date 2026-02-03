package test.utilex;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class MyCls {
   
   // 필드. 객체가 가질 값 (이걸로 중복을 판단할 예정임)
   public String name;
   public int age;
   
   // 생성자
   public MyCls(String string, int i) {
      this.name = string;
      this.age = i;
   }

   @Override
   public int hashCode() {
      return name.hashCode() + age;
   }
   
   @Override
   public boolean equals(Object obj) {
      // 파라미터로 오는 obj 속성값을 비교해서 결과를 boolean으로 리턴하는 로직을 작성한다.
      // 여기서는 두 개의 필드값이 같은 경우 중복이라고 정의해서 두 필드의 값이 같은지를 연산해서 결과를 리턴시킨다.
      if(obj instanceof MyCls target) {
         return target.name.equals(name) && (target.age == age);
         // 이름도 같고 나이도 같으면 중복이다 라고 정의한 것
      } else {
         return false;
      }
   }
   
}

public class SetExam {

   public static void main(String[] args) {

      /*
       * Set은 데이터 저장시 hash 값을 기준으로 저장함
       * 따라서 같은 hash가 존재하면 중복저장을 하지 않음
       * 대표적 클래스로는 HashSet을 주로 사용함
       * 정렬을 고려할 때는 TreeSet도 사용함
       */
      
      Set<String> set = new HashSet<String>();   // Set 인터페이스 타입으로 HashSet 객체 생성. Set: 중복 안됨, 순서 없음
      
      set.add("java");
      set.add("jdbc");
      set.add("jsp");
      set.add("spring boot");
      
      System.out.println(set.size());
      
      
      set.clear();      // Set 안의 모든 데이터 삭제
      
      
      MyCls my1 = new MyCls("홍길동", 30);
      MyCls my2 = new MyCls("홍길동", 30);
      MyCls my3 = new MyCls("아이언맨", 40);
      
      HashSet<MyCls> set2 = new HashSet<MyCls>();   // MyCls 타입을 저장하는 HashSet 생성
      
      set2.add(my1);
      set2.add(my2);
      set2.add(my3);
      
      System.out.println(set2.size());
      
      
      // set은 index로 데이터를 저장하지 않는다.
      // 때문에 전체를 get하는 방법에는 다음과 같은 방법으로 한다
      for(MyCls e: set2) {
         System.out.println(e);
      }
      
      
      // Iterator로 변환해서 모든 요소를 get하는 방법
      Iterator<MyCls> iterator = set2.iterator();      // Set을 Iterator로 바꿈
      while(iterator.hasNext()) {   // 꺼낼 게 있는지 확인
         MyCls m = iterator.next();   // 하나 꺼냄
         System.out.println(m.name);
         System.out.println(m.age);
      }
      
      
      // List에 담아서 추출하는 방법도 있음
      ArrayList<MyCls> myList = new ArrayList<MyCls>(set2);   // Set을 List로 복사
      for(int i = 0; i < myList.size(); i++) {
         System.out.println(myList.get(i).name);
      }
         
   }
}