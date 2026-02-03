package test.lambda.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

// List에 저장된 Member의 평균 나이를 출력하는 문제
@AllArgsConstructor
@Data
class Member {
	private String name;
	private int age;
	private String job;
}

public class StreamQuiz2 {

	public static void main(String[] args) {

		List <Member> list =
				Arrays.asList(new Member("AA", 40, "developer"),
						new Member("BB", 25, "designer"),
						new Member("CC", 37, "developer"));
		
		// 평균 구하는 코드 (스트림 이용)
		double avg = list.stream()
				.mapToInt(member -> member.getAge())	
				// Member 객체를 하나씩 받아서 그 객체의 age 값(int)만 뽑아서 숫자 스트림으로 만들라는 뜻
				// mapToInt: "객체 스트림을 숫자 스트림으로 바꾸는 변환기"
				.average()			
				// IntStream에 있는 평균 계산 메서드. 반환 타입은 OptionalDouble. 만약 리스트가 비어있으면 평균이 없기 때문에 Optional
				.getAsDouble();		
				// OptionalDouble 안에 있는 값을 꺼냄
		System.out.println(avg);
		
		// 직업이 developer인 객체만 추려서 developers 라는 리스트로 새롭게 생성 후 직업을 출력하기
		List<Member> developers = list.stream()
				.filter(member -> member.getJob().equals("developer"))
				// Member를 받아서 → job이 developer이면 true → 통과
				.collect(Collectors.toList());
				// 필터를 통과한 Member들을 새로운 List로 만들어라
				// collect: 스트림의 결과를 어디에 모을지 정하는 것, Collectors.toList(): "리스트에 모아줘"

		developers.forEach(member -> System.out.println(member.getJob()));	// Member 하나 받아서 → job 꺼내서 출력
	}
}