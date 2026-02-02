package test.utilex;

import java.util.NavigableSet;
import java.util.TreeSet;

/*
 * 정렬과 검색 기능을 특화한 API TreeSet, TreeMap
 */

public class TreeSetExam {

	public static void main(String[] args) {

		TreeSet<Integer> scores = new TreeSet<Integer>();
		
		scores.add((int)(Math.random() * 100 + 1));		// 만역 랜덤 값이 중복되면 TreeSet은 저절로 제거함
		scores.add((int)(Math.random() * 100 + 1));
		scores.add((int)(Math.random() * 100 + 1));
		scores.add((int)(Math.random() * 100 + 1));
		scores.add((int)(Math.random() * 100 + 1));
		
		// 정렬된 Integer 객체를 하나씩 get
		for(Integer i: scores) {
			System.out.println(i + " : ");
		}
		System.out.println();
		
		// 메서드를 이용해서 가장 낮은 점수부터, 상대 점수까지 get해보기
		System.out.println(scores.first());		// 가장 작은 값
		System.out.println(scores.last());		// 가장 큰 값
		System.out.println("95점 아래 점수: " + scores.lower(95));		// 95보다 작은 값 중 가장 큰 값
		System.out.println("95점 위 점수: " + scores.higher(95));		// 95보다 큰 값 중 가장 작은 값
		System.out.println("95점이거나 아래 점수: " + scores.floor(95));	// 95 이하
		System.out.println("95점이거나 위 점수: " + scores.ceiling(95));	// 95 이상
			
		NavigableSet<Integer> navigableSet = scores.descendingSet();	// 내림차순
		for(Integer i: navigableSet) {
			System.out.println(i);
		}
		
		// tailSet(): 80 <= 범위(80 이상)의 값 검색합니다.
		NavigableSet<Integer> rangeSet = scores.tailSet(80, true);
		for(Integer i: rangeSet) {
			System.out.println(i);
		}
		
		System.out.println("============");
		
		// 범위검증2.. subSet(범위1, 포함여부, 범위2, 포함여부)
		// 범위1 <= 값 < 범위2
		// 70에서 90 사이가 몇 개인지
		NavigableSet<Integer> rangeSet2 = scores.subSet(70, true, 90, true);
		for(Integer i : rangeSet2){
		    System.out.println(i);
		}
		
	}
}