package test.threadex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * 우리는 쓰레드가 필요할때마다 계속 만들게 되면, CPU는 해당 쓰레드를
 * 새로 생성 및 수행, 종료(terminated)될때까지 관리를 계속 해줘야 한다.
 * 즉 새로운 쓰레드가 생성 -> 수행 -> 종료 -> 생성 ...
 * 이러한 사이클을 반복하게 되는데, 이렇게 되면 시스템의 성능이 저하될 수 있다.
 * 그래서 나온 개념이 쓰레드풀(Thread Pool)
 * 이 개념은 쓰레드를 목적에 맞게 한 번에 여러 개를 생성해서 Pool로 관리한다는 의미다.
 * 이렇게 하면, 처음에 다중의 쓰레드를 생성하기 때문에, 
 * 처음 시작시 이후에는 부가적인 쓰레드 생성에 대한 부하가 없고, 
 * run()을 모두 수행한 쓰레드는 파괴되는게 아니라, 
 * 다시 새로운 작업을 수행할 수 있도록 내부적으로 관리하도록 만든 개념이다.
 * 
 * 해당 쓰레드 풀은 java.util.concurrent 패키지에 있는 ExcutorService, Executors API를 통해서 사용할 수 있다.
 */

public class ThreadPoolEx {

	public static void main(String[] args) {

//		ExecutorService executorService = Executors.newFixedThreadPool(10);	// 한 번에 10개의 쓰레드를 생성함
//		
//		executorService.execute(null);
//		
//		// 이후에 처리하는 코드를 여기에 작업하고, 다 쓴 후엔 shutDown()을 호출해서 제거한다
//		executorService.shutdown();

		String[][] mails = new String[1000][3];
		for (int i = 0; i < mails.length; i++) {
			mails[i][0] = "admin@hallym.ac";
			mails[i][1] = "member" + i + "hallym.com";
			mails[i][2] = "26년도 학사과정 공지";
		}

		ExecutorService executorService = Executors.newFixedThreadPool(5);

		// 이메일을 보내는 작업 생성 및 처리 요청
		for (int i = 0; i < 1000; i++) {
			final int idx = i;

			executorService.execute(new Runnable() {
				@Override
				public void run() {
					Thread thread = Thread.currentThread();
					String from = mails[idx][0];
					String to = mails[idx][1];
					String content = mails[idx][2];

					System.out.println("[" + thread.getName() + "]" + from + " ==> " + to + ": " + content);

				}
			});

		}
		
		executorService.shutdown();
	}

}