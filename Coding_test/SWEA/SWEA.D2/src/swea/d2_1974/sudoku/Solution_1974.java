package swea.d2_1974.sudoku;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_1974 {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);
//		File input = new File("src\\swea\\d2_1974\\sudoku\\input.txt");
//		Scanner sc = new Scanner(input);

		int T = sc.nextInt();

		// 다음엔 정렬해서 풀자...
		// 아무리 봐도 이렇게 풀라고 낸 게 아닌 것 같다
		for (int tc = 1; tc <= T; tc++) {
			int[][] map = new int[9][9];
			for (int r = 0; r < 9; r++) {
				for (int c = 0; c < 9; c++) {
					map[r][c] = sc.nextInt();
				}
			}

			int tf = 1;

			for (int r = 0; r < 9; r++) {
				if (tf != 1) {
					break;
				}

				int[] rowCnt = new int[9];
				int[] colCnt = new int[9];

				for (int c = 0; c < 9; c++) {
					rowCnt[map[r][c] - 1]++;
					colCnt[map[c][r] - 1]++;
				}

				for (int i = 0; i < 9; i++) {
					if (rowCnt[i] != 1) {
						tf = 0;
						break;
					}
					if (colCnt[i] != 1) {
						tf = 0;
						break;
					}
				}
			}
			if (tf == 1) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						int[] blockCnt = new int[9];
						for (int r = 0 + 3 * i; r < 3 + 3 * i; r++) {
							for (int c = 0 + 3 * j; c < 3 + 3 * j; c++) {
								blockCnt[map[r][c] - 1]++;
							}
						}

						for (int k = 0; k < 9; k++) {
							if (blockCnt[k] != 1) {
								tf = 0;
								break;
							}
						}
						if (tf != 1)
							break;
					}
					if (tf != 1)
						break;
				}
			}
			System.out.println("#" + tc + " " + tf);
		} // [ tcf ]
	}
}
