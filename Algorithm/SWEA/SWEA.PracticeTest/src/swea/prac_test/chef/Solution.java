package swea.prac_test.chef;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static int[] arr, listA, listB;
	public static int[][] table;
	public static int N, min;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src\\swea\\prac_test\\chef\\sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		// first trial : bit mask -> done
		// second trial : recursive ft.
		for (int tc = 1; tc <= T; tc++) {

			// make N x N table
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			table = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			} // input of this case is done

			// set arr to include index
			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = i;
			}
			listA = new int[N / 2];
			listB = new int[N / 2];
			min = 987654321;

			// use method
			getMin(0, 0);

			sb.append(min).append("\n");

		} // tc for
		System.out.println(sb);
	} // main

	public static void getMin(int idx, int sidx) {
		// end if
		if (sidx == N / 2) {
			// compute listB by listA
			// 이거 너무 구린데 재귀함수 구현 중에 listB를 만들 수는 없을까?
			// 오히려 조건 만족하면 뒤집는 거니까 이게 더 나은가?
			boolean[] barr = new boolean[N];
			for (int i = 0; i < N / 2; i++) {
				barr[listA[i]] = true;
			}
			for (int i = 0, k = 0; i < N; i++) {
				if (!barr[i]) {
					listB[k++] = i;
				}
			}
			// 뒤집기 시각화
//			System.out.println(Arrays.toString(listA));
//			System.out.println(Arrays.toString(listB));
//			System.out.println();
			int currSum = 0;
			for (int i = 0; i < N / 2 - 1; i++) {
				for (int j = i; j < N / 2; j++) {
					currSum += table[listA[i]][listA[j]] + table[listA[j]][listA[i]] - table[listB[i]][listB[j]]
							- table[listB[j]][listB[i]];
				}
			}
			currSum = Math.abs(currSum);
			if (min > currSum) {
				min = currSum;
			}

			return;
		}
//		if(idx>=N) {
//			return;
//		}

		// rec. part
		for (int i = idx; i <= N / 2 + sidx; i++) {
			listA[sidx] = arr[i];
			getMin(i + 1, sidx + 1);
		}

//		listA[sidx] = arr[idx];
//		getMin(idx + 1, sidx +1);
//		
//		getMin(idx + 1, sidx);

	}

}

// given condition :
// maximal tc = 50
// N in [4,16] , even
// S_ij in [1, 20,000] in Z | i != j
// if i == j, S_ij does not defined. -> S_ii = 0