// 학생의 성적을 국,영,수로 입력받아서 총점, 평균, 학점(A,B,C,F)를 출력하도록 하는 프로그램이다
// 프로그램이 시작되면 각 과목을 입력받도록 하는데, 입력된 점수는 반드시 0 ~ 100점 사이여야 함
// 만약 이 범위를 벗어나면 해당 과목을 다시 입력 받도록 하자. 다른 과목의 입력으로 넘어가면 안 됨
// 만약 올바른 값이 모두 입력되면 위 결과를 출력시키자
// 모든 점수는 배열로 관리되어야 한다. (총점도)
// 학점은 90점 이상은 A, 80점 이상은 B, 70점 이상은 C, 나머지는 F 처리하는데 switch case로 작성하자
package test;

import java.util.Scanner;

public class Score2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] subjects = { "국어", "영어", "수학" };
		int[][] scores = new int[3][4]; // 학생, 과목(총점 포함)

		for (int j = 0; j < 3; j++) {
			System.out.println((j + 1) + "번 학생 점수 입력");

			for (int i = 0; i < subjects.length; i++) {

				while (true) {
					System.out.println(subjects[i] + " 점수 입력: ");
					int input = sc.nextInt();

					if (input >= 0 && input <= 100) {
						scores[j][i] = input;
						break; // 정상 입력
					} else {
						System.out.println("다시 입력하세요");
					}
				}
			}

			// 총점 계산
			for (int i = 0; i < subjects.length; i++) {
				scores[j][3] += scores[j][i];
			}
		}

		for (int j = 0; j < 3; j++) {

			// 평균 계산
			double avg = scores[j][3] / 3.0;

			// 학점 계산
			char grade;
			switch ((int) avg / 10) {
			case 10:
			case 9:
				grade = 'A';
				break;
			case 8:
				grade = 'B';
				break;
			case 7:
				grade = 'C';
				break;
			default:
				grade = 'F';
			}

			System.out.println((j + 1) + "번 학생 점수");
			for (int i = 0; i < subjects.length; i++) {
				System.out.println(subjects[i] + ": " + scores[j][i]);
			}
			System.out.println("총점: " + scores[j][3]);
			System.out.println("평균: " + avg);
			System.out.println("학점: " + grade);
		}

		sc.close();
	}
}