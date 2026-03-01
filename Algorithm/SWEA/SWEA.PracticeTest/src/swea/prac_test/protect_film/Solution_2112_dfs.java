package swea.prac_test.protect_film;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2112_dfs {
	static int D, W, K, min;
	static int[] noneAB;
	static int[][] arr, Copy;
	static int[] cases;
	static int cntDFS;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src\\swea\\prac_test\\protect_film\\sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			min = K;
			arr = new int[D][W];
			cases = new int[D];
			for (int r = 0; r < D; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			dfs(0,0);
			System.out.println(cntDFS);
			sb.append(min).append("\n");
		} // tc for
		System.out.println(sb);
	} // main

	// prove it with dfs
	static void dfs(int r, int cnt) {
		if (min <= cnt) return;
		if (r == D) {
			if (check()) {
				min = Math.min(min, cnt);
			}
			return;
		}

		cases[r] = 0;
		dfs(r + 1, cnt);

		cases[r] = 1;
		dfs(r + 1, cnt + 1);

		cases[r] = 2;
		dfs(r + 1, cnt + 1);
	} // method : dfs

	static boolean check() {
		for (int c = 0; c < W; c++) {
			boolean TF = false;
			int prev = 1;
			if (cases[0] == 0) prev = arr[0][c];
			else if (cases[0] == 1) prev = 0;
			int cnt = 1;
			for (int r = 1; r < D; r++) {
				if (cases[r] == 0) {
					if (prev == arr[r][c]) cnt++;
					else cnt = 1; prev = arr[r][c];
				} else if (cases[r] == 1) {
					if (prev == 0) cnt++;
					else cnt = 1; prev = 0;
				} else {
					if (prev == 1) cnt++;
					else cnt = 1; prev = 1;
				}
				if (cnt >= K) {
					TF = true;
					break;
				}
			}
			if (cnt < min) {
				return false;
			}
			if (!TF) return false;
		}
		return true;
	} // method : check
} // class
