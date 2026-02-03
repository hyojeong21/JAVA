package test.utilex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * Map: 데이터를 key:value 구조로 저장함
 * 모든 요소는 반드시 객체여야 함
 * 같은 key는 나중에 추가한 key로 덮어씀
 * 대표적인 클래스로는 HashMap을 사용함
 */

public class MapExam {

   public static void main(String[] args) {

      Map<String,Integer> map = new HashMap();      // "문자열 키"와 "정수 값"을 저장하는 Map을 만들겠다
      
      // 데이터 추가
      map.put("a", 40);
      map.put("b", 80);
      map.put("c", 60);
      map.put("d", 100);
      
      System.out.println("총 entry 수: " + map.size());
      System.out.println();
      
      // 특정 key로 value 조회
      String key = "a";   // key에 "a" 저장
      int value = map.get(key);   // map.get("a") → 40 반환
      System.out.println(key + " : " + value);
      System.out.println();
      
      
      // Map은 컬렉션의 자식이 아니므로, 
      // 직접적으로 Collection 타입의 구조로 변환 불가능함. (생성자 등..)
      // 하지만 내부 메서드를 통해서 set으로 변환이 가능함
      Set<String> keySet = map.keySet();      // keySet(): map에 들어있는 key들만 Set으로 가져온다.
      Iterator<String> keyIter = keySet.iterator();   // keySet을 하나씩 꺼내기 위한 반복자(Iterator)
      while(keyIter.hasNext()) {
         String k = keyIter.next();   // 다음 key 하나 꺼냄
         Integer v = map.get(k);   // key로 value 조회
         System.out.println(k + " : " + v);
      }
      System.out.println();
      
      
      // entrySet을 이용한 key:value Entry 객체 얻어내기
      Set<Entry<String,Integer>> entrySet = map.entrySet();      // Map의 **모든 entry(key + value)**를 Set으로 반환
      Iterator<Entry<String,Integer>> entryIt = entrySet.iterator();      // entry를 하나씩 꺼내기 위한 반복자(Iterator)
      
      while(entryIt.hasNext()) {
         Entry<String,Integer> entry = entryIt.next();   // 다음 entry 하나 꺼냄
         // entry에서 key와 value 각각 꺼냄
         String k = entry.getKey();
         Integer v = entry.getValue();
         System.out.println("k " + k + " : " + "v " + v);
      }
      System.out.println();
   }
}