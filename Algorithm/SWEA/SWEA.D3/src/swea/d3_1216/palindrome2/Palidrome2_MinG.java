package swea.d3_1216.palindrome2;

import java.util.Scanner;

public class Palidrome2_MinG {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
// 테스트 케이스
		for (int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt(); // 케이스 번호 출력
			sc.nextLine();

			// 배열만들기
			char[][] arr = new char[100][100];
// 배열안에 값을 입력하기 

			for (int i = 0; i < 100; i++) {
				String line = sc.nextLine();
				for (int j = 0; j < 100; j++) {

					arr[i][j] = line.charAt(j);

				} // 열 반복
			} // 배열 값채우기

			// 가로를 채우기
			int maxr = 0;
			findmax: for (int len = 100; len >= 1; len--) {
				for (int i = 0; i < 100; i++) { // 행 고정
					for (int j = 0; j <= 100 - len; j++) { // 100-len 이유: 최소한 회문의 길이보다는 커야한다./ // 열
						boolean result = true; // 회문이 참이라고 가정하자
						for (int k = 0; k < len / 2; k++) { // 시작 위치해서 이제 스왑을 걸어볼 것임
							if (arr[i][j + k] != arr[i][len + j - k - 1]) {
								result = false; // 하나라도 일치하지 않는다면 false
								break; // 반복문 탈출해서 다시 앞으로
							}
						} // 스왑을 위한 반복문
						if (result) {
							maxr = len;
							break findmax;
						} // if문 괄호
					} // 회문의 시작 위치를 반복하는 반복문
				} // 행을 하나씩 증가시켜 나가는 반복문
			} // 회문의 길이를 줄여 나가는 반복문

// 새로운 배열을 생성 
			char arr2[][] = new char[100][100];

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {

					arr2[j][99 - i] = arr[i][j];

				} // 기존 배열의 열
			} // 기존 배열의 행

			int maxc = 0;
			findmax2: for (int len = 100; len >= 1; len--) {
				for (int i = 0; i < 100; i++) { // 행 고정
					for (int j = 0; j <= 100 - len; j++) { // 100-len 이유: 최소한 회문의 길이보다는 커야한다./ // 열
						boolean result = true; // 회문이 참이라고 가정하자
						for (int k = 0; k < len / 2; k++) { // 시작 위치해서 이제 스왑을 걸어볼 것임
							if (arr2[i][j + k] != arr2[i][len + j - k - 1]) {
								result = false; // 하나라도 일치하지 않는다면 false
								break; // 반복문 탈출해서 다시 앞으로
							}
						} // 스왑을 위한 반복문
						if (result) {
							maxc = len;
							break findmax2;
						} // if문 괄호
					} // 회문의 시작 위치를 반복하는 반복문
				} // 행을 하나씩 증가시켜 나가는 반복문
			}

			System.out.println("#" + n + " " + Math.max(maxr, maxc));

		} // 테스트 케이스
	}// main
}