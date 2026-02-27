package swea.d3_7236.jeosuji_depth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_7236 {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(System.in);
		File input = new File("src\\swea\\d3_7236\\jeosuji_depth\\input.txt");
		Scanner sc = new Scanner(input);
		int T = sc.nextInt();

		// 1 2 3
		// 4 X 5
		// 6 7 8
		int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

		for (int tc = 1; tc <= T; tc++) {
			int size = sc.nextInt();
			boolean[][] arr = new boolean[size][size];

			// G : true | W : false
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					String next = sc.next();
					arr[i][j] = next.equals("G");
//					if (next.equals("G")) {
//						arr[i][j] = true;
//					}
//					char next = sc.next().charAt(0);	// 이게 더 빠르게 나온 대신 메모리가 늘어남
//					if (next == 'G') {
//						arr[i][j] = true;
//					}
				} // move column
			} // row fixed

			int maxDepth = 0;
			for (int r = 0; r < size; r++) {
				for (int c = 0; c < size; c++) {
					int d = 0;
					if (!arr[r][c]) {
						for (int i = 0; i < 8; i++) {
							if (r + dr[i] > -1 && r + dr[i] < size && c + dc[i] > -1 && c + dc[i] < size) {
								if (!arr[r + dr[i]][c + dc[i]]) {
									d++;
								}
							}
						}
					} else
						continue;
					if (d == 0) {
						d++;
					}
					if (d > maxDepth) {
						maxDepth = d;
					}
				}
			}

			System.out.println("#" + tc + " " + maxDepth);

		}

	}
}
