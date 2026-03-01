package swea.d3_6485.city_samsung_busmap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_6485_arrSol {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(System.in);
		File input = new File("src\\swea\\d3_6485\\city_samsung_busmap\\s_input.txt");
		Scanner sc = new Scanner(input);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			int N = sc.nextInt();
			int[] busstop = new int[5001];
			int[] arrA = new int[N];
			int[] arrB = new int[N];
			
			for (int i = 0; i < N; i++) {
				arrA[i] = sc.nextInt();
				arrB[i] = sc.nextInt();
			}
			int P = sc.nextInt();
			int[] cnt = new int[P];
			int[] ans = new int[P];
			for (int i = 0; i < P; i++) {
				cnt[i] = sc.nextInt();
				for (int j = 0 ; j < N ; j++) {
					if(arrA[j]<=cnt[i] && arrB[j]>=cnt[i]) {
						ans[i]++;
					}
				}
			}
			sb.append("#").append(tc);
			for (int i = 0; i < P; i++) {
				sb.append(" ").append(ans[i]);
			}
			System.out.println(sb);
		}
	}
}