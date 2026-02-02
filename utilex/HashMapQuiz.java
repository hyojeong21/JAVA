package test.utilex;

import java.util.HashMap;
import java.util.Map;

/*
 * HashMap에 ID(String)와 점수(Integer)가 저장되어 있음
 * 실행 결과와 같이 평균 점수, 최고 점수, 최고 점수의 ID를 출력하도록 코드를 완성하자..
 */

public class HashMapQuiz {

	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		// "문자열을 Key로, 정수를 Value로 저장하는 HashMap 객체를 생성하고, 그 참조를 map에 담는다"
		
		map.put("blue", 96);
		map.put("white", 82);
		map.put("red", 82);
		
		String name = null;	// 최고 점수를 받는 아이디 변수
		int maxScore = 0;	// 최고 점수 변수
		int totalScore = 0;	// 점수 합계를 저장하는 변수
		
		
		
//		Set<Entry<String, Integer>> entrySet = map.entrySet();
//		for(Entry<String, Integer> entry: entrySet) {
//			if(entry.getValue() > maxScore) {
//				name = entry.getKey();
//				maxScore = entry.getValue();
//			}
//		}
		
		
		
		for (Map.Entry<String, Integer> entry: map.entrySet()) {	
			// map.entrySet(): for문은 한 번에 하나씩만 꺼낼 수 있기 때문에 map 안에 있는 key와 value를 하나의 객체로 묶음
			// Map.Entry<String, Integer> entry: "key와 value가 같이 들어있는 객체를 entry라고 부르겠다" 
			// 그래서 결론은 map 안에 있는 (key=value) 묶음을 하나씩 entry에 담아서 반복하라는 뜻
			
			// key, value 꺼내기
			String key = entry.getKey();	// ID 꺼냄
			int score = entry.getValue();	// 점수 꺼냄
			
			// 총합
			totalScore += score;
			
			// 최고점수
			if (score > maxScore) {
				maxScore = score;
				name = key; // 최고점수를 받은 ID
			}
		}
		
		// 평균점수
		int avg = totalScore / map.size();
		
		System.out.println("평균점수: " + avg);
		System.out.println("최고점수: " + maxScore);
		System.out.println("최고점수를 받은 ID: " + name);
		

		
	}
}