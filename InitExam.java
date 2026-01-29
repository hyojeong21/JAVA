// static → main → new → 인스턴스블록 → 생성자 → 메서드
// static : 클래스가 처음 로딩될 때 1번 실행
// new : 객체를 만드는 순간
// new 하면 → 인스턴스 블록 → 생성자 순서로 실행
// 그 다음에야 메서드가 실행됨

package test;

public class InitExam {
	
	// ✅ 생성자
	// 👉 객체를 만들 때 실행됨 (인스턴스 블록 다음에 실행됨)
	 InitExam() {
		System.out.println("생성자 호출");
	}
	
	 // ✅ static 초기화 블록
	 // 👉 클래스가 메모리에 올라갈 때 딱 한 번만 실행됨
	 // 👉 main이 실행되기 전에 이미 실행됨
	static {
		System.out.println("클래스의 static 초기화 블락 수행됨");	// 딱 한 번만 호출됨
	}
	
    // ✅ 인스턴스 초기화 블록
    // 👉 new로 객체를 만들 때마다 실행됨
    // 👉 생성자보다 먼저 실행됨
	{
		System.out.println("인스턴스의 초기화 블락 수행됨");
	}
	
    // ✅ 인스턴스 메서드 (객체가 있어야 사용
	void doSome() {		// 객체거임
		System.out.println("인스턴스의 doSOme 메서드 수행됨");
	}
	
    // ✅ 인스턴스 메서드 안에서 static 메서드 사용 가능
	double getCircle(double r, double r2) {		// 인스턴스 메서드가 static 메서드를 호출하는 구조 (static은 클래스 소속이라 누구나 사용 가능)
		return InitExam.getPI() * r * r;
	}
	
    // ✅ static 메서드 (객체 없이 사용 가능)
	public static double getPI() { 	// public 있어야 다른 곳에 쓸 수 있음
		return Math.PI;
	}
	
    // ✅ 프로그램 시작점 (static이기 때문에 객체 없이 실행됨)
	public static void main(String[] args) { 	// static 붙으면 class 거
		
        // 🔶 2번째로 실행됨 (static 블록 다음)
		System.out.println("메인 메서드 실행됨");
		
        // 🔶 여기서 객체 생성!
        // 순서: 인스턴스 블록 → 생성자 → doSome()
		new InitExam().doSome();				// InitExam 객체거
		
        // 🔶 static 메서드 호출 (아무 출력 없음)
		getPI();
	}

}


// 자바에서 객체가 만들어질 때, 실행 순서
// 1. static 초기화 블록 (클래스 초기화)
// 2. 인스턴스 초기화 블록
// 3. 생성자
// 4. 메서드 호출

// 규칙
// - static은 “클래스가 메모리에 올라갈 때 딱 한 번만 실행”
// - 인스턴스 블록 + 생성자는 객체 만들 때마다 실행


// 객체 생성 시 실행 순서
// 1. 인스턴스 초기화 블록
// 2. 생성자
// 3. doSome()

// static 블록은 언제 실행되나?: 클래스가 메모리에 로드될 때 딱 한 번
// 인스턴스 블록은 언제?: 객체 생성할 때마다, 생성자보다 먼저
// 생성자는 언제?: 인스턴스 블록 다음


// 클래스 로딩 -> [static 블록] -> main 실행 -> new InitExam() -> [인스턴스 블록] -> [생성자] -> doSome()

// 객체 만들면 → 인스턴스 블록 → 생성자 순서로 실행된다
// 클래스가 처음 사용되면 → static 블록이 먼저 실행된다