package swea.d4_1211.Ladder2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_1211 {

	public static void main(String[] args) throws FileNotFoundException {

		File inputFile = new File("src\\swea\\d4_1210\\Ladder1\\input.txt");
		Scanner sc = new Scanner(inputFile);
//		Scanner sc = new Scanner(System.in);

		for (int tc = 0; tc < 10; tc++) {
			int T = sc.nextInt();

			int[][] map = new int[100][102]; // 좌우 최외곽을 0으로 채울 예정

			for (int row = 0; row < 100; row++) { // 0~99행 1~100열
				for (int col = 1; col < 101; col++) {
					map[row][col] = sc.nextInt();
				}
			}
//			System.out.println(Arrays.toString(map[0])); // 잘 들어왔음

			int sol = 0;
			int minCnt = 5000;
			for (int col = 1; col < 101; col++) {
//				System.out.println("for문 시작 시 col : " + col + " --------------------------- ");
				int currentCol = col;
				int currentRow = 1;
				int cnt = 0;
				if (map[0][col] == 1) { // 사다리 시작점이 1로 켜져있을 경우
					for (; currentRow < 99;) { // for문 에서 while 로 돌렸다
						if (map[currentRow][currentCol + 1] == 1) { // 오른쪽이 1이면 쭉 밀어
							while (map[currentRow][currentCol + 1] == 1) {
								currentCol++;
								cnt++;
							}
							currentRow++;
						} else if (map[currentRow][currentCol - 1] == 1) { // 왼쪽이 1이면
							while (map[currentRow][currentCol - 1] == 1) {
								currentCol--;
								cnt++;
							}
							currentRow++;
							cnt++;
						} else {
							currentRow++; // 좌우에 1이 없으면 다음 행으로 넘어가
							cnt++;
						}
					}

				} else continue;
				
				// 종료 조건 map[r][c] == 2 | end
				if (minCnt > cnt) {
//					System.out.println("시작 열 col : " + col);
//					System.out.println("종료 열 : " + currentCol);
//					System.out.println("종료 행 : " + currentRow);
//					System.out.println("종료 위치 값 : " + map[currentRow][currentCol]);
					minCnt = cnt; // 참고용
					sol = col - 1;
//					break; // 가장 가까운 반복문 for ( col : 1 -> 100 ) 탈출
				} // 사다리 시작점 Check if문 end

			} // 시작점 열 1~100 구간 돌리는 for문 end

			System.out.println("#" + T + " " + sol);
		}
	}
}