package swea.d2_2001.fly;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_2001 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		File inputFile = new File("src\\swea\\d2_2001\\fly\\input.txt");
//		Scanner sc = new Scanner(inputFile);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[][] table = new int[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					table[r][c] = sc.nextInt();
				}
			}
//			int[] dr = { 0, 1 }; // 오른쪽, 아래
//			int[] dc = { 1, 0 };
			int[][] res = new int[N - M + 1][N - M + 1];

			int maxDead = 0;
			for (int k = 0; k < N - M + 1; k++) { // 파리채 박스의 열 이동
				for (int l = 0; l < N - M + 1; l++) { // 파리채 박스의 행 이동
					for (int a = 0; a < M; a++) {
						for (int b = 0; b < M; b++) {
							res[l][k] += table[l + a][k + b];

						}
					}
					if (res[l][k] > maxDead) {
						maxDead = res[l][k];
					}

				}
			}

			System.out.println("#" + tc + " " + maxDead);

		}
	}
}
