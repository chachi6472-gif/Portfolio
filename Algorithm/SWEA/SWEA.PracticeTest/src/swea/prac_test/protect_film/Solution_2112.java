package swea.prac_test.protect_film;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2112 {
	static int D, W, K, min;
	static int[] noneAB;
	static int[][] arr, Copy;
	static int[] cases;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src\\swea\\prac_test\\protect_film\\sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[D][W];
			Copy = new int[D][W];
			for (int r = 0; r < D; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			min = K;
			allCases();

			sb.append(min);
			System.out.println(sb);
		} // tc for
	} // main

	// it can have maximal complexity as 3^13 -> this is shit
	// is there unique solution for this problem? -> no
	// need to use this shit
	static void allCases() {
		cases = new int[D];
		int currMax = 0;

		// if given is satisfying the condition, then return with min = 0
		for (int c = 0; c < W; c++) {
			int numSeq = 1;
			int numMax = 0;
			for (int r = 1; r < D; r++) {
				if (arr[r - 1][c] == arr[r][c]) {
					numSeq++;
				} else {
					if (numSeq > numMax) {
						numMax = numSeq;
					}
					numSeq = 1;
				}
				if (numSeq >= K) {
					numMax = numSeq;
				}
			} // count continuous elements
			if (numMax < K) {
				currMax = numMax;
			}
		}
		if (currMax == 0) {
			min = 0;
			return;
		}

		// if cases[k] is 0, then Dk does not use A or B.
		// if cases[k] = 1 -> change kth-D into A
		// if cases[k] = 2 -> change kth-D into B
		while (true) {
			// check the case of this term
//			System.out.println(Arrays.toString(cases));
			if (min == 1)
				break;

			// make array Copy for deep copy
			for (int r = 0; r < D; r++) {
				for (int c = 0; c < W; c++) {
					Copy[r][c] = arr[r][c];
				}
			}

			// count #{A or B}
			int numD = 0;
			for (int i = 0; i < D; i++) {
				if (cases[i] != 0) {
					numD++;
				}
			}
			// cut the case that #{A} + #{B} >= K and move to next step
			// moreover, if number of A + B >= min => also move to next step
			if (numD >= min) {
				cases[0]++;
				for (int i = 0; i < D - 1; i++) {
					if (cases[i] > 2) {
						cases[i + 1]++;
						cases[i] = 0;
					}
				}
				if (cases[D - 1] == 3) {
					break;
				}
				continue;
			}

			// change the rows
			for (int d = 0; d < D; d++) {
				if (cases[d] == 0) {
					continue;
				}
				if (cases[d] == 1) { // change all into A
					for (int c = 0; c < W; c++) {
						Copy[d][c] = cases[d] - 1;
					}
				} else { // change all into B
					for (int c = 0; c < W; c++) {
						Copy[d][c] = cases[d] - 1;
					}
				}
			}

			// can it be passed?
			currMax = 0;
			for (int c = 0; c < W; c++) {
				int numSeq = 1;
				int numMax = 0;
				for (int r = 1; r < D; r++) {
					if (Copy[r - 1][c] == Copy[r][c]) {
						numSeq++;
					} else {
						if (numSeq > numMax) {
							numMax = numSeq;
						}
						numSeq = 1;
					}
					if (numSeq >= K) {
						numMax = numSeq;
					}
				} // count continuous elements
				if (numMax < K) {
					currMax = numMax;
					break;
				}
			}

			// if passed
			if (currMax == 0) {
				int cnt = 0;
				for (int i = 0; i < D; i++) {
					if (cases[i] != 0) {
						cnt++;
					}
				}
				if (cnt < min) {
					min = cnt;
				}
			}

			// step for next case
			cases[0]++;
			for (int i = 0; i < D - 1; i++) {
				if (cases[i] > 2) {
					cases[i + 1]++;
					cases[i] = 0;
				}
			}
			if (cases[D - 1] == 3) {
				break;
			}
		} // while for all cases
	} // method : allCases
} // class
