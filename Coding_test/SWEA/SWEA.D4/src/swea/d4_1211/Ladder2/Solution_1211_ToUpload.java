package swea.d4_1211.Ladder2;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_1211_ToUpload {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		for (int tc = 0; tc < 10; tc++) {
			int T = sc.nextInt();
			int[][] map = new int[100][102]; // 좌우 최외곽을 0으로 채울 예정
			for (int row = 0; row < 100; row++) { // 0~99행 1~100열
				for (int col = 1; col < 101; col++) {
					map[row][col] = sc.nextInt();
				}
			}
			int sol = 0;
			int minCnt = 5000;
			for (int col = 1; col < 101; col++) {
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
				} else
					continue;
				if (minCnt > cnt) {
					minCnt = cnt; // 참고용
					sol = col - 1;
				} // 사다리 시작점 Check if문 end
			} // 시작점 열 1~100 구간 돌리는 for문 end
			System.out.println("#" + T + " " + sol);
		}
	}
}