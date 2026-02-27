package swea.prac_test.pinball;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5650 {
	static int first_r;
	static int first_c;
	static int N, maxCnt;
	static int[][] arr;
	static int[][][] arrWH;
	static int[] holeCnt;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	static int[][] reflectMap = { {}, { 2, 0, 3, 1 }, { 3, 2, 0, 1 }, { 1, 3, 0, 2 }, { 2, 3, 1, 0 }, { 2, 3, 0, 1 } };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src\\swea\\prac_test\\pinball\\sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		// [ game rule ]
		// ( information ) : black hole = -1 | empty space = 0 | block = [1,5] | worm
		// hole = [6,10]
		// 1. 5 <= N <= 100
		// 2. worm hole : [6,10] and if there exists worm hole, then the unique pair
		// must be on the table.
		// 3. if coordinate of pin ball equals with worm hole, then switch the position
		// into another worm hole.
		// -> in this case, the vector doesn't change.
		// 4. black hole : -1 and there is a case that there is no black hole on the
		// table
		// 5. max #{black hole} : 5

		for (int tc = 1; tc <= 5; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			String line = br.readLine();
			while (line == null || line.trim().isEmpty())
				line = br.readLine();
			N = Integer.parseInt(line.trim());
			arr = new int[N + 2][N + 2];
			arrWH = new int[11][2][2];
			holeCnt = new int[11];

			for (int i = 0; i < N + 2; i++) {
				arr[0][i] = arr[N + 1][i] = 5;
				arr[i][0] = arr[i][N+1] = 5;
			}
			for (int i = 1; i < N + 1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j < N + 1; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] > 5) {
						int numWH = arr[i][j];
						// save idx of first WH
						arrWH[numWH][holeCnt[numWH]][0] = i;
						arrWH[numWH][holeCnt[numWH]][1] = j;
						numWH++;
					}
				}
			} // input

			maxCnt = 0;
			for (int r = 1; r < N + 1; r++) {
				for (int c = 1; c < N + 1; c++) {
					if (arr[r][c] == 0) {
						for (int d = 0; d < 4; d++) {
							LetsPinball(r, c, d);
						}
					}
				}
			}
			sb.append(maxCnt);
			System.out.println(sb);
		} // tc for
	} // main

	public static void LetsPinball(int start_r, int start_c, int dir) {
		int r = start_r;
		int c = start_c;
		int d = dir;
		int score = 0;

		while (true) {
			r += dr[d];
			c += dc[d];

			if ((r == start_r && c == start_r) || arr[r][c] == -1) {
				maxCnt = Math.max(maxCnt, score);
				return;
			}

			int val = arr[r][c];

			if (val >= 1 && val <= 5) {
				d = reflectMap[val][d];
				score++;
			}

			else if (val >= 6) {
				int[][] pair = arrWH[val];
				if (r == pair[0][0] && c == pair[0][1]) {
					r = pair[1][0];
					c = pair[1][1];
				} else {
					r = pair[0][0];
					c = pair[0][1];

				}
			}

		}

	}

} // class
