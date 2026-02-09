package test.threadex;

import java.awt.Toolkit;

// Thread를 직접 상속받아서 구현한다
class MyThread extends Thread {
	// Thread 상속받으면 이 클래스 자체가 쓰레드가 됨
	@Override
	public void run() {
		// 쓰레드가 해야 할 일을 run() 안에 작성
		System.out.println(getName() + " 쓰레드 수행");
		for (int i = 0; i < 5; i++) {
			System.out.println("Hello World");
			try {
				Thread.sleep(500);	// "0.5초 동안 이 쓰레드는 잠깐 쉬겠다. 다른 쓰레드가 CPU 써도 된다" 의미
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class YourThread implements Runnable {
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println("your Thread");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadEx2 {

	public static void main(String[] args) {
		
		// 시스템의 소리를 내도록 하는 API를 사용해보자.
		
		Thread mainThread = Thread.currentThread();
		// Thread.currentThread(): 지금 이 코드를 실행하고 있는 쓰레드를 가져옴
		// 그래서 프로그램이 시작되면 main 쓰레드가 자동으로 생성됨
		System.out.println(mainThread.getName() + " 실행됨");
		
		// Runnable 을 구현한 객체를 쓰레드의 target으로 지정한다
		Thread yThread = new Thread(new YourThread());
		// YourThread 객체 생성 (일거리) -> Thread 객체에게 그 일을 맡김
		// -> start() 호출 ->  새로운 쓰레드 생성
		yThread.start();
		
		// start()를 호출해서 thread가 작업을 수행하도록 한다. (Execution)
		Thread myThread = new MyThread();
		// start(): 새로운 쓰레드를 생성하고 run() 실행
		myThread.start();
		
		// 클래스를 따로 만들지 않고 즉석에서 Runnable 구현
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for (int i = 0; i < 5; i++) {
					// 컴퓨터 스피커로 '삑' 소리를 내라 는 명령
					toolkit.beep();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		thread.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("띵동~");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}