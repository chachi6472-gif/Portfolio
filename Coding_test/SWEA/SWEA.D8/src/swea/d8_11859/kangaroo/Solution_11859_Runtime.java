package swea.d8_11859.kangaroo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_11859_Runtime {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(System.in);
		File input = new File("src\\swea\\d8_11859\\kangaroo\\sample_input.txt");
		Scanner sc = new Scanner(input);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] arrA = new int[N];
			int[] arrB = new int[N];
			int[] arrC = new int[M];
			int[] arrD = new int[M];
			int[] jthMax = new int[M];

			for (int i = 0; i < N; i++) {
				arrA[i] = sc.nextInt();
				arrB[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				arrC[i] = sc.nextInt();
				arrD[i] = sc.nextInt();
			}

			for (int jth = 0; jth < M; jth++) {
				int C = arrC[jth];
				int D = arrD[jth];
				int cnt = 0;
				for (int ith = 0; ith < N; ith++) {
					if (cnt > jthMax[jth]) {
						jthMax[jth] = cnt;
					}
					if (arrA[ith] <= arrC[jth] && arrB[ith] >= arrD[jth]) {
						cnt++;
					} else if (arrA[ith] >= arrC[jth] && arrB[ith] <= arrD[jth]) {
						cnt++;
					} else if(arrA[ith] <= arrC[jth] && arrB[ith] <= arrD[jth] && arrB[ith] >= arrC[jth]) {
						cnt++;
					} else if(arrA[ith] >= arrC[jth] && arrB[ith] >= arrD[jth] && arrA[ith] <=arrD[jth]) {
						cnt++;
					}
					else {
						cnt = 0;
						continue;
					}
					if (cnt > jthMax[jth]) {
						jthMax[jth] = cnt;
					}
				}
			}

//			System.out.println(Arrays.toString(jthMax));
			
			int total = 0;
			for (int j = 0; j < M; j++) {
				total += (j+1)*jthMax[j];
			}

//			System.out.println(total);
			sb.append(total);
			System.out.println(sb);
			
//			2 < 6
//			5 < 9
			
			
//			[1,4]
//			2 5
//			1 3
//			6 6

//			[1,6]
//			2 5
//			1 3
//			6 6

//			[6,9]
//			2 5
//			1 3
//			6 6

		}
	}
}
