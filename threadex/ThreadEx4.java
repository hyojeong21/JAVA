package test.threadex;

/*
 * 쓰레드의 동기화(Synchronized): 두 개 이상의 쓰레드가 하나의 객체를 공유할 때
 * 해당 공유 객체의 멤버필드를 공유하게 된다.
 * 이때 예상하지 못한 값을 갖게 되는데 (쓰레드의 경쟁 때문에),
 * 이러한 오류를 해결하기 위한 기법으로 쓰레드의 동기화 작업을 통해 이루게 된다.
 * 동기화는 크게 2가지로 할 수 있는데, 하나는 동기화 메서드를 통해 공유 필드를 동기화 하거나
 * 동기화 블락을 통해서 동기화 작업을 할 수 있다.
 */

class Calculator {
	
	// 여기서 memory는 두 쓰레드가 동시에 접근하는 공유 데이터
	private int memory;
	
	// 공유 필드를 연산하는 공용 메서드에 synchronized 키워드를 선언한다.
	// synchronized 가 붙으면 이 메서드를 한 번에 오직 1개의 쓰레드만 들어올 수 있다
	// synchronized void setMemory() -> 메서드 전체 잠금
	public synchronized void setMemory (int memory) {
		
		this.memory = memory;
		
		// 다른 쓰레드가 접근할 수 있도록 실행대기로 전이시킨다.
		// 일부러 2초 쉬게 해서 다른 쓰레드가 끼어들 수 있는 상황을 만듦
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " : " + this.memory);
		
	}
	
	// synchronized 블락처리 방법
	// 해당 메서드 내부에 필드를 처리하는 로직에 동기화블락을 선언해서
	// 공유객체 (여기선 자신)을 동기화 블락으로 선언한다.
	public void setMemory2(int memory) {
		
		// synchronized(this){} -> 블록만 잠금
		synchronized (this) {
			this.memory = memory;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " : " + this.memory);
		}
		
	}
	
}

// 위 공유 객체를 사용하는 쓰레드 정의
class UserThread1 extends Thread{
	// 공유객체 필드 선언
	private Calculator calculator;
	
	public UserThread1() {
		setName("user1Thread");
	}
	
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		calculator.setMemory(100);
	}
}

class UserThread2 extends Thread{
	// 공유객체 필드 선언
	private Calculator calculator;
	
	public UserThread2() {
		setName("user2Thread");
	}
	
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		calculator.setMemory(50);
	}
}

public class ThreadEx4 {

	public static void main(String[] args) {

		// 공유 객체 생성
		// 하나의 Calculator 객체를 공유
		Calculator calculator = new Calculator();
		
		UserThread1 userThread1 = new UserThread1();
		userThread1.setCalculator(calculator);
		userThread1.start();
		
		UserThread2 userThread2 = new UserThread2();
		userThread2.setCalculator(calculator);
		userThread2.start();

	}
}