package test;

import javax.swing.JOptionPane;

public class Gawibawibo {

	public static void main(String[] args) {
		/*
		 * 사용자는 가위,바위,보 대신 1,2,3을 값으로 낼 수 있음 그럼 프로그램은 이 값을 분석해서 랜덤한 컴퓨터의
		 * 값(Match.random())으로 게임을 진행시키고, 결과를 다음처럼 출력 시키자
		 *
		 * 컴: 가위, 당신: 보 컴 승리!
		 * 
		 * 위처럼 결과 출력 후, 게임을 다시 할 건지를 물어봄 ex) 게임을 계속 할래요? 이때 사용자는 y or n 를 입력하게 되고 이에 따라서
		 * 게임이 계속되거나 끝나거나 함
		 * 
		 * 단, 게임이 끝날 때는 총 전적, 승, 패, 무, 승률(소수점 2자리까지)을 출력시키고 게임을 종료시킴
		 */

//		String d = "1";
//		
//		if (d.equals(input)) {	// 1과 같은 지를 비교하는 의미임
//			System.out.println("같은 값입니다");
//		}

		int total = 0;
		int win = 0;
		int lose = 0;
		int draw = 0;

		boolean gameStart = true;	// 나중에 false가 되면 while 종료됨

		// 입력 받기. 사용자가 입력한 값을 모두 문자열로 통일
		while (gameStart) {

//			String input = JOptionPane.showInputDialog("게임을 시작함");
//
//			if (input.equals("1") || input.equals("가위")) {
//				System.out.println("가위를 입력하셨군요");
//				input = "가위";	// input을 가위로 통일시킴
//			} else if (input.equals("2") || input.equals("바위")) {
//				System.out.println("바위를 입력하셨군요");
//				input = "바위";
//			} else if (input.equals("3") || input.equals("보")) {
//				System.out.println("보를 입력하셨군요");
//				input = "보";
//			} else {
//				System.out.println("올바른 값이 아닙니다.");
//				continue;	// 잘못된 값이면 while 처음으로 돌아감
//			}
//
//			int myNum = 0;
//
//			// 계산하기 위해 문자열을 숫자로 변환
//			switch (input) {
//			case "가위": myNum = 1;	// 숫자 변환
//				break;
//			case "바위": myNum = 2;
//				break;
//			case "보": myNum = 3;
//				break;
//			}
			
			
			
			int myNum = 0;		// try 안에서 만든 변수를 밖에서 쓰기 위해 밖에서 선언

			try {
			    String input = JOptionPane.showInputDialog("게임을 시작함");

			    if (input == null) {   	// 취소 누른 경우
			        gameStart = false;
			        break;				// while문 탈출
			    }

			    myNum = Integer.parseInt(input);  	// 여기서 NumberFormatException 가능. 예외 발생 지점

			    if (myNum < 1 || myNum > 3) {		// 숫자는 맞지만 잘못된 숫자 입력한 경우. throw하는 곳(예외를 발생시키는 곳)
			        throw new Exception("1, 2, 3 중에서만 입력하세요");
			    }

			} catch (NumberFormatException e) {		// 문자 입력한 경우. Integer.parseInt(input); 여기서 자바가 대신 throw 해줬기 때문에 내가 throw 안 해도 catch 함
			    System.out.println("숫자만 입력하세요");		
			    continue;	// while문의 처음으로 돌아가서 다시 입력받기 위해

			} catch (Exception e) {		// 숫자는 맞지만 잘못된 숫자 입력한 경우. catch하는 곳(예외를 처리하는 곳)
			    System.out.println(e.getMessage());		// 메세지 보여주고 다시 입력받을 수 있도록
			    continue;
			}

			
			
			int comNum = (int) (Math.random() * 3) + 1;		// 랜덤 숫자 생성

			// 계산하기 위해 변환한 숫자를 읽을 수 있도록 문자열로 변환
			String comStr = "";
			String myStr = "";

			switch (comNum) {
			case 1: comStr = "가위";
				break;
			case 2: comStr = "바위";
				break;
			case 3: comStr = "보";
				break;
			}

			// 계산이 끝난 숫자를 사람이 읽을 수 있게 다시 문자열로 바꾸는 과정
			switch (myNum) {
			case 1: myStr = "가위";
				break;
			case 2: myStr = "바위";
				break;
			case 3: myStr = "보";
				break;
			}
			
			// 결과 출력
			System.out.println("컴: " + comStr + ", 당신: " + myStr);

			total++;

			// 승패 진단
			if (myNum == comNum) {
				draw++;
				System.out.println("무승부");
			} else if ((myNum == 1 && comNum == 3) || (myNum == 2 && comNum == 1) || (myNum == 3 && comNum == 2)) {
				win++;
				System.out.println("당신 승리");
			} else {
				lose++;
				System.out.println("컴 승리");
			}

			// 계속 게임 진행할지
//			String again = JOptionPane.showInputDialog("계속 하시겠습니까? (y/n)");
//			if (again.equalsIgnoreCase("n")) {
//				gameStart = false;
//			}
			
			
			
			String again = JOptionPane.showInputDialog("계속 하시겠습니까? (y/n)");
			if (again == null || again.equalsIgnoreCase("n")) {		// 사용자가 취소 누르면 게임 종료
			    gameStart = false;
			}
		}

		
		
		
		// 최종 결과
		System.out.println("총 게임 수: " + total);
		System.out.println("승: " + win);
		System.out.println("패: " + lose);
		System.out.println("무: " + draw);

		double rate = (double) win / total * 100;
		System.out.printf("승률: %.2f%%\n", rate);
	}
}