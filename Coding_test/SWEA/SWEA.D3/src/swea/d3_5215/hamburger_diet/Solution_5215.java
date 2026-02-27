package swea.d3_5215.hamburger_diet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_5215 {
	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("src\\swea\\d3_5215\\hamburger_diet\\sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(sc.nextLine());
			int N = Integer.parseInt(st.nextToken()); // 재료의 수
			int L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			int[] score = new int[N];
			int[] cal = new int[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(sc.nextLine());
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			int[] listS = new int[N];
			int[] listC = new int[N];
			int maxScore = 0;

//			System.out.println(Arrays.toString(score));
//			System.out.println(Arrays.toString(cal));

			// Goal. bit masking
			for (int i = 0; i < (1 << N); i++) {
				int currS = 0;
				int currC = 0;
				for (int j = 0; j < N; j++) {
					if ((i & (1 << j)) != 0) {
						currS += score[j];
						currC += cal[j];
					}
//					System.out.println(currS);
//					System.out.println(currC);
					if (currS > maxScore && currC <= L) {
						maxScore = currS;
					}
				}
			}

			System.out.println("#" + tc + " " + maxScore);
		}

	} // main
} // class
