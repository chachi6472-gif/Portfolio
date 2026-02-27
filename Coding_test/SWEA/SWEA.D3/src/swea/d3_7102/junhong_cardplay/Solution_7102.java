package swea.d3_7102.junhong_cardplay;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_7102 {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(System.in);
		File input = new File("src\\swea\\d3_7102\\junhong_cardplay\\sample_input.txt");
		Scanner sc = new Scanner(input);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[] arr = new int[N + M + 1];

			for (int i = 0; i <= N; i++) {
				for (int j = 0; j <= M; j++) {
					arr[i + j]++;
				}
			}

			int maxVal = 0;
			int numMaxVal = 0;

			for (int i = 0; i <= N + M; i++) {
				if (arr[i] > maxVal) {
					maxVal = arr[i];
					numMaxVal = 0;
				}
				if (arr[i] == maxVal) {
					numMaxVal++;
				}
			}
			int[] maxIdx = new int[numMaxVal];
			int idx = 0;

			for (int i = 0; i <= N + M; i++) {
				if (arr[i] == maxVal) {
					maxIdx[idx++] = i + 1;
				}
			}

			System.out.print("#" + tc + " ");
			for (int i = 0; i < maxIdx.length; i++) {

				System.out.print(maxIdx[i] + " ");
			}
			System.out.println();
		}

	}
}
