package test.threadex;

import java.awt.Toolkit;

public class ThreadEx1 {

	public static void main(String[] args) {
		
		// 시스템의 소리를 내도록 하는 API를 사용해보자.
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
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