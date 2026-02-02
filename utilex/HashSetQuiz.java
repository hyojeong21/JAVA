package test.utilex;

import java.util.HashSet;
import java.util.Set;

/*
 * HashSet에 Student를 저장하려 함. 학번이 같으면 동일한 Student 객체라고 인식해서
 * 중복 저장이 안 되도록 해야 함. Student의 학번이 hash 코드라고 생각하고 Student 클래스를 정의한다.
 */

class Student {
	public int studentNum;
	public String name;
	
	public Student (int studentNum, String name) {	// 객체를 만들 때 초기값을 넣기 위해 존재합니다.
		this.studentNum = studentNum;	// 지금 만들어지고 있는 Student 객체의 studentNum 필드
		this.name = name;
	}
	


	@Override
	public int hashCode() {
		return studentNum;		// HashSet이 그 학번으로 위치 결정
	}
	
	@Override
	public boolean equals (Object obj) {	// 모든 객체는 Object를 상속받기 때문에 어떤 객체가 들어올지 몰라서 반드시 똑같은 형태로 재정의(Override)해야 함
//		if (this == obj) return true;		// 두 변수가 아예 같은 객체를 가리킨면 걍 true
		
		if (obj instanceof Student) {		// obj에 Student가 아닌 다른 객체가 들어올 수도 있어서 비교 대상이 Student가 맞을 때만 비교하겠다는 뜻
			Student other = (Student) obj;	// 타입이 Student인 걸 확인했으니 Student로 형변환해서 사용 가능함
			return this.studentNum == other.studentNum;		// 학번이 같으면 같은 학생이라는 뜻
		}
		else {
			return false;	// 같은 객체도 아니고 Student 타입도 아니니 걍 다른 객체 (false)
		}
	}
	
	@Override
	public String toString() {		// 객체의 정보를 사람이 읽을 수 있게 출력
		return "학번: " + studentNum + " 이름: " + name;
	}
	
}



public class HashSetQuiz {

	public static void main(String[] args) {
		Set <Student> set = new HashSet<Student>();		// Student 객체만 저장하는 HashSet 생성
		
		set.add(new Student(1, "제니"));
		set.add(new Student(2, "로제"));
		set.add(new Student(3, "리사"));
		set.add(new Student(4, "지수"));
		set.add(new Student(1, "제나"));
		
		System.out.println("저장된 객체(학생) 수: " + set.size());
		
		
		
		for (Student s : set) {		// set에 저장된 Student를 하나씩 꺼냄
			System.out.println(s);
		}
		
		

	}
}