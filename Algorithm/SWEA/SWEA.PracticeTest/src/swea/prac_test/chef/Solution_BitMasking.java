package swea.prac_test.chef;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_BitMasking {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src\\swea\\prac_test\\chef\\sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T
				; tc++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] table = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// input check - OK
//			System.out.println(Arrays.toString(table[0]));
//			System.out.println(Arrays.toString(table[1]));
//			System.out.println(Arrays.toString(table[2]));
//			System.out.println(Arrays.toString(table[3]));

			/*
			 * // [ this is wrong ] // #{elements of given set} = N -> N/2 digit number is
			 * in range [ 1 << (N/2) - // 1, 1 << (N/2) ) //
			 * System.out.println(Integer.toBinaryString(1 << (N / 2) - 1)); // if N = 4, 10
			 * // System.out.println(Integer.toBinaryString(1 << (N / 2))); // if N = 4, 100
			 * // System.out.println(1 << (N / 2) - 1); // if N = 4, 2 //
			 * System.out.println(1 << (N / 2)); // if N = 4, 4
			 */

			int min = 50000;
			// 1010
			for (int i = 0; i < 1 << N; i++) {

				int cnt = 0;
				boolean[] arr = new boolean[N]; // true : A | false : B
				int jMax = 32 - Integer.numberOfLeadingZeros(i);
				for (int j = 0; j < jMax; j++) {
//					System.out.println("i : " + i + " | j : " + j);
					if ((i & 1 << j) != 0) {
						arr[N - 1 - j] = true;
						cnt++;
					}
//					System.out.println("cnt : " + cnt);
					if (cnt > N / 2) {
//						System.out.println("*** 이 단계는 cnt 초과로 break ***");
						break;
					}

				} // choose elements of A and B
				
				if (cnt == N / 2) {
					
//					System.out.println("######## 이 단계에서 로직이 진행 ###########");
					int[] listA = new int[N/2];
					int[] listB = new int[N/2];
					for (int idx = 0, a = 0 , b = 0; idx < N; idx++) {
						if(arr[idx]) {
							listA[a++] = idx;
						} else {
							listB[b++] = idx;
						}
					} // make listA and listB for compute sum
					
					int sumA = 0;
					int sumB = 0;
					for(int f1 = 0 ; f1 < N/2 - 1 ; f1++) {
						for (int f2 = f1+1 ; f2 < N/2 ; f2++) {
							sumA += table[listA[f1]][listA[f2]] + table[listA[f2]][listA[f1]];
							sumB += table[listB[f1]][listB[f2]] + table[listB[f2]][listB[f1]];
						} // choose second
					} // choose first
					int diff = Math.abs(sumA - sumB);
					if (diff < min) {
						min = diff;
					}
//					System.out.println(Arrays.toString(listA));
//					System.out.println(Arrays.toString(listB));
					
				} // compute if cnt == N/2
				
				
//				System.out.println(Arrays.toString(arr));
//				System.out.println("---------------------------------");

			}
			System.out.println("#" + tc + " " + min);
		} // tc for
	} // main
}

// given condition :
// maximal tc = 50
// N in [4,16] , even
// S_ij in [1, 20,000] in Z | i != j
// if i == j, S_ij does not defined. -> S_ii = 0