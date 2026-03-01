package swea.prac_test.dessert_cafe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	static int N, max, first_r, first_c;
	static int[] dr = { -1, 1, 1, -1 };
	static int[] dc = { 1, 1, -1, -1 };
	static int[][] arr;
	static Stack<Integer> s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			max = -1;
			arr = new int[N][N];

			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			} // input data

			s = new Stack<>();
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					first_r = r;
					first_c = c;
					s.clear();
					topRight(r, c, 0, 0);
				}
			}
			sb.append("#").append(tc).append(" ").append(max);
			System.out.println(sb);
		} // tc for
	} // main

	static void topRight(int r, int c, int cnt, int dir) {
		if (r < 0 || r >= N || c < 0 || c >= N || dir > 3) {
			return;
		}
		if (r == first_r && c == first_c && cnt > 3 && dir == 3) {
			if (cnt >= max) {
				max = cnt;
				return;
			}
		}

		if (s.contains(arr[r][c])) {
			return;
		} else {
			s.push(arr[r][c]);
		}
		
		if (dir == 0) {
			topRight(r + dr[dir], c + dc[dir], cnt + 1, dir++);
		}
		if (dir == 1) {
			topRight(r + dr[dir], c + dc[dir], cnt + 1, dir++);
		}
		if (dir == 2) {
			topRight(r + dr[dir], c + dc[dir], cnt + 1, dir++);
		}
		if (dir == 3) {
			topRight(r + dr[dir], c + dc[dir], cnt + 1, dir++);
		}
		if(s.size() > cnt) {
			for(int i = 0 ; i <= s.size() - cnt ; i++) {
				s.pop();
			}
		}
	}
} // class
