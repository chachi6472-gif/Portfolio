package swea.d3_2817.sum_subsequence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_2817_Fail {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src\\swea\\d3_2817\\sum_subsequence\\sample_input.txt"));
		Scanner sc = new Scanner(System.in);

		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(sc.nextLine());
			int N = Integer.parseInt(st.nextToken()); // # seq A
			int K = Integer.parseInt(st.nextToken()); // Goal : sum of subseq.
			st = new StringTokenizer(sc.nextLine());
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			// 입력 잘 된다.
			System.out.println(N);
			System.out.println(K);
			System.out.println(Arrays.toString(arr));

			// 무식한 방법으로 해보자
			int cnt = 0;
			for (int numSubseq = 2; numSubseq < N+1; numSubseq++) {
				System.out.println("-------------------   " + numSubseq + "   ------------------------");
				for (int i = 0; i < N - numSubseq + 1; i++) {
					for (int j = 1; j < N-i; j++) { // dist
						int sum = 0;
						for (int k = 0; k < numSubseq; k++) {
							System.out.print("numSubseq : " + numSubseq + " | i : " + i + " | j : " + j + " | k : " + k);
							sum += arr[i + j*k];
							System.out.println(" | [i+j*k] : " + (i + j * k) + " | sum : " + sum);
						}
						if (sum == K) {
							cnt++;
						}
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
