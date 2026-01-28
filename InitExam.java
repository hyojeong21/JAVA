package test;

public class InitExam {
	
	 InitExam() {
		System.out.println("생성자 호출");
	}
	
	// static 초기화 블락
	
	static {
		System.out.println("클래스의 static 초기화 블락 수행됨");	// 딱 한 번만 호출됨
	}{
		System.out.println("인스턴스의 초기화 블락 수행됨");
	}

	void doSome() {		// 객체거임
		System.out.println("인스턴스의 doSOme 메서드 수행됨");
	}
	
	double getCircle(double r, double r2) {
		return InitExam.getPI() * r * r;
	}
	
	public static double getPI() { 	// public 있어야 다른 곳에 쓸 수 있음
		return Math.PI;
	}
	
	public static void main(String[] args) { 	// static 붙으면 class 거
		System.out.println("메인 메서드 실행됨");
		new InitExam().doSome();				// InitExam 객체거
		getPI();
	}

}