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

		while (gameStart) {

			String input = JOptionPane.showInputDialog("게임을 시작함");

			if (input.equals("1") || input.equals("가위")) {
				System.out.println("가위를 입력하셨군요");
				input = "가위"; // input을 가위로 통일시킴
			} else if (input.equals("2") || input.equals("바위")) {
				System.out.println("바위를 입력하셨군요");
				input = "바위";
			} else if (input.equals("3") || input.equals("보")) {
				System.out.println("보를 입력하셨군요");
				input = "보";
			} else {
				System.out.println("올바른 값이 아닙니다.");
				continue;	// 잘못된 값이면 while 처음으로 돌아감
			}

			int myNum = 0;
			
			// 사용자가 입력한 값을 "게임 계산용 숫자"로 바꿈
			switch (input) {
			case "가위":
				myNum = 1;	// 숫자 변환
				break;
			case "바위":
				myNum = 2;
				break;
			case "보":
				myNum = 3;
				break;
			}

			int comNum = (int) (Math.random() * 3) + 1;		// 랜덤 숫자 생성

			// 숫자를 다시 문자열로 바꾸는 과정
			// 숫자는 승패 판단용
			// 문자열은 출력용
			String comStr = "";
			String myStr = "";

			switch (comNum) {
			case 1:
				comStr = "가위";
				break;
			case 2:
				comStr = "바위";
				break;
			case 3:
				comStr = "보";
				break;
			}

			// 계산이 끝난 숫자를 사람이 읽을 수 있게 다시 문자열로 바꾸는 과정
			switch (myNum) {
			case 1:
				myStr = "가위";
				break;
			case 2:
				myStr = "바위";
				break;
			case 3:
				myStr = "보";
				break;
			}

			System.out.println("컴: " + comStr + ", 당신: " + myStr);

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

			String again = JOptionPane.showInputDialog("계속 하시겠습니까? (y/n)");
			if (again.equalsIgnoreCase("n")) {
				gameStart = false;
			}
		}

		System.out.println("총 게임 수: " + total);
		System.out.println("승: " + win);
		System.out.println("패: " + lose);
		System.out.println("무: " + draw);

		double rate = (double) win / total * 100;
		System.out.printf("승률: %.2f%%\n", rate);
	}
}



//package javaFund;
//
//import javax.swing.JOptionPane;
//
//public class Gawibawibo {
//
//   private static int getComVal() {
//      return (int)(Math.random() * 3 + 1);
//   }
//   public static void main(String[] args) {
//      // TODO Auto-generated method stub
//      
//      boolean isInputOk = false;
//      
//      JOptionPane.showMessageDialog(null,"게임을 시작함\n가위(1),바위(2),보(3)");
//      String input = null;
//      int userVal;
//      
//      int win=0,draw=0,lose=0,total= 0;
//      
//      double rate;
//      
//      //boolean isCotinue;
//      int comVal;
//      
//      while(!isInputOk) {
//         input = JOptionPane.showInputDialog("값 입력하세요");
//         System.out.println(input);
//         try {
//            userVal = Integer.parseInt(input);
//         }catch (Exception e) {
//            //가위바위보 문자열이 들어왔으므로..예외가 발생함.
//            switch (input) {
//            case "가위": 
//               userVal = 1;  
//               break;
//            case "바위":
//               userVal = 2;
//               break;
//            case "보":
//               userVal = 3;
//               break;   
//            default :
//               userVal = 4;
//               break;
//            }
//         }
//         if(userVal > 3) {
//            JOptionPane.showMessageDialog(null,"잘못된 값입니다. 다시 입력 바람");
//            continue;
//         }
//         comVal = getComVal();
//         
//         if(comVal == userVal) {
//            draw++;//사용자 승 체크
//         }else if((comVal == 1 && userVal == 2) || (comVal == 2 && userVal == 3) || (comVal == 3 && userVal == 1)) {
//            win++;
//         }else {
//            lose++;
//         }
//         total++;
//         System.out.println("컴 " + comVal + "user" + userVal);
//         System.out.println(win + " : " + draw + " : " + lose);
//         
//      }
//      
//      // 게임 플레이를 진행 해야죠..
//      // 컴퓨터의 랜덤값을 생성합니다.
//
//      
//      
//      /*
//       * 사용자는 가위,바위,보 대신 1,2,3 을 값으로 낼수 있습니다.
//       * 그럼 프로그램은 이 값을 분석해서 랜덤한 컴퓨터의 값(Math.random())
//       * 으로 게임을 진행시키고, 결과를 다음처럼 출력 시키세요
//       * 컴 : 가위, 당신 : 보
//       * 컴 승리!
//       * 
//       * 위처럼 결과를 출력후, 게임을 다시 할건지를 물어봅니다.
//       * ex>게임을 계속 할래요? 이때 사용자는 y or n 를 입력 하게 되고
//       * 이에 따라서 게임이 계속되거나 끝나거나 합니다.
//       * 
//       * 단 게임이 끝날때는 총전적, 승,패,무, 승률(소수점 2자리까지)을
//       * 출력 시키고 게임을 종료시킵니다.
//       */
//      
//      
//      
//   }
//
//}


