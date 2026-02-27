package swea.d3_6485.city_samsung_busmap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_6485_PrefixSum {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(System.in);
		File input = new File("src\\swea\\d3_6485\\city_samsung_busmap\\s_input.txt");
		Scanner sc = new Scanner(input);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] busstop = new int[5001];
			for (int i = 0; i < N; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				busstop[A]++;
				if (B == 5000) {
					continue;
				}
				busstop[B+1]--;
			}
			int cnt = 0;
			for (int i = 1; i < 5001; i++) {
				busstop[i] += busstop[i-1];
			}

			int P = sc.nextInt();
			sb.append("#").append(tc);
			for (int i = 0; i < P; i++) {
				int k = sc.nextInt();
				sb.append(" ").append(busstop[k]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
