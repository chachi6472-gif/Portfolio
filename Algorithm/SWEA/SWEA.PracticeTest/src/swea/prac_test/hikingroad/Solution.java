package swea.prac_test.hikingroad;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src\\swea\\prac_test\\hikingroad\\sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= 1; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			int maxHeight = 0;
			boolean[][] isHighest = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] > maxHeight) {
						maxHeight = arr[i][j];
					}
				}
			} // for : input -> array

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == maxHeight) {
						isHighest[i][j] = true;
					}
				}
			} // for : check where the highest is

			// 단계를 스택으로 누적하고 다시 풀어볼만할듯
			
			int currK = K;
			// delta : 12 3 6 9  - clockwise
			int[] dr = { -1,  0,  1,  0 };
			int[] dc = { 0, 1,  0, - -1 };
			int currRow = 0;
			int currCol = 0;
			boolean isConstructable = false;
			int maxCnt = 0;

			System.out.println(maxCnt);
			System.out.println("---------------------------------------------------------------------");
		} // tc for
	}
}
