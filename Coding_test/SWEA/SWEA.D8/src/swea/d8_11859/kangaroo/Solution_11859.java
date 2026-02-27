package swea.d8_11859.kangaroo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_11859 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] arrA = new int[N];
			int[] arrB = new int[N];
			int[] arrC = new int[M];
			int[] arrD = new int[M];
			int[] jthMax = new int[M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arrA[i] = Integer.parseInt(st.nextToken());
				arrB[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				arrC[i] = Integer.parseInt(st.nextToken());
				arrD[i] = Integer.parseInt(st.nextToken());
			}

			for (int jth = 0; jth < M; jth++) {
				int cnt = 0;
				for (int ith = 0; ith < N; ith++) {
					if(arrB[ith] >= arrC[jth] && arrA[ith] <= arrD[jth]) {
						cnt++;
					} else {
						cnt = 0;
						continue;
					}
					if (cnt > jthMax[jth]) {
						jthMax[jth] = cnt;
					}
				}
			}
			int total = 0;
			for (int j = 0; j < M; j++) {
				total += (j+1)*jthMax[j];
			}
			sb.append(total);
			System.out.println(sb);
			
			
			
			
//			for (int jth = 0; jth < M; jth++) {
//				int cnt = 0;
//				for (int ith = 0; ith < N; ith++) {
//					if(arrB[ith] >= arrC[jth] && arrA[ith] <= arrD[jth]) {
//						cnt++;
//					} else {
//						cnt = 0;
//						continue;
//					}
//					if (cnt > jthMax[jth]) {
//						jthMax[jth] = cnt;
//					}
//				}
//			}
//			int total = 0;
//			for (int j = 0; j < M; j++) {
//				total += (j+1)*jthMax[j];
//			}
//			sb.append(total);
//			System.out.println(sb);
		}
	}
}