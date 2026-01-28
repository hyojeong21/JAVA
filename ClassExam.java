package test;

/*
 * 자바 클래스: 클래스란, 실제 어플리케이션이 수행할 때 사용되는 객체의 설계도임
 * 이 설계도에 우리가 목적하는 업무를 정의하고, 
 * 이를 객체화 시켜서 수행하도록 하는데 목적이 있음
 * 객체를 만들기 위해서는 클래스가 꼭 필요함.
 * 
 * 때문에 객체지향에서는 클래스의 설계가 무척 중요한데,
 * 클래스의 구조에 대해서 먼저 알아보자.
 * 
 * 클래스는 크게 3형식의 구조로 되어 있다
 * 
 * 1. 필드: 멤버 필드라고도 하며, 객체의 상태를 나타내는 변수임
 * 이 말은 이 필드를 가지고 있는 객체의 상태가 어떤 것인지를 
 * 이 변수의 값에 따라서 확인할 수 있다는 뜻임
 * 이 필드는 클래스로부터 객체가 생성될 때 객체에 복사되어 들어가고,
 * 초기 설정값을 지정하지 않으면 타입의 기본값으로 초기화 되어짐
 * 
 * 2. 생성자(constructor): 생성자는 메서드의 일종인데, 메서드와는 하는 일이 다름
 * 형식만 비슷함 (단, 리턴 타입이 없고, 이름이 클래스명과 반드시 같다는 특징)
 * 이 생성자가 하는 주 역할은, 클래스를 바탕으로 실제 객체를 생성하는 역할을 하고,
 * 필요에 따라서 객체 초기화 즉 필드 초기화 역할을 함.
 * 목적에 따라서는 초기화 메서드를 호출하는 역할도 함.
 * 생성자가 없으면 객체를 못 만듦.
 * 
 * 3. 메서드 (method): 클래스 또는 객체가 수행할 행위를 이 메서드를 통해서 정의함
 * 객체와의 유기적인 작업은 이 메서드를 이용해서 주로 하며(필요에 따라서는 필드를 통함),
 * 필요에 따라서 getter, setter를 통해 필드의 값을 set/get 하기도 함
 */


// 우리반 학생들의 객체를 생성해서 정보를 출력하는 클래스를 정의할 예정임
// 즉 정의된 클래스를 바탕으로 실제 학생 객체를 몇 개 생성할 예정이란 뜻임
// 클래스를 정의시, 이러한 객체들이 공통적으로 가지고 있는 
// 공통 속성을 필드로 추출하는 작업부터 한다.

class FullStackStudent{
	/*
	 * 접근 제어자 (Access Modifier)
	 * : private < default < protected < public
	 * 중 하나로 클래스에는 default 와 public만, 
	 * 나머지 필드, 생성자, 메서드에는 위 중 하나를 선언해서
	 * 클래스 내-외부에서 접근 하는 것을 제어할 수 있다.
	 * 
	 * 이 중 가장 강력한 접근 제어는 private로, 
	 * 오직 자신 클래스에서만 접근 가능하다.
	 * 이를 사용하는 가장 큰 목적은 
	 * 선언된 구문의 접근을 오직 자신에게만 국한되게 할 때 사용된다.
	 * 외부에서 접근시에는 컴파일 에러를 유발한다. 이렇게 하는 것을 캡슐화라고 한다.
	 */
	private String name; // 멤버 필드
	private int age;
	private char grade;
	
	// 생성자: 클래스를 바탕으로 인스턴스를 생성해주는 실제 코드
	// 생성자의 문법으로는 [접근제어자] 클래스명([파라미터]){생성자 코드}
	// 형태임. 대괄호는 넣어도 ㄱㅊ 안 넣어도 ㄱㅊ
	
	// 기본 생성자: 파라미터 없고, 필드의 값을 default로 초기화해주는 생성자를 말함
	// 모든 클래스를 정의한 후 컴파일하면, 컴파일러가 자동으로 생성해서 클래스에 넣어줌
	// 단!! 프로그래머가 정의한 생성자가 하나도 없을 경우에만 넣어줌.. 
	// 만약 하나라도 프로그래머가 직접 정의하면 기본 생성자를 넣어주지 않음
	
	public FullStackStudent() {
		this.name = null;	// this는 객체를 가리킴
		this.age = 0;
		this.grade = ' ';
	}
	
	// 생성자 오버로딩: 같은 이름의 생성자를 정의하고, 
	// 파라미터의 순서, 갯수, 타입만 변경해서 정의하면 이를 호출할 때
	// VM이 동적으로 해당되는 생성자 또는 메서드를 호출해서 실행하도록 하는 것
	// 이름만 초기화하는 생성자 정의
	
	public FullStackStudent(String name) {
		this(); 	// 이건 반드시 코드 처음에 나와야 함
		this.name = name;
	}
	
	public FullStackStudent(String name, int age) {
		this(name); 	// 이건 반드시 코드 처음에 나와야 함
		this.age = age;
	}
	
	public FullStackStudent(String name, int age, char grade) {
		this(name, age); 	// 이건 반드시 코드 처음에 나와야 함
		this.grade = grade;
	}
	
	// 이름을 리턴하는 메서드 정의
	// 메서드 구문은 다음과 같음
	// [접근제어자] [static] returntype methodName([파라미터]){구문}
	// void 아무것도 되돌려줄 게 없을 때 사용
	
	public String getName() {
		return this.name;
	}
	
	public String getName(String id) {
		return this.name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
public class ClassExam {
	
	private double r1;
	private double r2;
	
	public ClassExam(double r1, double r2) {
		this.r1 = r1;
		this.r2 = r2;
	}
	
	// 면적을 구하도록 하는 메서드를 정의한다.
	
	public double getArea() {
		return r1 * r2 * InitExam.getPI(); 		// static은 소유자가 클래스니깐..
	}
	
	public static void main(String[] args) {
		
		// 학생 클래스를 바탕으로 나(me) 객체를 생성한다.
		// 클래스의 객체를 생성할 때 키워드는 new 이다.
		// new 다음에 클래스의 생성자를 호출하면, JAVA VM은
		// 프로그램 실행시에 동적으로 heap 메모리 영역에 객체를 생성하고
		// 이를 참조하는 (Reference) 참조값을 리턴해준다.
		
		FullStackStudent me = new FullStackStudent();
		FullStackStudent mg = new FullStackStudent("민경");
		
		// 생성자를 호출해서 인스턴스를 발생시키는 위 과정은 
		// instantiation (클래스의 인스턴스를 생성한다) 라고 한다.
		
		System.out.println(me.getName());
		System.out.println(mg.getName());
		
		// 속성을 직접 접근해서 속성의 값을 대입한다.
		
//		me.name = "서효정";
//		System.out.println(me.name);

	}

}
