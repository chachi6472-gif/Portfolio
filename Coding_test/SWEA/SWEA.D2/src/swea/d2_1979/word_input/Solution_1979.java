package swea.d2_1979.word_input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_1979 {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(System.in);
		File input = new File("src\\swea\\d2_1979\\word_input\\input.txt");
		Scanner sc = new Scanner(input);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			int N = sc.nextInt();
			int len = sc.nextInt();
			int[][] arr = new int[N+2][N+2];
			int[][] arr2 = new int[N+2][N+2];
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					arr[i][j] = sc.nextInt();
					arr2[j][i] = arr[i][j];
				}
			}
			int total = 0;
			for (int r = 1; r < N+1; r++) {
				for (int c = 1; c < N - len + 2; c++) {
					int cnt = 0;
					int cnt2 = 0;
					for (int k = 0; k < len; k++) {
						if(arr[r][c+k] == 1) {
							cnt++;							
						}
						if(arr2[r][c+k] == 1) {
							cnt2++;							
						}
					}
					if (cnt == len && arr[r][c+len] == 0 && arr[r][c-1] == 0) {
						total++;
					}
					if (cnt2 == len && arr2[r][c+len] == 0 && arr2[r][c-1] == 0) {
						total++;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(total);
			System.out.println(sb);
		}
	}
}