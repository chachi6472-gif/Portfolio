package swea.prac_test.arrest_escaper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_FirstFail {
	static int[][] arr;
	static boolean[][] arrB;
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
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			arr = new int[N][M];
			arrB = new boolean[N][M];
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					arr[n][m] = Integer.parseInt(st.nextToken());
				}
			} // input data into array

			getNum(R, C, L);

			int res = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arrB[i][j]) {
						res++;
					}
				}
			}

			System.out.println(res);
		} // tc for
	} // main

	public static void getNum(int R, int C, int L) {
		// end condition
		if (L < 0 || R < 0 || C < 0 || R >= N || C >= M) {
			return;
		}
		if (arr[R][C] == 0) {
			return;
		}

		// start at (R,C)
		int tmp = arr[R][C];
		arrB[R][C] = true;

		switch (tmp) {
		case 1:
			if (R - 1 >= 0 && !(arr[R - 1][C] == 3 || arr[R - 1][C] == 4 || arr[R - 1][C] == 7)) {
				getNum(R - 1, C, L - 1);
			} // head to upward
			if (R + 1 < N && !(arr[R + 1][C] == 3 || arr[R + 1][C] == 5 || arr[R + 1][C] == 6)) {
				getNum(R + 1, C, L - 1);
			} // head to downward
			if (C - 1 >= 0 && !(arr[R][C - 1] == 2 || arr[R][C - 1] == 6 || arr[R][C - 1] == 7)) {
				getNum(R, C - 1, L - 1);
			} // head to left
			if (C + 1 < M && !(arr[R][C + 1] == 3 || arr[R][C + 1] == 5 || arr[R][C + 1] == 6)) {
				getNum(R, C + 1, L - 1);
			} // head to right
			break;
		case 2:
			if (R - 1 >= 0 && !(arr[R - 1][C] == 3 || arr[R - 1][C] == 4 || arr[R - 1][C] == 7)) {
				getNum(R - 1, C, L - 1);
			} // head to upward
			if (R + 1 < N && !(arr[R + 1][C] == 3 || arr[R + 1][C] == 5 || arr[R + 1][C] == 6)) {
				getNum(R + 1, C, L - 1);
			} // head to downward
			break;
		case 3:
			if (C - 1 >= 0 && !(arr[R][C - 1] == 2 || arr[R][C - 1] == 6 || arr[R][C - 1] == 7)) {
				getNum(R, C - 1, L - 1);
			} // head to left
			if (C + 1 < M && !(arr[R][C + 1] == 3 || arr[R][C + 1] == 5 || arr[R][C + 1] == 6)) {
				getNum(R, C + 1, L - 1);
			} // head to right
			break;
		case 4:
			if (R - 1 >= 0 && !(arr[R - 1][C] == 3 || arr[R - 1][C] == 4 || arr[R - 1][C] == 7)) {
				getNum(R - 1, C, L - 1);
			} // head to upward
			if (C + 1 < M && !(arr[R][C + 1] == 3 || arr[R][C + 1] == 5 || arr[R][C + 1] == 6)) {
				getNum(R, C + 1, L - 1);
			} // head to right
			break;
		case 5:
			if (R + 1 < N && !(arr[R + 1][C] == 3 || arr[R + 1][C] == 5 || arr[R + 1][C] == 6)) {
				getNum(R + 1, C, L - 1);
			} // head to downward
			if (C + 1 < M && !(arr[R][C + 1] == 3 || arr[R][C + 1] == 5 || arr[R][C + 1] == 6)) {
				getNum(R, C + 1, L - 1);
			} // head to right
			break;
		case 6:
			if (R + 1 < N && !(arr[R + 1][C] == 3 || arr[R + 1][C] == 5 || arr[R + 1][C] == 6)) {
				getNum(R + 1, C, L - 1);
			} // head to downward
			if (C - 1 >= 0 && !(arr[R][C - 1] == 2 || arr[R][C - 1] == 6 || arr[R][C - 1] == 7)) {
				getNum(R, C - 1, L - 1);
			} // head to left
			break;
		case 7:
			if (R - 1 >= 0 && !(arr[R - 1][C] == 3 || arr[R - 1][C] == 4 || arr[R - 1][C] == 7)) {
				getNum(R - 1, C, L - 1);
			} // head to upward
			if (C - 1 >= 0 && !(arr[R][C - 1] == 2 || arr[R][C - 1] == 6 || arr[R][C - 1] == 7)) {
				getNum(R, C - 1, L - 1);
			} // head to left
			break;
		}

	}

}
