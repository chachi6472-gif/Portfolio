package swea.d3_5215.hamburger_diet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_5215_RecursiveFt {

	public static int[] score;
	public static int[] cal;
	public static int[] listS;
	public static int[] listC;
	public static int N;
	public static int L;
	public static int sumScore;
	public static int sumCal;
	public static int maxScore;

	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("src\\swea\\d3_5215\\hamburger_diet\\sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(sc.nextLine());
			N = Integer.parseInt(st.nextToken()); // 재료의 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			score = new int[N];
			cal = new int[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(sc.nextLine());
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			listS = new int[N];
			listC = new int[N];
			maxScore = 0;
//			System.out.println(Arrays.toString(score));
//			System.out.println(Arrays.toString(cal));

			pSet(0);
			System.out.println("#" + tc + " " + maxScore);
		}

	} // main

	public static void pSet(int idx) {
		if (idx == N) {
			for (int k : listS) {
				sumScore += k;
			}
			for (int k : listC) {
				sumCal += k;
			}
			if (sumScore > maxScore && sumCal <= L) {
				maxScore = sumScore;
			}
//			System.out.println(Arrays.toString(listS));
//			System.out.println(Arrays.toString(listC));
//			System.out.println("");
			sumScore = 0;
			sumCal = 0;
			return;
		}

		pSet(idx + 1);
		listS[idx] = score[idx];
		listC[idx] = cal[idx];

		pSet(idx + 1);
		listS[idx] = 0;
		listC[idx] = 0;

	}

} // class
