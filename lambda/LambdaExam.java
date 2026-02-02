package test.lambda;

import java.util.ArrayList;

/*
 * 자바의 람다는 익명 구현 객체를 응용한 형태이다
 * 익명 구현 객체는 인터페이스를 구현한 익명 객체를 말하는데,
 * 이를 기반으로 함수형 구체를 대입하도록 하는 문법이다.
 * 
 * 자바에서는 람다가 성립하려면 반드시 인터페이스로 정의되어 있어야 하고,
 * 또한 반드시 하나의 메서드만 가져야 한다
 * 만약 하나 이상 보유하게 되면 람다식으로 적용불가하다.
 * 
 * 이를 보장하는 @ -> 어노테이션으로 functionalInerface라는 게 있다
 * 이를 인터페이스에 선언하면, 해당 인터페이스가 람다식으로 사용되기 전에 컴파일시에 유효을 검증하게 된다.
 */

interface A {
	void a();
}

@FunctionalInterface	// 이건 옵션임. 메서드가 하나여야 함. 하나 이상이면 안 됨0
interface Calculable {
	void calc(int x, int y);
}

class CalSub1 implements Calculable {
	@Override
	public void calc(int x, int y) {
		System.out.println(x - y);
	}
}

class CalSub2 implements Calculable {
	@Override
	public void calc(int x, int y) {
		System.out.println(x + y);
	}
}

//파라미터가 없는 람다식을 적용할 때는 () -> {} or () -> 실행문 식으로 작성할 수 있음
//단 실행문이 두개 이상인 경우엔 무조건 {}로 처리해야 함

interface Workable{
	void work();
}

@FunctionalInterface
interface Action{
	void action(String name, String job);
}

@FunctionalInterface
interface Speakable {
	void speak(String content);
}

@FunctionalInterface
interface Addable {
	double add(double x, double y);
}

class SomeOne{
	void doSomething(Action action) {
		action.action("홍길동", "프로그래밍");
	}
	void doSomething2(Speakable speakable) {
		speakable.speak("hello world");
	}
}

class Person{
	public void action(Workable workable) {
		workable.work();
	}
	public void addAction(Addable addable) {
		double result = addable.add(10, 4);
		System.out.println("result: " + result);
	}
}
	
/*
 * 리턴이 있는 람다식 알아보기
 * 리턴이 있는 경우에 만약 return문 하나만 존재한다면, return 키워드를 생략하고
 * 값만 선언하게 되면 그 값이 리턴된다.
 * ex) (파라미터) -> value
 * 
 * 만약 실행문이 하나 이상인 경우엔 반드시 {실행문1, 실행문2, return value;} 해줘야 함
 */
	
public class LambdaExam {
	public static void action(Calculable calculable) {
		
		SomeOne ironMan = new SomeOne();
		ironMan.doSomething((name, job) -> {
			System.out.println(name + " 이 ");
			System.out.println(job + " 을 합니다");
		});
		
		ironMan.doSomething2((content) -> {
			System.out.println(content + "를 말합니다");
			});
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("일");
		list.add("2");
		list.add("삼");
		
		list.forEach(element -> System.out.println(element));
		
		// 여기서는 데이터를 가지게 된다.
		int x = 10;
		int y = 4;
		
		calculable.calc(x,y);
	}
	
	public static void main(String[] args) {
		
		Person p = new Person();
		p.addAction((x, y) -> {
			double result = x + y;
			return result;
		});
		
		// 리턴문이 하나만 있을 경우
		p.addAction((x, y) -> {
			return (x - y);
		});
		
		p.addAction((x, y) -> (x - y));
		
		
		Person me = new Person();
		me.action(new Workable() {
			
			@Override
			public void work() {
				System.out.println("출근을 함");
				System.out.println("자바프로그래밍 함");
			}
		});
		
		new Person().action(() -> System.out.println("퇴근함"));
		
		// 익명구현객체를 이용한 action 호출
		action(new Calculable() {
			@Override
			public void calc(int x, int y) {
				int result = x + y;
				System.out.println("result: " + result);
			}
		});
		
		// 람다를 이용한 익명구현객체
		action((j,k) -> {
			int result = j - k;
			System.out.println("result: " + result);
		});
		
		// A 인터페이스 익명 구현 객체
//		new A() {
//			@Override
//			public void a () {
//				System.out.println("a() 오버라이드한 내용");
//			}
//		};
	}
}