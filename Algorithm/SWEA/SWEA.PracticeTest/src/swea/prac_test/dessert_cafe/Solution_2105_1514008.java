package swea.prac_test.dessert_cafe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_2105_1514008 {
	static int N, max, first_r, first_c;
	static int[] dr = { -1, 1, 1, -1 };
	static int[] dc = { 1, 1, -1, -1 };
	static int[][] arr;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src\\swea\\prac_test\\dessert_cafe\\sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];

			for (int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			} // input data

			max = -1;
			for (int r = 1; r < N - 1; r++) {
				for (int c = 0; c < N - 2; c++) {
					first_r = r;
					first_c = c;

					visit = new boolean[101];
					visit[arr[r][c]] = true;
					topRight(r, c, 1, 0, 0);
				}
			}

			if (max == 0) {
				max = -1;
			}

			bw.write("#" + tc + " " + max + "\n");
			bw.flush();
		} // tc for
	} // main

	static void topRight(int r, int c, int cnt, int dir, int straight) {
		if (dir == 4) {
			return;
		}

		if (dir == 3 && first_r == r + dr[dir] && first_c == c + dc[dir]) {
			max = Math.max(max, cnt);
		}

		if (straight > 0) {
			topRight(r, c, cnt, dir + 1, 0);
		}

		if (r + dr[dir] < 0 || r + dr[dir] >= N || c + dc[dir] < 0 || c + dc[dir] >= N) {
			return;
		}

		if (visit[arr[r + dr[dir]][c + dc[dir]]]) {
			return;
		}

		visit[arr[r + dr[dir]][c + dc[dir]]] = true;
		topRight(r+dr[dir], c+dc[dir], cnt+1, dir, straight+1);
		visit[arr[r + dr[dir]][c + dc[dir]]] = false;
	}
} // class