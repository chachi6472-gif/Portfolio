package swea.prac_test.arrest_escaper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] arr;
	static int[][] arrB;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src\\swea\\prac_test\\arrest_escaper\\sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		// Let's use recursive ft.
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			arr = new int[N][M];
			arrB = new int[N][M];
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					arr[n][m] = Integer.parseInt(st.nextToken());
				}
			} // input data into array

			getNum(R, C, L, arr[R][C], 0, 0);

			int res = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arrB[i][j] > 0) {
						res++;
					}
				}
			}

			sb.append(res).append("\n");
		} // tc for
		System.out.println(sb);
	} // main

	public static void getNum(int R, int C, int L, int preNum, int dr, int dc) {
		// end condition
		if (L <= 0 || R < 0 || C < 0 || R >= N || C >= M) {
			return;
		}
		if (arr[R][C] == 0) {
			return;
		}
		int tmp = arr[R][C];
		if(arrB[R][C] > L) {
			return;
		}

		if (dr == 1 && (tmp == 3 || tmp == 5 || tmp == 6)) {
			return;
		}
		if (dr == -1 && (tmp == 3 || tmp == 4 || tmp == 7)) {
			return;
		}
		if (dc == 1 && (tmp == 2 || tmp == 4 || tmp == 5)) {
			return;
		}
		if (dc == -1 && (tmp == 2 || tmp == 6 || tmp == 7)) {
			return;
		}

		// start at (R,C)
		arrB[R][C] = L;

		switch (tmp) {
		case 1:
			getNum(R - 1, C, L - 1, tmp, -1, 0);
			getNum(R + 1, C, L - 1, tmp, 1, 0);
			getNum(R, C - 1, L - 1, tmp, 0, -1);
			getNum(R, C + 1, L - 1, tmp, 0, 1);
			break;
		case 2:
			getNum(R - 1, C, L - 1, tmp, -1, 0);
			getNum(R + 1, C, L - 1, tmp, 1, 0);
			break;
		case 3:
			getNum(R, C - 1, L - 1, tmp, 0, -1);
			getNum(R, C + 1, L - 1, tmp, 0, 1);
			break;
		case 4:
			getNum(R - 1, C, L - 1, tmp, -1, 0);
			getNum(R, C + 1, L - 1, tmp, 0, 1);
			break;
		case 5:
			getNum(R + 1, C, L - 1, tmp, 1, 0);
			getNum(R, C + 1, L - 1, tmp, 0, 1);
			break;
		case 6:
			getNum(R + 1, C, L - 1, tmp, 1, 0);
			getNum(R, C - 1, L - 1, tmp, 0, -1);
			break;
		case 7:
			getNum(R - 1, C, L - 1, tmp, -1, 0);
			getNum(R, C - 1, L - 1, tmp, 0, -1);
			break;
		}

	}

}
