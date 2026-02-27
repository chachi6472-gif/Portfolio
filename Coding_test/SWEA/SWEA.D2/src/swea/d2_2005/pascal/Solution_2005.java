package swea.d2_2005.pascal;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_2005 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		File input = new File("src\\swea\\d2_2005\\pascal\\input.txt");
//		Scanner sc = new Scanner(input);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			int[][] arr = new int[N][N];
			
			for (int l = 0; l < N; l++) {
				arr[l][0] = 1;
				arr[l][l] = 1;
				for (int c = 1; c < l; c++) {
					arr[l][c] = arr[l - 1][c - 1] + arr[l - 1][c]; // 0213_Combination -> 아 이거 조합 식이었구나~
				}
			}

			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < i+1; j++) {
					System.out.print(arr[i][j]);
					if (j != i) {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
	}
}
