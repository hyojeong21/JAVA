package test.threadex;

import lombok.Data;

@Data
// 롬복의 @Data 때문에 getter / setter 자동 생성. 그래서 getSum() 사용 가능
class SumThread extends Thread {
	private long sum;
	
	@Override
	public void run() {
		// main 쓰레드가 기다리게 만들려고 엄청 오래 걸리는 연산을 일부러 시킴.
		for(int i = 0; i <= 100000000; i++) {
			sum += i;
		}
	}
}

class WorkThread extends Thread {
	public boolean work = true;
	
	public WorkThread(String name) {
		setName(name);
	}
	
	@Override
	public void run() {
		while(true) {
			if(work) {
				System.out.println(getName() + ": 작업 처리");
			} else {
				Thread.yield();
			}
		}
	}
	// work가 true → 계속 출력
	// work가 false → CPU를 다른 쓰레드에게 양보
	// yield(): "나 지금 실행 중인데, 다른 쓰레드 먼저 해도 돼"
}

public class ThreadEx3 {

	public static void main(String[] args) {

		/*
		 * 쓰레드 클래스의 메서드를 이용한 쓰레드의 제어
		 * 기본적으로 쓰레드는 생성하는 순간 경쟁상태이다.
		 * 즉, 서로 CPU를 점유하려고 경쟁을 하다는 것이다.
		 * 이때, 특정 쓰레드가 CPU를 점유 후, 
		 * 자신의 작업을 모두 끝내도록 다른 쓰레드는 실행 대기 상태에 빠지게 하고, 
		 * 작업 후 이들을 호출해서 다른 쓰레드가 작업을 수행하도록 할 수 있다. 
		 * 이것들은 메서드를 통해 제어가 된다.
		 * 
		 * 일시정지로 보냄: sleep(), join(): 호출한 쓰레드가 일시 정지 상태로 된다
		 * 실행대기 상태로 가려면, join()을 가진 쓰레드가 run을 모두 끝낸 상태, 
		 * 즉 종료 상태로 되어야만 한다
		 * 
		 * yield(): 실행 상태에서 다른 쓰레드에게 실행을 양보하고 실행 대기 상태가 된다
		 * (실행 중인 쓰레드가 CPU 사용을 자발적으로 양보)
		 * join(): 특정 쓰레드가 끝날 때까지 다른 쓰레드를 기다리게 함
		 * sleep(): 그냥 강제로 재움 (CPU 양보 + 시간 대기)
		 */

		SumThread sumThread = new SumThread();
		sumThread.start(); 		// sumThread 실행 시작
		try {
			// Thread.sleep(5);
			sumThread.join();	// sumThread의 run()이 끝날 때까지 실행. main 쓰레드 대기 상태
			// join(): "너 끝날 때까지 나(main)는 멈춰있을게"
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("1~100 까지의 합: " + sumThread.getSum());
		
		
		WorkThread workThreadA = new WorkThread("WorkThreadA");		// 쓰레드 이름 생성
		WorkThread workThreadB = new WorkThread("WorkThreadB");
		
		workThreadA.start();
		workThreadB.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		workThreadA.work = false;
		// 5초 후 A는 yield()만 호출 → CPU 양보, B는 계속 "작업 처리" 출력
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		workThreadA.work = true;
		// 10초 후 A가 다시 출력 시작, 다시 A, B 같이 출력
		
	}
}