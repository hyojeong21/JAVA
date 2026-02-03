package test.lambda.stream;

import java.util.Arrays;

public class StreamEx3 {

	public static void main(String[] args) {

		// 요소를 하나씩 처리하는 메서드 peek(), forEach()
		int[] intArr = {2, 4};
		int total = Arrays.stream(intArr)
		.filter(value -> value % 2 == 0)
		.peek(value -> System.out.println(value))
		.sum();
		System.out.println(total);	// peek()은 최종 집계나 함수 처리를 해야만 수행가능하다

		
		
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