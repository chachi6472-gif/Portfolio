package swea.prac_test.dessert_cafe;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_2105 {
	static int N, max, first_r, first_c;
	static int[] dr = { -1, 1, 1, -1 };
	static int[] dc = { 1, 1, -1, -1 };
	static int[][] arr;
	static Stack<Integer> s;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src\\swea\\prac_test\\dessert_cafe\\sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
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

//			if(tc < 1 || tc > 1) {
//				continue;
//			}
			
//			7
//			7 4 1 5 1 7 9
//			9 4 6 1 4 6 8
//			9 6 4 8 4 7 4
//			3 2 6 2 4 2 8
//			4 9 4 6 2 4 7
//			1 7 6 8 9 5 8
//			1 9 4 7 2 9 7
//			6
//			13 92 96 28 19 25
//			97 28 98 21 98 22
//			97 99 21 14 17 91
//			28 25 25 22 91 16
//			30 95 21 96 20 26
//			91 98 99 20 26 10
//			6
//			10 6 10 4 19 7
//			28 27 23 28 22 28
//			3 5 27 1 21 11
//			9 3 5 13 2 27
//			2 5 25 12 6 12
//			23 2 18 17 29 17
//			6
//			22 30 2 11 25 26
//			28 16 12 29 17 1
//			5 2 16 11 4 27
//			3 4 27 23 26 2
//			13 23 18 6 22 17
//			8 17 2 6 2 1
			
			s = new Stack<>();
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					first_r = r;
					first_c = c;
					s.clear();
//					System.out.println("현재 단계 : (" + r + ", " + c + ")");
					topRight(r, c, 0, 0);
//					System.out.println("max : " + max);
//					System.out.println("------------------------------------");
				}
			}
			System.out.println(max);
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

//		if(s.size() > cnt) {
//			for(int i = 0 ; i <= s.size() - cnt ; i++) {
//				s.pop();
//			}
//		}
		
		if (s.contains(arr[r][c])) {
			return;
		} else {
			s.push(arr[r][c]);
		}
		
//		System.out.println("현재 위치 : (" + r + ", " + c + " | 단계 : " + cnt + " | 향 : " + dir + ")" + " | " + s.toString());

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
