package test;

import javax.swing.JOptionPane;

public class Gawibawibo2 {

	public static void main(String[] args) {

		RSPGAME game = new RSPGAME();	// RSPGAME 객체 생성. 객체 이름을 game이라고 함
		game.startGame();				// RSPGAME 객체의 startGame() 메서드 호출
	}
}

class RSPGAME {

	private int total;
	private int win;
	private int lose;
	private int draw;

	public void startGame() {
		
		boolean gameStart = true;					// 나중에 false가 되면 while 종료됨

		while (gameStart) {

			String input = getUserInput();			// 입력 받기. 사용자가 입력한 값을 모두 문자열로 통일
			
			if (input == null)
				continue;							// 입력 없으면 다시 입력 받도록

			int myNum = convertToNumber(input);		// 계산하기 위해 문자열을 숫자로 변환. input 전달해야 되니까 괄호 안에 input 쓴 거임
			
			int comNum = getComputerNumber();		// 랜덤 숫자 생성
			
			printChoices(myNum, comNum);			// 결과 출력

			checkResult(myNum, comNum);				// 승패 판단

			gameStart = askContinue();				// 계속 게임 진행할지. gameStart에 저장해야 while문 계속할지 말지 결정됨
		}

		printFinalResult();							// 최종 결과. 출력만 하니까 호출만 하면 되므로 반환값(외부에서 받을 값) 없어서 괄호 안에 아무 것도 안 쓴 거임
	}

//	// 입력 받기. 사용자가 입력한 값을 모두 문자열로 통일
//	private String getUserInput() {
//		
//		String input = JOptionPane.showInputDialog("게임을 시작함");
//
//		if (input == null)
//			return null;
//
//		if (input.equals("1") || input.equals("가위"))
//			return "가위";	// input을 가위로 통일시킴
//		if (input.equals("2") || input.equals("바위"))
//			return "바위";
//		if (input.equals("3") || input.equals("보"))
//			return "보";
//
//		System.out.println("올바른 값이 아닙니다.");
//		return null;
//	}
	
	
	
	private String getUserInput() {

	    try {
	        String input = JOptionPane.showInputDialog("게임을 시작함");

	        if (input == null)   // 취소 누른 경우
	            return null;

	        int num = Integer.parseInt(input);   // 여기서 NumberFormatException 가능. 예외 발생 지점

	        if (num < 1 || num > 3) {	// 숫자는 맞지만 잘못된 숫자 입력한 경우. throw하는 곳(예외를 발생시키는 곳)
	            throw new Exception("1, 2, 3 중에서만 입력하세요");
	        }

	        // 숫자를 문자열로 변환해서 리턴
	        return convertToString(num);

	    } catch (NumberFormatException e) {		// 문자 입력한 경우. Integer.parseInt(input); 여기서 자바가 대신 throw 해줬기 때문에 내가 throw 안 해도 catch 함
	        System.out.println("숫자만 입력하세요");
	        return null;	

	    } catch (Exception e) {		// 숫자는 맞지만 잘못된 숫자 입력한 경우. catch하는 곳(예외를 처리하는 곳)
	        System.out.println(e.getMessage());		// 메세지 보여주고 다시 입력받을 수 있도록
	        return null;
	    }
	}

	

	// 계산하기 위해 문자열을 숫자로 변환 (문자열 넣으면 숫자 나옴)
	private int convertToNumber(String str) {	// 숫자로 변환하니까 int 쓴 거고, 이 메서드 실행하려면 String 하나 줘야 돼서 저렇게 씀
		switch (str) {
		case "가위": return 1;
		case "바위": return 2;
		case "보": return 3;
		}
		return 0;
	}

	// 랜덤 숫자 생성
	private int getComputerNumber() {
		return (int) (Math.random() * 3) + 1;
	}

	// 계산하기 위해 변환한 숫자를 읽을 수 있도록 문자열로 변환 (숫자 넣으면 문자열 나옴)
	private String convertToString(int num) {	// 문자열로 변환하니까 String 쓴 거고, 이 메서드 실행하려면 int 하나 줘야 돼서 저렇게 씀
			switch (num) {
			case 1: return "가위";
			case 2: return "바위";
			case 3: return "보";
			}
			return "";
		}
	
	// 결과 출력 (숫자 2개 넣으면 화면에 출력만 함)
	private void printChoices(int myNum, int comNum) {	// 이 메서드 실행하려면 int 2개 줘야 돼서 저렇게 씀. 출력만 하고 변환하는 거 없으니까 void 씀
		String myStr = convertToString(myNum);
		String comStr = convertToString(comNum);

		System.out.println("컴: " + comStr + ", 당신: " + myStr);
	}

	// 승패 판단
	private void checkResult(int myNum, int comNum) {
		total++;

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
	}
	
//	// 계속 게임 진행할지
//	private boolean askContinue() {
//		String again = JOptionPane.showInputDialog("계속 하시겠습니까? (y/n)");
//		return !again.equalsIgnoreCase("n");	// 사용자가 n을 입력하면 false 리턴
//	}
	
	
	
	private boolean askContinue() {
	    String again = JOptionPane.showInputDialog("계속 하시겠습니까? (y/n)");

	    if (again == null || again.equalsIgnoreCase("n"))	// 사용자가 취소 누르면 게임 종료
	        return false;

	    return true;
	}

	
	
	// 최종 결과
	private void printFinalResult() {
		System.out.println("총 게임 수: " + total);
		System.out.println("승: " + win);
		System.out.println("패: " + lose);
		System.out.println("무: " + draw);

		double rate = (double) win / total * 100;
		System.out.printf("승률: %.2f%%\n", rate);
	}
}