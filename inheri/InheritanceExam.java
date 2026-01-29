package test.inheri;

/*
 * 자바의 클래스 간의 상속: 클래스간에는 상속을 통해 기능과 속성을 자식 클래스가 사용할 수 있도록 할 수 있다.
 * 클래스간의 상속은 extends 라는 키워드를 통해 ex) A extends B 형식에서, B는 A 클래스를 상속한다라고 
 * 선언하는 것이다.
 * 
 * 위처럼 상속을 하게 되면, A 클래스의 필드, 메서드는 B 클래스를 사용할 수 있도록 상속되어진다.
 * 
 * 상속은 클래스간의 선언을 통해 이루어지지만, 실제 사용시에 객체간의 상속을 통해 이뤄진다.
 * 
 * 클래스 간의 상속은 단일 상속만 가능하다. 즉 B 클래스는 오직 하나의 부모 클래스만 상속할 수 있고,
 * 다른 클래스를 동시에 상속할 수 없다. ex) class A, C 가 있고, B 클래스는 class A extends B, C를
 * 할 수 없다는 뜻임.
 * 
 * 만약 B가 A, C를 모두 상속하고 싶으면, 일렬로 순차적으로 상속받아야 한다.
 * 
 * 이렇게 상속을 할 경우, 부모는 위에서처럼 필드와 메서드를 상속해주는데, 단 생성자는 상속을 하지 않는다.
 * 
 * 때문에 자식은 부모의 생성자 중 하나를 반드시 호출해서 객체를 발생시켜야 한다.
 * 
 * 자식 입장에서 부모는 super로 참조한다.
 */

class A extends Object{
	public int a;		// int a : 변수(필드)
	
	public A(int a) {	// A(int a): 생성자
		this.a = a;
	}
	
	public final void a() {	// void a(): 메서드
		System.out.println("A 클래스의 a 메서드 호출됨");
	}
}

class B extends A {
	
	public int b;
	
	// 공유되어야 할 값을 사용할 때는 static과 final을 함께 사용한다
	public static final double PI = 3.14;
	
	public B(int b) {
		super(10);		
		// 자식 객체가 만들어질 때는 부모 생성자가 먼저 실행되기 때문에
		// 반드시 자식 생성자 안에서 super(값); 을 써줘야 함
		// 여기서는 기본 생성자 A()가 없고 A를 만들려면 int 값이 필요하기 때문에 값으로 10이라는 숫자를 넣음
		// 그래서 this.a = 10; 이 됨.
		// b에는 아무것도 안 넣었기 때문에 기본값인 0
		// 그래서 결국  B에는 a = 10도 있고 b = 0도 있음
	}
	
	public void b(final int a) {
		System.out.println("B 클래스의 B 메서드 호출됨");
		// a = 10;
	}
	
	// @Override
	// public void a() {
		
	// }
}

public class InheritanceExam {

	public static void main(String[] args) {

//	A a = new A();
//	a.a();
	B b = new B(20);	// B(타입): b라는 이름의 변수에 B타입을 담을 거임. new B(20): 실제 B 객체를 만드는 코드
	
	}

}