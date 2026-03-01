package swea.d3_2805.harvest_crops;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_2805 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src\\swea\\d3_2805\\harvest_crops\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];

			sc.nextLine();
			for (int i = 0; i < N; i++) {
				String str = sc.nextLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j) - 48;
				}
			}

			int total = 0;
			for (int r = 0; r < N; r++) {
				for (int c = Math.abs((N / 2) - r); c < N - Math.abs((N / 2) - r); c++) {
					total += arr[r][c];
				}
			}
			System.out.println("#" + tc + " " + total);
		}
	}
}