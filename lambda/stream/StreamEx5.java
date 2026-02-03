package test.lambda.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamEx5 {

	public static void main(String[] args) {

		List <Student> list = new ArrayList <Student> ();
		
		list.add(new Student("홍길동", 85, "남"));
		list.add(new Student("아이언맨", 90, "남"));
		list.add(new Student("일지매", 95, "여"));
		list.add(new Student("블랙위도우", 100, "여"));
		
		
		
		// 람다, 스트림 쓰지 않고 남학생을 묶어서 새로 담기
		List <Student> maleList = new ArrayList <Student> ();
		
		for(Student student: list) {			// list 안에 있는 Student를 하나씩 꺼내서 student에 담는다
			if (student.getSex().equals("남")) {
			        maleList.add(student);
			}
		}
		
		
		
		// collect()를 이용한 집계
		List <Student> maleList2 = list.stream()
				.filter(student -> student.getSex().equals("남"))
				.collect(Collectors.toList());
		System.out.println(maleList2);
		
		
		
		List <Student> maleList3 = list.stream()
				.filter(student -> student.getSex().equals("남"))
				.toList();
		System.out.println(maleList3);
		
		
		
		// Map 형태로도 변형 가능함
		Map <String, Integer> map = list.stream()
				.collect(Collectors.toMap(t -> t.getName(), t -> t.getScore()));
		System.out.println(map);
		
	}
}