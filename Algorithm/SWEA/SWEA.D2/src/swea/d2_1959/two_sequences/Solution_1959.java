package swea.d2_1959.two_sequences;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_1959 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src\\swea\\d2_1959\\two_sequences\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] Ai = new int[N];
			int[] Bj = new int[M];
			for(int i = 0 ; i < N ; i++) {
				Ai[i] = sc.nextInt();
			}
			for(int i = 0 ; i < M ; i++) {
				Bj[i] = sc.nextInt();
			}
			
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < Math.abs(N - M) + 1; i++) {
				int currSum = 0;
				for (int j = 0; j < Math.min(N, M); j++) {
					if(N<M) {
						currSum += Ai[j] * Bj[i+j];
					} else {
						currSum += Ai[i+j] * Bj[j];
					}
				}
				if (currSum > max) {
					max = currSum;
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}
}
